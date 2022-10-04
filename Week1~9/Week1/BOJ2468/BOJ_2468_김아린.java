import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static ArrayList<Integer> height; //높이 배열
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		height = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			String[] row = br.readLine().split(" ");
			
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(row[j]);
				
				if(!height.contains(graph[i][j])) //새로운 높이면
					height.add(graph[i][j]); //높이 배열에 담는다
			}
		}
		
		int max = 1; //초기값이 1이여야 한다(비가 안내리는 경우)
		for(int h : height) {
			visited = new boolean[N][N]; //방문 초기화 여기서 해주기
			int count = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(graph[i][j] > h && !visited[i][j]) { //잠겨있지 않고 방문x
						dfs(i, j, h); //탐색 시작
						count++;
					}
				}
			}
			max = Math.max(max, count);
		}
		
		System.out.println(max);
	}


	private static void dfs(int v1, int v2, int h) {
		visited[v1][v2] = true; //정점 방문
		
		for(int i = 0; i < 4; i++) { //상하좌우 탐색
			int nx = v1 + dx[i];
			int ny = v2 + dy[i];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < N) { //좌표 범위 안에 있고
				if(graph[nx][ny] > h && !visited[nx][ny]) { //잠겨있지 않고 방문x
					dfs(nx, ny, h);
				}
			}
		}


	}

}
