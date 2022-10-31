package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21610_마법사상어와비바라기 {

	// direction은 총 8개의 방향으로 이동이 가능함.

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}

	}

	// 0 : 아무런 반응 x
	// 1 : 좌
	// 2 : 좌,상
	// 3 : 상
	// 4 : 우,상
	// 5 : 우
	// 6 : 우,하
	// 7 : 하
	// 8 : 좌,하
	static int[] di = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dj = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] ci = {-1,-1,1,1};
	static int[] cj = {-1,1,-1,1};
	static int[][] map;
	static boolean[][] magic;
	static int N, M;
	static List<Point> list;
	static Queue<Point> clouds;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int ans = 0;
		map = new int[N][N];
		magic = new boolean[N][N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clouds = new LinkedList<>();
		// 먼저 (N,1),(N,2),(N-1,1),(N-1,2)의 좌표와 물의양을 가져와야됌.....
		clouds.add(new Point(N - 2, 0));
		clouds.add(new Point(N - 2, 1));
		clouds.add(new Point(N-1, 0));
		clouds.add(new Point(N-1, 1));
		while (M-- > 0) {
			st = new StringTokenizer(in.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int move = Integer.parseInt(st.nextToken());
			// 모든 구름이 di방향으로 si칸을 이동함 만약, 범위가 벗어나면 이 문제를 읽으면 1번 행과 N번행이 이어져있다고 하였음 즉, 모듈러
			// 연산을 적용해야됨
			// 범위가 벗어나면 무시하면 안됨
			cloudMove(dir, move);
			//물복사버그 마법을 사용 이 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 바구니의 물의 양이 증가
			//여기서는 경계를 넘어가는 칸은 대각선 방향이 아님 즉, 범위가 넘어가면 무시하면 됨.
			//마법을 사용하기 전 구름이 사라진다. 즉.... 큐에서 poll을 하면됨.
			cloudMagic();
			cloudResult();
			magic = new boolean[N][N];
		}
		ans = answer();
		System.out.println(ans);
	}

	private static int answer() {
		int sum = 0 ;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum+=map[i][j];
			}
		}
		return sum;
		
	}

	private static void cloudResult() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(map[i][j] >=2 && !magic[i][j]) {
					map[i][j] -=2;
					clouds.add(new Point(i,j));
				}
			}
		}
	}

	private static void cloudMagic() {
		while(!clouds.isEmpty()) {
			Point cloud = clouds.poll();
			int cnt = 0;
			//이 구름은 사라졌다는 의미로 true
			magic[cloud.i][cloud.j] = true;
			
			for(int c=0; c<4; c++) {
				int ni = cloud.i+ci[c];
				int nj = cloud.j+cj[c];
				
				if(isRange(ni, nj)) {
					if(map[ni][nj] >=1) {
						cnt++;
					}
				}
			}
			map[cloud.i][cloud.j] += cnt;
		}
	}

	private static boolean isRange(int i, int j) {
		if(i < 0 || i >=N || j < 0 || j>=N)
			return false;
		return true;
	}

	// 1 3 입력으로 받아왔을 때 dir : 3 이고 이동 횟수는 3이다.
	// 그럼 어떻게 이동을 해야할까?
	private static void cloudMove(int dir, int move) {
		// 그럼 리스트를 뺴와야되나?
			// 모듈러 연산'
			for(Point cloud : clouds) {
				cloud.i = (N + cloud.i + di[dir] * (move % N)) % N;
				cloud.j = (N + cloud.j + dj[dir] * (move % N)) % N;
				// 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의양이 1증가한다. 
				map[cloud.i][cloud.j]++;
			}
			
		
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
