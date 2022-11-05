import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max_size, ans;
    static int[][] A;
    static boolean found;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static boolean[][] visited, max_group, visited_common;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int[] bfs(int sx, int sy, int color) {
        int[] info = new int[2]; // 0: 블록 수, 1: 무지개 블록 수
        visited = new boolean[N][N];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        Q.add(sy);
        visited[sx][sy] = true;
        visited_common[sx][sy] = true;
        info[0]++;
        while (!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (A[nx][ny] < 0) continue; // 검은색 ro 빈공간 이면
                if (A[nx][ny] > 0 && A[nx][ny] != color) continue;// 무지개가 아니고 기준색과 다른색 블록이면
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if (A[nx][ny] != 0) visited_common[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
                info[0]++;
                if (A[nx][ny] == 0) info[1]++;
            }
        }

        return info;
    }

    static boolean findGroup() {
        // 기준 블록: 행 번호 가장 작은 > 열 번호 가장 작은, 무지개x
        // 가장 큰 그룹: 블록 수 > 무지개 블럭 수 >  기준 블록의 행 번호 큰것 > 기준 블록의 열 번호 큰것
        max_group = new boolean[N][N]; // 최대 그룹의 블록
        visited_common = new boolean[N][N];
        max_size = 0; // 그룹의 크기
        int rainbow = 0;
        for (int i = 0; i < N; i++) { // 행
            for (int j = 0; j < N; j++) { // 열
                if (A[i][j] <= 0) continue; // 검은색 or 무지개 이면 or 빈공간
                if (visited_common[i][j]) continue; // 방문한 일반 블록이면
                int[] info = bfs(i, j,  A[i][j]);
//                System.out.println("size:" + size);
                if (info[0] > max_size) { // 블록이 많은 그룹
                    max_size = info[0];
                    max_group = visited;
                    rainbow = info[1];
                } else if (info[0] == max_size && info[1] > rainbow) { // 무지개 블록 수가 많은 그룹
                    max_group = visited;
                    rainbow = info[1];
                } else if (info[0] == max_size && info[1] == rainbow) { // 행 번호 큰, 열 번호 큰 그룹
                    max_group = visited;
                }
            }
        }

        return max_size > 1; // 그룹의 크기가 2이상이면 true
    }

    static void getScore() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (max_group[i][j]) {
                    A[i][j] = -10;
                }
            }
        }

        ans += max_size * max_size;
    }

    static void rotate() {
        // 90도 반시계 방향으로 회전
        int[][] new_A = new int[N][N];
        int x = 0;
        for (int j = N - 1; j >= 0; j--) {
            for (int i = 0; i < N; i++) {
                new_A[x][i] = A[i][j];
            }
            x++;
        }
        A = new_A;
    }

    static void gravity() {
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] >= 0) { // 일반 or 무지개 이면
                    int x = i, nx = i;
                    for (int k = 0; k < N; k++) {
                        nx++;
                        if (nx >= N) continue;
                        if (A[nx][j] >= -1) break; // 블록이 있으면
                        x = nx; // 한칸 내려간다
                    }
                    if (x != i) {
                        A[x][j] = A[i][j];
                        A[i][j] = -10;
                    }
                }
            }
        }
    }

    static void pro() {
        // -10: 빈공간, -1: 검은색, 0: 무지개, 1,2,3,4,5: 일반
//        print(A, "A");
        found = findGroup(); // 1. 크기가 가장 큰 블록 그룹을 찾는다.
//        print(max_group, "B");
        while(found) {
            getScore(); // 2. 1 에서 찾은 블록 그룹을 삭제한다. 점수를 획득한다.
//            System.out.println("2");
//            print(A, "A");
//            System.out.println("score: " + ans);
            gravity(); // 3. 중력이 작용한다.
//            System.out.println("3");
//            print(A, "A");
            rotate(); // 4. 90도 반시계 방향으로 회전한다.
//            System.out.println("4");
//            print(A, "A");
            gravity(); // 5. 중력이 작용한다.
//            System.out.println("5");
//            print(A, "A");
            found = findGroup(); // 1. 크기가 가장 큰 블록 그룹을 찾는다.
//            print(max_group, "B");
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
//
//    static void print(int[][] arr, String n) {
//        System.out.println("-----------------"+n+"---------------------");
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if (arr[i][j] == -10) {
//                    System.out.print("-- ");
//                } else if (arr[i][j] >= 0){
//                    System.out.print("0"+arr[i][j] + " ");
//                } else {
//                    System.out.print(arr[i][j] + " ");
//                }
//            }
//            System.out.println();
//        }
//    }
//
//    static void print(boolean[][] arr, String n) {
//        System.out.println("-----------------"+n+"---------------------");
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if (arr[i][j]) {
//                    System.out.print(1 + " ");
//                } else {
//                    System.out.print(0 + " ");
//                }
//            }
//            System.out.println();
//        }
//    }
}
