import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17244_김아린 {
	static int N, M;
	static char[][] graph;
	static Dot start, end;
	static List<Dot> itemList;
	static boolean[] selected;
	static Dot[] result;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int min;
	
	static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //가로 길이
		M = Integer.parseInt(st.nextToken()); //세로 길이
		
		graph = new char[M][N];
		itemList = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			char[] line = br.readLine().toCharArray();
			
			for(int j = 0; j < N; j++) {
				graph[i][j] = line[j];
				
				if(graph[i][j] == 'X') { //물건이면 리스트에 담기
					itemList.add(new Dot(i, j));
				} else if(graph[i][j] == 'S') {
					start = new Dot(i, j);
				} else if(graph[i][j] == 'E') {
					end = new Dot(i, j);
				}
			}
		}
		
		//구현
		selected = new boolean[itemList.size()];
		result = new Dot[itemList.size()];
		min = Integer.MAX_VALUE;
		
		permutaion(0); //물건의 개수 n에 대하여 n! 순열 돌리기 : 최대 120가지
		
		//출력
		System.out.println(min);
	}

	public static void permutaion(int depth) {
		if(depth == itemList.size()) {
			//S~i1~i2~i3...in~E에 대해 각각 시간 구하기
			List<Dot> route = new ArrayList<>();
			
			route.add(start);
			for(Dot dot : result) {
				route.add(dot);
			}
			route.add(end);
			
			int time = 0;
			for(int i = 0; i <= route.size() - 2; i++) {
				visited = new boolean[M][N];
				time += bfs(route.get(i), route.get(i + 1));
			}
            
			min = Math.min(min, time); //최소 시간 갱신
		}
		
		for(int i = 0; i < itemList.size(); i++) {
			if(!selected[i]) {
				selected[i] = true;
				result[depth] = itemList.get(i);
				permutaion(depth + 1);
				selected[i] = false;
			}
		}
	}

	public static int bfs(Dot dot1, Dot dot2) {
		Queue<Dot> queue = new LinkedList<>();
		
		queue.add(dot1);
		visited[dot1.x][dot1.y] = true;
		
		int time = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int s = 0; s < size; s++) {
				Dot dot = queue.poll();
				
				if(dot.x == dot2.x && dot.y == dot2.y) { //목표 지점까지 탐색 완료
					return time;
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = dot.x + dx[i];
					int ny = dot.y + dy[i];
					
					if(0 <= nx && nx < M && 0 <= ny && ny < N) {
						if(!visited[nx][ny] && graph[nx][ny] != '#') {
							queue.add(new Dot(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
			time++;
		}
		return time;
	}

}
