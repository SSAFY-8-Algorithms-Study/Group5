import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K, ans;
    static char[][] A;
    static boolean[][] visit;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new char[R][];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) A[i] = br.readLine().toCharArray();
    }

    static void dfs(int x, int y, int move) {
        visit[x][y] = true;
        if (x == 0 && y == C - 1 && move == K){
            ans++;
            return;
        }
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0], ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (A[nx][ny] == 'T') continue;
            if (visit[nx][ny]) continue;
            visit[nx][ny] = true;
            dfs(nx, ny, move + 1);
            visit[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dfs(R-1, 0, 1);
        System.out.println(ans);
    }
}
