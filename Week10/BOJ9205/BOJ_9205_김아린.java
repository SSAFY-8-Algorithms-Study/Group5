import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_김아린 {
	static int n;
	static Dot[] stores;
	static boolean[] visited;
	
	static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); //테스트 케이스의 개수
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) { 
			n = Integer.parseInt(br.readLine()); //편의점의 개수
			
			//상근이네 집 좌표
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			
			stores = new Dot[n];
			
			//편의점 좌표
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				
				//배열에 담기
				stores[i] = new Dot(cx, cy);
			}
			
			//락페 좌표
			st = new StringTokenizer(br.readLine(), " ");
			int fx = Integer.parseInt(st.nextToken());
			int fy = Integer.parseInt(st.nextToken());

			//구현
			visited = new boolean[n];
			
			if(bfs(hx, hy, fx, fy)) { //행복하게 페스티벌에 갈 수 있음
				sb.append("happy\n");
			}else {
				sb.append("sad\n");
			}
		}
		
		System.out.println(sb);
	}

	public static boolean bfs(int hx, int hy, int fx, int fy) {
		Queue<Dot> queue = new LinkedList<>();
		
		queue.add(new Dot(hx, hy)); //시작점
		
		while(!queue.isEmpty()) {
			Dot dot = queue.poll();
			
			int dist = getDistance(dot.x, dot.y, fx, fy);
			
			if(dist <= 1000) { //락페까지 도착 가능
				return true;
			}
			
			for(int i = 0; i < n; i++) { //모든 편의점에 대해 탐색
				if(!visited[i]) { //방문하지 않았고
					int nx = stores[i].x;
					int ny = stores[i].y;
					
					dist = getDistance(dot.x, dot.y, nx, ny);
					
					if(dist <= 1000) { //20병 안에 갈 수 있으면
						queue.add(new Dot(nx, ny));
						visited[i] = true;
					}
				}
			}
		}
		return false;
	}

	public static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}

}
