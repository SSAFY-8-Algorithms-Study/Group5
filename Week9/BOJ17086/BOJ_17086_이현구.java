package day0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086 {
	static int N, M, dis, max;
	static int[][] arr;
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {

					bfs(i, j);
					//System.out.println("i:"+i+",j:"+j+" "+dis);
					max = Integer.max(max, dis);
				}
			}
		}
		System.out.println(max);
	}

	private static void bfs(int x, int y) {
		Queue<Point> p = new LinkedList<>();
		p.add(new Point(x, y));
		dis = 0;
		boolean[][] visit = new boolean[N][M];
		while (!p.isEmpty()) {
			int size = p.size();
			for (int s = 0; s < size; s++) {
				Point n = p.poll();
				for (int i = 0; i < 8; i++) {
					int nx = n.x+dx[i];
					int ny = n.y+ dy[i];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
						if (!visit[nx][ny]) {
							if (arr[nx][ny] == 1) {
								dis++;
								return;
							}
							visit[nx][ny] = true;
							p.add(new Point(nx, ny));
						}
					}
				}
			}
			dis++;
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
