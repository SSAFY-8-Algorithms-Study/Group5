import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3187_김아린 {
    static int R, C;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int vCount;
    static int kCount;
    
    
    static class Dot{
        int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        graph = new char[R][C];
        
        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++) {
                graph[i][j] = line.charAt(j);
            }
        }
        
        //구현
        visited = new boolean[R][C];
        
        int sheep = 0;
        int wolf = 0;
        
        for(int i = 0; i < R; i++) { //같은 울타리 구하기
            for(int j = 0; j < C; j++) {
                if(graph[i][j] != '#' && !visited[i][j]) {
                    vCount = 0; //울타리 내 늑대 수
                    kCount = 0; //울타리 내 양의 수
                    
                    bfs(i, j);
                    
                    if(vCount < kCount) { //양이 더 많으면
                        sheep += kCount; //양만 살아남음
                    } else {
                        wolf += vCount; //늑대만 살아남음
                    }
                }
            }
        }
        
        //출력
        System.out.println(sheep + " " + wolf);
    }

    public static void bfs(int x, int y) {
        Queue<Dot> queue = new LinkedList<>();
        
        queue.add(new Dot(x, y));
        visited[x][y] = true;

        //같은 울타리 내 양과 늑대 수 세기
        if(graph[x][y] == 'v') {
            vCount++;
        } else if(graph[x][y] == 'k') {
            kCount++;
        }
        
        while(!queue.isEmpty()) {
            Dot dot = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];
                
                if(0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny]) {
                    if(graph[nx][ny] != '#') { //울타리x
                        queue.add(new Dot(nx, ny));
                        visited[nx][ny] = true;
                        
                        //같은 울타리 내 양과 늑대 수 세기
                        if(graph[nx][ny] == 'v') {
                            vCount++;
                        } else if(graph[nx][ny] == 'k') {
                            kCount++;
                        }
                    }
                }
            }
        }
    }

}
