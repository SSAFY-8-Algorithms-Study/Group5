import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_김주성 {
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j + 1] = str.charAt(j);
            }
        }
    }

    static int N, M, ans;
    static char[][] board;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        boolean[][] visit = new boolean[N + 1][M + 1];
        visit[1][1] = true;
        Q.add(1); // x
        Q.add(1); // y
        Q.add(1); // 이동 횟수
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll(), move = Q.poll();
            if (x == N && y == M) { // 정답을 찾았으면 정답 업데이트
                ans = Math.max(ans, move);
                continue;
            }
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (visit[nx][ny]) continue;
                if (board[nx][ny] != '1') continue;
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
                Q.add(move + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        System.out.println(ans); // 정답 출력
    }
}
