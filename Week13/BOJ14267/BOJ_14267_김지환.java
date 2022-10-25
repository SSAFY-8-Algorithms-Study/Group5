import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] adj;
    static boolean[] visited;
    static int N;
    static int[]praise;
    static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        dp = new int[N+1];
        praise = new int[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(in.readLine());
        for(int i=1; i<=N;i++) {
            int superior =  Integer.parseInt(st.nextToken());
            if(superior == -1 )continue;
            else {
                adj[superior].add(i);
            }
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(in.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            praise[idx] += w;
        }
        visited[1] = true;
        dfs(1);
        for(int i=1; i<=N; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.print(sb);
    }
    private static void dfs(int node) {
        for(int next : adj[node]) {
            if(!visited[next]) {
                visited[next] = true;
                dp[next] = dp[node]  + praise[next];
                dfs(next);
            }
        }
    }

}
