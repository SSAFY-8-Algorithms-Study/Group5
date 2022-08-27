import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142_김아린 {
	static int N, M;
	static int[][] graph, graph_copy;
	static List<Dot> virusList;
	static Dot[] result; //바이러스 조합 결과
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
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][N];
		virusList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			
				if(graph[i][j] == 2) { //바이러스 위치 저장
					virusList.add(new Dot(i, j));
				}
			}
		}
		
		//구현
		int answer = 0;
		if(!check(graph)) { //이미 모든 칸에 바이러스가 퍼져있지X
			result = new Dot[M];
			min = Integer.MAX_VALUE;
			
			combination(0, 0); //조합
			
			if(min == Integer.MAX_VALUE) { //바이러스를 어떻게 놓아도 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우
				answer = -1;
			}else {
				answer = min;
				
			}
		}
		
		//출력
		System.out.println(answer);
	}

	public static void combination(int start, int depth) {
		if(depth == M) {
			//바이러스 퍼뜨리기
			visited = new boolean[N][N];
			graph_copy = deepCopy(graph); //복사본 만들기
			
			int time = bfs();
			
			if(time != -1) { //퍼뜨릴 수 있는 경우
				min = Math.min(min, time); //최솟값 갱신
			}
			
			return;
		}
		
		//조합 만들기
		for(int i = start; i < virusList.size(); i++) {
			result[depth] = virusList.get(i);
			combination(i + 1, depth + 1);
		}
	}

	public static int[][] deepCopy(int[][] graph) {
		int[][] tmp = new int[graph.length][graph[0].length];
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph[i].length; j++) {
				tmp[i][j] = graph[i][j];
			}
		}
		return tmp;
	}

	public static int bfs() {
		Queue<Dot> queue = new LinkedList<>();
		
		for(int i = 0; i < M; i++) { //활성 바이러스 큐에 넣기
			Dot dot = result[i];
			queue.add(new Dot(dot.x, dot.y));
			visited[dot.x][dot.y] = true;
		}
		
		int time = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int s = 0; s < size; s++) {
				Dot dot = queue.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = dot.x + dx[i];
					int ny = dot.y + dy[i];
					
					if(0 <= nx && nx < N && 0 <= ny && ny < N) { //범위 안에 있고
						if(!visited[nx][ny] && graph_copy[nx][ny] != 1) { //방문X, 벽이 아니면
							graph_copy[nx][ny] = 2; //바이러스 복제
							queue.add(new Dot(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
			time++;
			
			if(check(graph_copy)) { //모든 칸에 바이러스 퍼뜨렸는지 체크
				return time;
			}
		}
		
		return -1;
	}

	public static boolean check(int[][] graph) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(graph[i][j] == 0) { //빈칸 있으면
					return false;
				}
			}
		}
		return true;
	}

}
