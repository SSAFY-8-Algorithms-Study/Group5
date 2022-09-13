import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2310_김아린 {
	static int n;
	static ArrayList<Integer>[] graph;
	static ArrayList<Node> list;
	static boolean[] visited;
	static boolean isPossible;
	
	static class Node {
		int idx;
		char content;
		int cost;
		
		public Node(int idx, char content, int cost) {
			this.idx = idx;
			this.content = content;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			n = Integer.parseInt(br.readLine());
		
			if(n == 0) break; //입력 종료
			
			graph = new ArrayList[n + 1]; //그래프 생성
			for (int i = 1; i < n + 1; i++) {
				graph[i] = new ArrayList<>();
			}

			list = new ArrayList<>();
			
			for(int i = 1; i <= n; i++) { //각 방 정보 입력
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				char content = st.nextToken().charAt(0);
				int cost = Integer.parseInt(st.nextToken());
				
				while(true) {
					String s = st.nextToken();
					
					if(s.equals("0")) break;
					
					int to = Integer.parseInt(s);
					
					graph[i].add(to);
				}
				
				list.add(new Node(i, content, cost));
			}
			
			//1번 방에서 출발
			visited = new boolean[n + 1];
			visited[1] = true;
			isPossible = false;
			
			dfs(1, 0);
			
			//출력
			if(isPossible) {
				sb.append("Yes\n");
			}else {
				sb.append("No\n");
			}
			
//			System.out.println();
		}
		
		System.out.println(sb);
	}

	public static void dfs(int idx, int money) {
//		System.out.println(idx + " " + money);
		
		if(idx == n) {
			isPossible = true;
			return;
		}
		
		for(int i = 0; i < graph[idx].size(); i++) {
			if(visited[graph[idx].get(i)]) continue;
			
			visited[graph[idx].get(i)] = true;
			
			char content = list.get(graph[idx].get(i) - 1).content;
			int cost = list.get(graph[idx].get(i) - 1).cost;
			
			if(content == 'E') { //빈방
				dfs(graph[idx].get(i), money);
			}else if(content == 'L') { //레프리콘
				if(money < cost) { //일정량 미만이면 채워주기
					money = cost;
				}
				
				dfs(graph[idx].get(i), money);
			}else if(content == 'T') { //트롤
				money -= cost;
				
				if(money >= 0) {
					dfs(graph[idx].get(i), money);
				}
			}
			
			visited[graph[idx].get(i)] = false;
		}
	}

}
