import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1504_김아린 {
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int[] dist;
	
	static class Node implements Comparable<Node> {
		int v;
		int w;
		
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		for(int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c)); //양방향 길이 존재
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		//구현
		long r1 = 0; //case1: 1~v1~v2~N
		long r2 = 0; //case2: 1~v2~v1~N
		
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(1);
		
		r1 += dist[v1]; //case1: 1~V1
		r2 += dist[v2]; //case1: 1~V2
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(v1);
		
		r1 += dist[v2]; //case1: v1~v2
		r2 += dist[v2]; //case2: v1~v2
		r2 += dist[N]; //case2: v2~N
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(v2);
		
		r1 += dist[N]; //case1: v2~N
		
		//결과
		long answer = Math.min(r1, r2);
		
		if(answer < Integer.MAX_VALUE) {
			System.out.println(answer);
		}else {
			System.out.println(-1);
		}
	}
	
	public static void dijkstra(int start) {
		Queue<Node> queue = new PriorityQueue<>();
		
		queue.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(Node next : list[node.v]) {
				if(dist[node.v] + next.w < dist[next.v]) {
					dist[next.v] = dist[node.v] + next.w;
					queue.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}

}
