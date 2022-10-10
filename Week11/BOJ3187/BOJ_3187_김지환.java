import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	static char[][] map;
	static boolean[][] visit;
	static int N, M;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	//wolfSafe : 살아남은 늑대의 수
	//sheepSafe : 살아남은 양의 수
	//wolf : 한 울타리의 늑대의 수
	//sheep : 한 울타리의 양의 수 
	static int wolfSafe, sheepSafe, wolf,sheep;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			map[i] = str.toCharArray();
		}// end input
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
					wolf=0;
					sheep=0;
					pasture(i,j);
				
			}
		}
		
		System.out.println(sheepSafe+" "+wolfSafe);
	}

	


	private static void pasture(int nowi, int nowj) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(nowi,nowj));
		visit[nowi][nowj] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int d=0;d<4;d++) {
				int nexti = now.x + di[d];
				int nextj = now.y + dj[d];
				
				if(isRange(nexti,nextj)&&!visit[nexti][nextj]) {
					if(map[nexti][nextj]=='#')continue;
					if(map[nexti][nextj]=='k') {
						sheep++;
					}
					if(map[nexti][nextj]=='v') {
						wolf++;
					}
					visit[nexti][nextj] = true;
					q.add(new Point(nexti,nextj));
				}
			}
		}
		
		if(sheep > wolf) {
			wolf = 0;
		}
		else {
			sheep=0;
		}
		wolfSafe +=wolf;
		sheepSafe +=sheep;
		
	}




	private static boolean isRange(int i, int j) {
		if(i<0 || i>=N || j < 0 || j >=M)
			return false;
		return true;
	}




	private static void print(char[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
