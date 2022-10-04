package day0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9372_김지환 {

	
	static List<Integer>[] list;
	static boolean[] visited;
	static int depth;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			list = new ArrayList[N+1];
			visited = new boolean[N+1];
			for(int i=1;i<=N;i++) {
				list[i] = new ArrayList<>();
			}
			for(int i=0; i<M;i++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				list[to].add(from);
			}
			depth = 0;
			dfs(1);
			sb.append(depth).append("\n");
//			System.out.println(depth);
		}
		System.out.println(sb);
	}
	private static void dfs(int vertex) {
		visited[vertex] = true;
//		System.out.print(vertex+" ");
		
		for(int idx : list[vertex]) {
			if(visited[idx]) continue;
			dfs(idx);
			depth++;
		}
	}
}
