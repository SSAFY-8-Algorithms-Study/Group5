import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]); //행
		M = Integer.parseInt(input[1]); //열
		
		graph = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String[] row = br.readLine().split(" ");
			
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		//처리
		int yearCount = 0;
		while(true) {
			//확인하기
			visited = new boolean[N][M];
			int groupCount = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(graph[i][j] != 0 && !visited[i][j]) { //빙산이 있고 방문x
						check(i, j);
						groupCount++;
					}
				}
			}
			
			if(groupCount == 2) break;
			
			//녹이기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(graph[i][j] == 0) {
						melt(i, j);
					}
				}
			}
			
			yearCount++;
		}
		
		//출력
		System.out.println(yearCount);
		
	}

	private static void check(int v1, int v2) {
		visited[v1][v2] = true; //정점 방문
		
		for(int i = 0; i < 4; i++) { //상하좌우 탐색
			int nx = v1 + dx[i];
			int ny = v2 + dy[i];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < M) { //좌표 범위 안에 있고
				if(graph[nx][ny] != 0 && !visited[nx][ny]) { //빙산이 있고 방문x이면
					check(nx, ny); //탐색
				}
			}
		}
	}

	private static void melt(int v1, int v2) {
		for(int i = 0; i < 4; i++) { //상하좌우 탐색
			int nx = v1 + dx[i];
			int ny = v2 + dy[i];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < N && graph[nx][ny] != 0) //좌표 범위 안에 있으면
				graph[nx][ny]--; //녹이기
		}
	}

}
