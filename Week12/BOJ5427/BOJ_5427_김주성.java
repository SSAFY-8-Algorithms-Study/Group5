import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int w, h, ans;
    static char[][] A;
    static boolean[][] visit;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        A = new char[h][];
        visit = new boolean[h][w];
        for (int i = 0 ; i < h; i++) A[i] = br.readLine().toCharArray();
    }

    static class Dot {
        int type, x, y;

        public Dot(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        Queue<Dot> Q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (A[i][j] == '*') Q.add(new Dot(0, i, j));
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (A[i][j] == '@') {
                    Q.add(new Dot(1, i, j));
                    visit[i][j] = true;
                }
            }
        }

        int move = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int s = 0; s < size; s++) {
                Dot dot = Q.poll();
                if (dot.type == 1 && (dot.x == 0 || dot.y == 0 || dot.x == h -1 || dot.y == w -1)) {
                    ans = move + 1;
                    return;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = dot.x + dir[k][0], ny = dot.y + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    if (A[nx][ny] == '#') continue;
                    if (dot.type == 0) {
                        if (A[nx][ny] == '*') continue;
                        A[nx][ny] = '*';
                        Q.add(new Dot(0, nx, ny));
                    } else if (dot.type == 1) {
                        if (A[nx][ny] == '*') continue;
                        if (visit[nx][ny]) continue;
                        visit[nx][ny] = true;
                        Q.add(new Dot(1, nx, ny));
                    }
                }
            }
            move++;
        }
    }

    static void pro() {
        ans = -1;
        bfs();
        System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }
    }
}
