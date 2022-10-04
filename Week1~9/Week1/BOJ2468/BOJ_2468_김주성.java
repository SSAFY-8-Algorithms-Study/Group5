import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static byte[][] hills;
    static int[] nx = {0, 0, 1, -1};
    static int[] ny = {-1, 1, 0, 0};
    static byte[][] visit;
    static int N;
    static int count = 1;

    public static void dfs(int x, int y, int min){
        visit[x][y] = 1;
        for(int i = 0 ; i < 4; i++){
            int next_x = x + nx[i];
            int next_y = y + ny[i];
            if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < N){
                if(hills[next_x][next_y] >= min && visit[next_x][next_y] == 0){
                    dfs(next_x, next_y, min);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        hills = new byte[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int height = Integer.parseInt(st.nextToken());
                hills[i][j] =(byte) height;
            }
        }
        int max_count = 0;
        for(int height = 1 ; height <= 100; height++){
            visit = new byte[N][N];
            count = 0;
            for(int u = 0; u < N; u++){
                for(int v = 0; v < N; v++){
                    if(hills[u][v] >= height && visit[u][v] == 0){
                        count++;
                        dfs(u, v, height);
                    }
                }
            }
            max_count = Math.max(max_count, count);
        }
        System.out.println(max_count);
    }
}
