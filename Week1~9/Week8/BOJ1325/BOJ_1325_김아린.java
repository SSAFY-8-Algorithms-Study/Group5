import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325_김아린 {
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
		}
		
		count = new int[N + 1];
		
		int max = 0;
		for(int i = 1; i < N + 1; i++) {
			visited = new boolean[N + 1];
//			System.out.println("i: " + i);
			bfs(i); //각 컴퓨터가 해킹할 수 있는 컴퓨터 수
//			System.out.println();
		}
		
		for(int i = 1; i < N + 1; i++) { //한 번에 해킹할 수 있는 컴퓨터 최대
			max = Math.max(max, count[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N + 1; i++) { //max 값 오름차순 출력
			if(max == count[i]) {
				sb.append(i + " ");
			}
		}
		
		System.out.print(sb);
	}
	
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			
			for(int i : graph[p]) {
				if(!visited[i]) {
//					System.out.println(v + " " + i);
					count[i]++; //B를 해킹하면, A도 해킹할 수 있다
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		
	}

}
