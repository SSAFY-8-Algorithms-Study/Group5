package day0912;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 22116문제 창영이와 퇴근
 * 창영이의 퇴근길은 출근길과 조금 다름. 창영이는 건강을 위해 따릉이를 빌려 타고 퇴근하는 습관을 가지고 있음.
 * 창영이의 퇴근길은 NxN 크기의 격자로 표현창영이는 A11에서 출발하여 Ann까지 이동할 계획
 * 창영이는 상하좌우 인접한 격자로 한 번에 한 칸 씩 이동이 가능, 각 격자 Arc에는 자연수가 적혀 있는데 이는 해당 지역의 높이를 뜻하.ㅁ
 * 인접한 격자 사이의 높이 차이의 절댓값을 경사라고 하고 경사가 클수록 경사가 가파르다고 가정
 * 따릉이는 가격에 따라 성능이 다름 비싼 따릉이는 경사가 가파르더라도 내리지 않고 타고 갈수 있는데, 값싼 따릉이는 경사가 가파르면 힘들고 위험하기 때문에 내려서 이동 
 * 
 * */
public class BOJ_22116_김지환 {
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int dist;
		public Point(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Point o) {
			if(o.dist < this.dist) {
				return 1;
			}else {
				return -1;
			}
			
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dist=" + dist + "]";
		}
		
		
		
	}
	static PriorityQueue<Point> q;
	static int[][] dist;
	static boolean[][] visited;
	static int[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N;
	static int endX, endY;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		for (int i = 1; i <=N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 1; j <=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i==N && j==N) {
					endX = N;
					endY = N;
				}
			}
		}//end input
		d(1,1);
//		int answer = Integer.MAX_VALUE;
		System.out.println(answer);
		
	}
	
	private static void d(int x, int y) {
		q = new PriorityQueue<>();
		q.add(new Point(x,y,0));
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point cur = q.poll();
				int nowx = cur.x;
				int nowy = cur.y;
				int cost = cur.dist;
				answer = Math.min(answer, cost);
				visited[nowx][nowy] = true;
				if(nowx == endX && nowy == endY) {
					return;
				}
				for(int d=0; d<4; d++) {
					int nextx = nowx + di[d];
					int nexty = nowy + dj[d];
					if(nextx < 1 || nextx ==N+1 || nexty < 1 || nexty ==N+1) continue;
					if(visited[nextx][nexty]) continue;
//					answer = Math.min(answer, Math.abs(map[nextx][nexty]-map[nowx][nowy]));
					q.add(new Point(nextx,nexty, Math.abs(map[nowx][nowy]-map[nextx][nexty])));
				}
			}
		}
	}

}