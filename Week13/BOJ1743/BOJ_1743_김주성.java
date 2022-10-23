import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, ans;
    static int A[][];
    static boolean[][] visit;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N+1][M+1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x][y] = 1;
        }

        visit = new boolean[N+1][M+1];
        ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i][j] == 1 && !visit[i][j]) bfs(i, j);
            }
        }
        System.out.println(ans);
    }

    static void bfs(int sx, int sy) {
        int size = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        Q.add(sy);
        visit[sx][sy] = true;
        size++;
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx <= 0 || ny <= 0 || nx > N || ny > M) continue;
                if (A[nx][ny] != 1) continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
                size++;
            }
        }
        ans = Math.max(ans, size);
    }
}
