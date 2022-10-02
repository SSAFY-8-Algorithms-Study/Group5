import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189_김아린 {
	static int R, C, K;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			
			for(int j = 0; j < C; j++) {
				graph[i][j] = input.charAt(j);
			}
		}
		
		//구현
		visited = new boolean[R][C];
		answer = 0;
		
		dfs(R - 1, 0, 1);
		
		//출력
		System.out.println(answer);
	}

	public static void dfs(int x, int y, int count) {
		if(x == 0 && y == C - 1) { //집까지 도착
			if(count == K) { //거리가 K인 경우
				answer++;
			}
			
			return;
		}
		
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) { //상하좌우 탐색
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0 <= nx && nx < R && 0 <= ny && ny < C) { //좌표 범위 안에 있고
				if(!visited[nx][ny] && graph[nx][ny] == '.') { //지금까지 방문한 적 없고, 갈 수 있으면
					dfs(nx, ny, count + 1);
				}
			}
		}
		
		visited[x][y] = false; //백트래킹을 위한 방문 체크 해제
	}

}
