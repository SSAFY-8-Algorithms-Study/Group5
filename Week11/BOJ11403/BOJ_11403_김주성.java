import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static
    int[][] adj;
    static int[][] ans;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        ans = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void bfs(int sx) {
        boolean visit[] = new boolean[N];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (int k = 0; k < N; k++) {
                if (adj[x][k] == 0) continue;
                if (visit[k]) continue;
                visit[k] = true;
                Q.add(k);
                ans[sx][k] = 1;
            }
        }
    }

    static void pro() {
        for (int n = 0; n < N; n++) {
            bfs(n);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
