package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {
	static int T, N;
	static int home_x, home_y, goal_x, goal_y;
	static int[][] store;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {

			N = Integer.parseInt(br.readLine());
			store = new int[N][2];

			StringTokenizer st = new StringTokenizer(br.readLine());

			// 집
			home_x = Integer.parseInt(st.nextToken());
			home_y = Integer.parseInt(st.nextToken());

			// 편의점
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}

			// 페스티벌
			st = new StringTokenizer(br.readLine());
			goal_x = Integer.parseInt(st.nextToken());
			goal_y = Integer.parseInt(st.nextToken());

			if (bfs())
				System.out.println("happy");
			else
				System.out.println("sad");

		}
	}

	private static boolean bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(home_x, home_y));
		visit = new boolean[N];

		while (!q.isEmpty()) {
			Point n = q.poll();

			// 현재 좌표와 페스티벌 좌표 차이 거리가 1000이하일 때 happy
			if (Math.abs(n.x - goal_x) + Math.abs(n.y - goal_y) <= 1000) {
				return true;
			}
			for (int i = 0; i < N; i++) {
				int dis_x = Math.abs(n.x - store[i][0]);
				int dis_y = Math.abs(n.y - store[i][1]);
				if (!visit[i] && (dis_x + dis_y <= 1000)) {
					visit[i] = true;
					q.add(new Point(store[i][0], store[i][1]));
				}
			}
		}
		return false;
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