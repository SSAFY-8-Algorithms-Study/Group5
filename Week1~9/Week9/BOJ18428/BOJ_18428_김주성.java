import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] A;
    static List<Dot> blankList, teacherList;
    static boolean[] select;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static String ans;

    static class Dot {
        int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new char[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = st.nextToken().charAt(0);
            }
        }
    }

    static boolean calculation(Dot[] result) {
        boolean[][] obstacle  = new boolean[N][N]; // 장애물
        for (int i = 0; i < 3; i++) {
            obstacle[result[i].x][result[i].y] = true;
        }
        for (Dot teacher: teacherList) {
            int x = teacher.x, y = teacher.y;
            for (int k = 0; k < 4; k++) {
                for (int i = 0; i < N; i++) {
                    int nx = x + dir[k][0] * i, ny = y + dir[k][1] * i;
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                    if (obstacle[nx][ny]) break;
                    if (A[nx][ny] == 'S') return false;
                }
            }
        }
        return true;
    }

    static void rec_func(int k, int cnt) {
        if (cnt == 3) {
            Dot[] result = new Dot[3];
            int b = 0;
            for (int i = 0; i < blankList.size(); i++) {
                if (select[i]) {
                    result[b] = blankList.get(i);
                    b++;
                }
            }
            if(calculation(result)) {
                ans = "YES";
            }
            return;
        }
        if (k >= blankList.size()) return;
        select[k] = true;
        rec_func(k + 1, cnt + 1);
        select[k] = false;
        rec_func(k + 1, cnt);
    }

    static void pro() {
        blankList = new ArrayList<>();
        teacherList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(A[i][j] == 'X') blankList.add(new Dot(i, j));
                if(A[i][j] == 'T') teacherList.add(new Dot(i, j));
            }
        }
        select = new boolean[blankList.size()];
        ans = "NO";
        rec_func(0, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
