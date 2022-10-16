import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {
	static int T, N, M, min, time, start_x, start_y;
	static char[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			q = new LinkedList<>();
			min = 0;
			time = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					arr[i][j] = line.charAt(j);
					if (arr[i][j] == '@') {
						start_x = i;
						start_y = j;
					}
					if (arr[i][j] == '*') {
						q.add(new Point(i, j));
					}
				}
			}
			bfs();
			if (min == 0) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(min);
			}
		}
	}

	private static void bfs() {
		q.add(new Point(start_x, start_y));
		boolean[][] visit = new boolean[N][M];

		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point n = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = n.x + dx[i];
					int ny = n.y + dy[i];

					if (arr[n.x][n.y] == '*') {
						if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visit[nx][ny]) {
							if (arr[nx][ny] == '.') {
								arr[nx][ny] = '*';
							}
							if (arr[nx][ny] == '@') {
							}
							q.add(new Point(nx, ny));
							visit[nx][ny] = true;
						}
					}
					if (arr[n.x][n.y] == '@') {
						if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
							min = time + 1;
							return;
						} else {
							if (arr[nx][ny] == '.' && !visit[nx][ny]) {
								arr[nx][ny] = '@';
								q.add(new Point(nx, ny));
								visit[nx][ny] = true;
							}
						}
					}
				}
			}
			time++;

		}

	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
