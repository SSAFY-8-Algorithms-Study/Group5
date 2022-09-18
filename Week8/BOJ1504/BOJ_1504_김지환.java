package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//특정한 최단 경로 
//방향성이 없는 그래프가 주어짐 
//세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다. 
// 또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것임. 
// 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있음.// 그럼 방문체크 안해도 되는건가? 
// 하지만 반드시 최단 경로로 이동해야 한다는 사실을 주의해야됨 .
// 1번 정점에서 N번 정점으로 이동할 때 주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오 
// 방향성이 없다? 양방향 그래프 
// 그럼 이렇게 합시다. 2번 3번 정점은 반드시 방문을 해야 되자나? 
// 2번 3번 방문체크를 하되 재방문을 할 수 있게 처리를 해야되는 건가? 
// 맞지 않나? 2번 3번은 반드시 방문을 해야되자나 아니지 그거랑은 상관여부가 없지 
// 한번 이동했던 정점은, 물론 한 번 이동했던 간선도 다시 이동할 수 있으므로 재방문을 할 수가 있다. 
// 최단 경로 : priorityqueue를 사용해야된다 가중치 기준으로 오름차순!!!
// 두 개의 서로 다른 정점번호는 반드시 거쳐야 된다??? 이것을 어떻게 처리할 것인가? 
// 이것을 리스트에 담아두고 방문체크를 할시 방문을 안했는가? continue 방문을 했는가? execute하면되겠는데? 

public class BOJ_1504_김지환 {
	
	public static class Node implements  Comparable<Node>{
		
		int to;
		int weight;
		public Node(int to, int weight) {
			
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
	}
	static int N,M;
	static List<Node>[] list;
	static int v1, v2;
	static int answer;
	static int[] cost;
	static boolean[] visited;
	static int INF = 200000000;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		cost = new int[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,weight));
			list[to].add(new Node(from, weight));
		}
		
		st = new StringTokenizer(in.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int result1 = 0;
		int result2 = 0;
		
		result1 += bfs(1,v1);
		result1 += bfs(v1, v2);
		result1 += bfs(v2,N);

		result2 += bfs(1,v2);
		result2 += bfs(v2, v1);
		result2 += bfs(v1,N);

		int result = 0;
		
		System.out.println(result1+" "+result2);
		if(result1 >= INF && result2 >= INF) {
			result = -1;
		}
		else {
			result = Math.min(result1, result2);
		}
		System.out.println(result);
	}
	private static int bfs(int start, int end) {
		//가중치 기준으로 오름차순 가중치가 낮은 것을 우선순위로 둚 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(visited, false);
		Arrays.fill(cost,INF);
		cost[start] = 0;
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
				Node now = pq.poll();
				if(visited[now.to]) continue;
				visited[now.to] = true;
				for(Node next : list[now.to]) {
					
						if(cost[next.to] > next.weight + now.weight) {
							cost[next.to] = next.weight + now.weight;
							pq.add(new Node(next.to, cost[next.to]));
						}
					
				}

			}
		return cost[end];
		
	}

}
