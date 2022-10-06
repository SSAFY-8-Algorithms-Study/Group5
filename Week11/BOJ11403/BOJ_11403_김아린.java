import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403_김아린 {
	static int N;
	static int[][] graph;
	static final int INF = 101;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < N; j++) {
				int route = Integer.parseInt(st.nextToken());
				
				if(route == 0) {
					graph[i][j] = INF;
				} else {
					graph[i][j] = route;
				}
			}
		}
		
		floyd_warshall();
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(graph[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(graph[i][j] != INF) {
					sb.append(1 + " ");
				} else {
					sb.append(0 + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	public static void floyd_warshall() {
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] =  graph[i][k] + graph[k][j];
					}
				}
			}
		}
	}

}
