import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] A;
    static boolean[][] visit;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static int[] ans;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new char[R][];
        for (int i = 0; i < R; i++) {
            A[i] = br.readLine().toCharArray();
        }
        ans = new int[2];
        visit = new boolean[R][C];
    }

    static void bfs(int sx, int sy) {
        int sheep = 0;
        int wolf = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        Q.add(sy);
        visit[sx][sy] = true;
        if (A[sx][sy] == 'k') sheep++;
        if (A[sx][sy] == 'v') wolf++;
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (A[nx][ny] == '#') continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
                if (A[nx][ny] == 'k') sheep++;
                if (A[nx][ny] == 'v') wolf++;
            }
        }
        // 양들의 숫자가 늑대의 숫자보다 더 많을 경우
        if (sheep > wolf) {
            ans[0] += sheep;
        } else {
            ans[1] += wolf;
        }
    }

    static void pro() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == '#') continue;
                if (visit[i][j]) continue;
                bfs(i, j);
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
