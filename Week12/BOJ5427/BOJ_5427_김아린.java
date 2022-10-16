import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_김아린 {
	static int w, h;
	static char[][] graph;
	static Queue<Dot> queue;
	static boolean[][] visited;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static class Dot {
		int i, j;
		char c;
		
		public Dot(int i, int j, char c) {
			this.i = i;
			this.j = j;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			graph = new char[h][w];
			
			int starti = 0, startj = 0;
			for(int i = 0; i < h; i++) {
				String line = br.readLine();
				
				for(int j = 0; j < w; j++) {
					graph[i][j] = line.charAt(j);
					
					if(graph[i][j] == '@') {
						starti = i;
						startj = j;
					}
				}
			}
			
			//구현
			visited = new boolean[h][w];
			
			int result = bfs(starti, startj);
			
			//출력
			if(result != -1) {
				sb.append(result + "\n");
			} else {
				sb.append("IMPOSSIBLE\n");
			}
		}
		
		System.out.println(sb);
	}

	public static int bfs(int starti, int startj) {
		queue = new LinkedList<>();
		
		for(int i = 0; i < h; i++) { //초기 불 위치 큐에 담기
			for(int j = 0; j < w; j++) {
				if(graph[i][j] == '*') {
					queue.add(new Dot(i, j, '*'));
					visited[i][j] = true;
				}
			}
		}
		
		queue.add(new Dot(starti, startj, '@')); //시작 위치 큐에 담기
		graph[starti][startj] = '.'; //시작 위치 없애기
		visited[starti][startj] = true;
		
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int s = 0; s < size; s++) {
				Dot dot = queue.poll();
				
				for(int d = 0; d < 4; d++) {
					int ni = dot.i + di[d];
					int nj = dot.j + dj[d];
					
					if(dot.c == '*') { //불인 경우
						if(0 <= ni && ni < h && 0 <= nj && nj < w && !visited[ni][nj]) {
							if(graph[ni][nj] == '.') { //빈 공간이면
								graph[ni][nj] = '*'; //불 옮김
								queue.add(new Dot(ni, nj, '*'));
								visited[ni][nj] = true;
							}
						}
					} else if(dot.c == '@') { //상근이인 경우
						if(ni == -1 || ni == h || nj == -1 || nj == w) { //탈출 가능한 경우
							return count + 1;
						}
						
						if(0 <= ni && ni < h && 0 <= nj && nj < w && !visited[ni][nj]) {
							if(graph[ni][nj] == '.') { //빈 공간이면
								queue.add(new Dot(ni, nj, '@')); //이동
								visited[ni][nj] = true;
							}
						}
					}
				}
			}
			count++;
		}
		return -1; //탈출할 수 없는 경우
	}

}
