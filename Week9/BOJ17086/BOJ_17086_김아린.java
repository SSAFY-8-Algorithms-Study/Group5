import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_김아린 {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	
			
	static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//구현
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited = new boolean[N][M];
				
				if(graph[i][j] == 0 ) {
					max = Math.max(max, bfs(i, j));
				}
			}
		}
		
		System.out.println(max);
	}

	public static int bfs(int x, int y) {
		Queue<Dot> queue = new LinkedList<>();
		
		queue.add(new Dot(x, y));
		visited[x][y] = true;
		
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				Dot dot = queue.poll();
				
				for(int j = 0; j < 8; j++) {
					int nx = dot.x + dx[j];
					int ny = dot.y + dy[j];
					
					if(0 <= nx && nx < N && 0 <= ny && ny < M) {
						if(!visited[nx][ny]) {
							
							if(graph[nx][ny] == 1) {
								return ++count;
							}
							
							queue.add(new Dot(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
			count++;
		}
		return count;
	}

}
