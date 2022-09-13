import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22116 {
	static int N, slope, min;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.println(min);
	}

	private static void bfs() {
		PriorityQueue<Point> p = new PriorityQueue<>();
		p.add(new Point(0, 0, 0));

		while (!p.isEmpty()) {
			Point n = p.poll();
			visit[n.x][n.y] = true;
			min = Math.max(min, n.dif);
			if (n.x== N - 1 && n.y == N - 1) {
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny]) {
					slope = Math.abs(arr[n.x][n.y] - arr[nx][ny]);
					p.add(new Point(nx,ny,slope));
				}
			}

		}
	}

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int dif;

		public Point(int x, int y, int dif) {
			this.x = x;
			this.y = y;
			this.dif = dif;
		}

		@Override
		public int compareTo(Point o) {
			return this.dif - o.dif;
		}
	}
}