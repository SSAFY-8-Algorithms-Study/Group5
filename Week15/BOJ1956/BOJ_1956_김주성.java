import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int V, E, ans;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V+1][V+1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                dist[i][j] = 10000 * 400 + 1; // 오버플로우나지 않는 적당히 큰값
                if (i == j) dist[i][j] = 0;
            }
        }

        for (int i = 0; i < E; i++) { // k == 0 인 경우, 다른 정점을 방문하지 않고 도착하는 경우
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[a][b] = w;
        }

        for (int k = 1; k <= V; k++) { // 경로지
            for (int i = 1; i <= V; i++) { // 출발지
                for (int j = 1; j <= V; j++) { // 도착지
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        ans = 10000 * 400 + 1;
        // 최단 사이클 구하기
        for (int i = 1; i <= V; i++) {
            for (int j = i + 1; j <= V; j++) {
                ans = Math.min(ans, dist[i][j] + dist[j][i]);
            }
        }

        // 정답 출력
        System.out.println(ans >= 10000 * 400 + 1 ? -1 : ans);
    }
}
