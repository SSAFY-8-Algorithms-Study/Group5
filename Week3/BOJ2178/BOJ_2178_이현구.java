package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_bfs {
	static int N, M;
	static int[][] arr;
	static int[] dx = { 0, 1, -1, 0 };
	static int[] dy = { 1, 0, 0, -1 };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		visit[0][0] = true;
		int min = find(0, 0);
		System.out.println(min);
	}

	static int find(int i, int j) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(i, j, 1));

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			

			if (now.i == N - 1 && now.j == M - 1) {
				return now.cnt;
			}
			for (int k = 0; k < 4; k++) {
				int nextx = now.i + dx[k];
				int nexty = now.j + dy[k];
				if (nextx >= 0 && nexty >= 0 && nextx < N && nexty < M && arr[nextx][nexty] == 1
						&& visit[nextx][nexty] == false) {
					visit[nextx][nexty] = true;
					queue.add(new Point(nextx, nexty, now.cnt + 1));
				}
			}

		}
		return 0;

	}

	static class Point {
		int i, j, cnt;

		Point(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
}