import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1743_김아린 {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		graph = new int[N + 1][M + 1];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[r][c] = 1;
		}
		
		//구현
		visited = new boolean[N + 1][M + 1];
		
		int max = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(!visited[i][j] && graph[i][j] == 1) {
					visited[i][j] = true;
					count = 1;
					dfs(i, j);
					max = Math.max(max, count);
				}
			}
		}
		
		//출력
		System.out.println(max);
	}

	public static void dfs(int r, int c) {
		for(int i = 0; i < 4; i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			
			if(1 <= nx && nx <= N && 1 <= ny && ny <= M) {
				if(!visited[nx][ny] && graph[nx][ny] == 1) {
					visited[nx][ny] = true;
					dfs(nx, ny);
					count++;
				}
			}
		}
	}
}
