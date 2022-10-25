import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;

    static int res, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }
        ans = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    res = bfs(i, j) + 1;
                    ans = Math.max(ans,res);
                }
            }
        }
        System.out.println(ans);
    }

        private static int bfs (int i, int j){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{i, j});
            visited[i][j] = true;
            int count = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int s = 0; s < size; s++) {
                    int[] now = queue.poll();
                    for (int d = 0; d < 4; d++) {
                        int ni = now[0] + di[d];
                        int nj = now[1] + dj[d];

                        if (ni >= 1 && ni <= N && nj >= 1 && nj <= M) {
                            if (map[ni][nj] == 1 && !visited[ni][nj]) {
                                visited[ni][nj] = true;
                                count++;
                                queue.add(new int[]{ni, nj});
                            }
                        }
                    }
                }
            }
        return count;
        }

    }
