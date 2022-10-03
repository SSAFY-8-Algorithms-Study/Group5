import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int t, n;
    static Dot[] A;
    static List<Integer>[] graph;
    static boolean[] visit;
    static boolean found;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        A = new Dot[n+2];
        graph = new ArrayList[n + 2];
        for (int i = 0; i < n + 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (i == j) continue;
                int distance = Math.abs(A[i].x - A[j].x) + Math.abs(A[i].y - A[j].y);
                if (distance > 1000) continue;
                graph[i].add(j);
            }
        }
    }

    static class Dot {
        int x, y;
        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void dfs(int k) {
        if (found) return;
        visit[k] = true;
        if (n + 1 == k) {
            found = true;
        }
        for (int adj: graph[k]) {
            if (visit[adj]) continue;
            visit[adj] = true;
            dfs(adj);
            visit[adj] = false;
        }
    }

    static boolean bfs(int s) {
        Queue<Dot> Q = new LinkedList<>();
        Q.add(new Dot(A[s].x, A[s].y));
        visit[s] = true;
        while (!Q.isEmpty()) {
            Dot dot = Q.poll();
            if (dot.x == A[n+1].x && dot.y == A[n+1].y) return true;
            for (int i = 0; i < n + 2; i++) {
                if (visit[i]) continue;
                int distance = Math.abs(dot.x - A[i].x) + Math.abs(dot.y - A[i].y);
                if (distance > 1000) continue;
                visit[i] = true;
                Q.add(new Dot(A[i].x, A[i].y));
            }
        }
        return false;
    }

    static void pro() {
        visit = new boolean[n + 2];
        if(bfs(0)) {
            sb.append("happy\n");
        } else {
            sb.append("sad\n");
        }
    }

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int tt = 0; tt < t; tt++) {
            input();
            pro();
        }
        System.out.print(sb.toString());
    }
}
