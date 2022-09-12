package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22116_김아린 {
	static int N;
	static int[][] A;
	static boolean[][] visited;
	static int[][] dist;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Dot implements Comparable<Dot> {
		int x, y, degree;

		public Dot(int x, int y, int degree) {
			this.x = x;
			this.y = y;
			this.degree = degree;
		}

		@Override
		public int compareTo(Dot o) {
			return this.degree - o.degree;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		A = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//구현
		visited = new boolean[N + 1][N + 1];
		dist = new int[N + 1][N + 1];
		
		for(int d[] : dist) { //거리 무한으로 초기화
			Arrays.fill(d, Integer.MAX_VALUE);
		}
		
		dijkstra(); //A1,1부터 탐색 시작
		
		//출력
		System.out.println(dist[N][N]);

	}

	public static void dijkstra() {
		PriorityQueue<Dot> queue = new PriorityQueue<>();
		
		queue.add(new Dot(1, 1, 0)); //A1,1부터 탐색 시작
		dist[1][1] = 0; //처음은 경사 0
		
		while(!queue.isEmpty()) {
			Dot dot = queue.poll();
			
			if(dot.x == N && dot.y == N) { //종료 조건
				return;
			}
			
			if(visited[dot.x][dot.y]) continue;
			
			visited[dot.x][dot.y] = true;
			
			for(int i = 0; i < 4; i++) { //상하좌우 탐색
				int nx = dot.x + dx[i];
				int ny = dot.y + dy[i];
				
				if(1 <= nx && nx <= N && 1 <= ny && ny <= N) { //그래프 안에 있고
					int degree = Math.abs(A[dot.x][dot.y] - A[nx][ny]); //경사
					int maxDegree = Math.max(dist[dot.x][dot.y], degree); //최대 경사
					
					if(maxDegree < dist[nx][ny]) { //더 최소인 곳이 있으면
						dist[nx][ny] = maxDegree;
						queue.add(new Dot(nx, ny, dist[nx][ny]));
					}
				}
			}
		}
	}

}
