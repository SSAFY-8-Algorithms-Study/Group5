package day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3187 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int R, C, V, K, sum_V = 0, sum_K = 0;
	static char[][] arr;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] != '#' && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}
		System.out.println(sum_K+" "+sum_V);
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visit[x][y] = true;
		V = 0;
		K = 0;
		while (!q.isEmpty()) {
			Point n = q.poll();
			if (arr[n.x][n.y] == 'v') {
				V++;
			}
			if (arr[n.x][n.y] == 'k') {
				K++;
			}
			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
					if (!visit[nx][ny] && arr[nx][ny] !='#') {
						q.add(new Point(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}
		}

		if (K > V) {
			V = 0;
		} else {
			K = 0;
		}
		sum_V += V;
		sum_K += K;
	}

	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}