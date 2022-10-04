import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] count;
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
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
		visited = new boolean[N][M];
		count = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			
			for(int j = 0; j < M; j++) {
				graph[i][j] = row.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		
		System.out.println(count[N - 1][M -1]);
	}

	private static void bfs(int v1, int v2) {
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.add(new Point(v1, v1));
		visited[v1][v2] = true;
		count[v1][v2] =1;
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			if(point.x == N - 1 && point.y == M - 1)
				break;
			
			for(int i = 0; i < 4; i++) { //상하좌우 탐색
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M) { //좌표 범위 안에 있고
					if(graph[nx][ny] == 1 && !visited[nx][ny]) { //이동 가능하고 방문하지 않았으면
						queue.add(new Point(nx, ny)); //큐에 넣음
						visited[nx][ny] = true;
						count[nx][ny] = count[point.x][point.y] +1;
					}
				}
			}
		}
	}

}
