import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070_김아린 {
	static int N;
	static int[][] graph;
	static int[][] 	horizontal = {{0, 1}, {1, 1}}; //가로, 대각선
	static int[][] 	vertical = {{1, 0}, {1, 1}}; //세로, 대각선
	static int[][] 	diagonal  = {{0, 1}, {1, 0}, {1, 1}}; //가로, 세로, 대각선
	static int count = 0;
	
	static class Dot {
		int x, y; //파이프의 끝점 좌표
		int dir; //1-가로, 2-세로, 3-대각선
		
		public Dot(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N + 1][N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j < N + 1; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		 
		if(graph[N][N] == 1) {
			System.out.println(0);
		}else {
			bfs();
			System.out.println(count);
		}
	}

	public static void bfs() {
		Queue<Dot> queue = new LinkedList<>();
		
		queue.add(new Dot(1, 2, 1)); //처음 시작
		
		while(!queue.isEmpty()) {
			Dot dot = queue.poll();
			
//			System.out.println(dot.x + " " + dot.y + " " + dot.dir);
			
			int dir = dot.dir;
			
			if(dir == 1) { //가로면
				for(int i = 0; i < horizontal.length; i++) {
					int nx = dot.x + horizontal[i][0];
					int ny = dot.y + horizontal[i][1];
					
					if(1 <= nx && nx <= N && 1 <= ny && ny <= N) {
						if(i == 0) { //가로로 밀기
							if(graph[nx][ny] != 1) { //벽이 없음
								if(nx == N && ny == N) {
									count++;
								}else {
									queue.add(new Dot(nx, ny, 1));
								}
							}
						}else if(i == 1) { //대각선으로 밀기
							if(graph[nx][ny] != 1 && graph[nx - 1][ny] != 1 && graph[nx][ny - 1] != 1) { //벽이 없음
								if(nx == N && ny == N) {
									count++;
								}else {
									queue.add(new Dot(nx, ny, 3));
								}
							}
						}
		
					}
				}
			}else if(dir == 2) { //세로면
				for(int i = 0; i < vertical.length; i++) {
					int nx = dot.x + vertical[i][0];
					int ny = dot.y + vertical[i][1];
					
					if(1 <= nx && nx <= N && 1 <= ny && ny <= N) {
						if(i == 0) { //세로로 밀기
							if(graph[nx][ny] != 1) { //벽이 없음
								if(nx == N && ny == N) {
									count++;
								}else {
									queue.add(new Dot(nx, ny, 2));
								}
							}
						}else if(i == 1) { //대각선으로 밀기
							if(graph[nx][ny] != 1 && graph[nx - 1][ny] != 1 && graph[nx][ny - 1] != 1) { //벽이 없음
								if(nx == N && ny == N) {
									count++;
								}else {
									queue.add(new Dot(nx, ny, 3));
								}
							}
						}
					}
				}
			}else if(dir == 3) { //대각선이면
				for(int i = 0; i < diagonal.length; i++) {
					int nx = dot.x + diagonal[i][0];
					int ny = dot.y + diagonal[i][1];
					
					if(1 <= nx && nx <= N && 1 <= ny && ny <= N && graph[nx][ny] != 1) {
						if(i == 0) { //가로로 밀기
							if(graph[nx][ny] != 1) { //벽이 없음
								if(nx == N && ny == N) {
									count++;
								}else {
									queue.add(new Dot(nx, ny, 1));
								}
							}
						}else if(i == 1) { //세로로 밀기
							if(graph[nx][ny] != 1) { //벽이 없음
								if(nx == N && ny == N) {
									count++;
								}else {
									queue.add(new Dot(nx, ny, 2));
								}
							}
						}else if(i == 2) { //대각선으로 밀기
							if(graph[nx][ny] != 1 && graph[nx - 1][ny] != 1 && graph[nx][ny - 1] != 1) { //벽이 없음
								if(nx == N && ny == N) {
									count++;
								}else {
									queue.add(new Dot(nx, ny, 3));
								}
								
							}
						}
					}
				}
			}
		}
	}

}
