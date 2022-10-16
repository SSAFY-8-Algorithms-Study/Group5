import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1388_김아린 {
	static int N, M;
	static char[][] graph;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());	
		M = Integer.parseInt(st.nextToken());	
	
		graph = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < M; j++) {
				graph[i][j] = line.charAt(j);
			}
		}
		
		//구현
		visited = new boolean[N][M];
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					dfs(i, j, graph[i][j]);
					visited[i][j] = true;
					count++;
				}
			}
		}
		
		//출력
		System.out.println(count);
	}

	public static void dfs(int i, int j, char c) {
		int ni = i;
		int nj = j;
		
		if(graph[i][j] == '-') {
			nj += 1;

			if(nj < M && !visited[ni][nj] && graph[ni][nj] == '-') {
				dfs(ni, nj, graph[ni][nj]);
				visited[ni][nj] = true;
			}
		} else if(graph[i][j] == '|') {
			ni += 1;

			if(ni < N && !visited[ni][nj] && graph[ni][nj] == '|') {
				dfs(ni, nj, graph[ni][nj]);
				visited[ni][nj] = true;
			}
		}
	}
}
