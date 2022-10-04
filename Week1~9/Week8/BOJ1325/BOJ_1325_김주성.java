import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] graph;
    static int N, M, max;
    static boolean[] visit;
    static int[] hacking;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        hacking = new int[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
    }

    static void dfs(int n) {
        visit[n] = true;
        for (int next: graph[n]) {
           if (!visit[next]) {
               hacking[next]++;
               visit[next] = true;
               dfs(next);
           }
        }
    }

    static void pro() {
        for (int node = 1; node <= N; node++) {
            visit = new boolean[N + 1];
            dfs(node);
        }

        max = Integer.MIN_VALUE;
        for (int node = 1; node<= N; node++) {
            max = Math.max(max, hacking[node]);
        }

        for (int node = 1; node<= N; node++) {
            if (hacking[node] == max) sb.append(node).append(' ');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
