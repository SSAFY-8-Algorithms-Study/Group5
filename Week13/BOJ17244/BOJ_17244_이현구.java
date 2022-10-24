package day1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17244 {
	static int N, M, Sx, Sy, Ex, Ey, X, sum, min = Integer.MAX_VALUE;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] num;
	static char[][] map;
	static ArrayList<Point> arr = new ArrayList<>();
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		for (int i = 0; i < M; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'S') {
					Sx = i;
					Sy = j;
				}
				if (map[i][j] == 'X') {
					arr.add(new Point(i, j));
				}
				if (map[i][j] == 'E') {
					Ex = i;
					Ey = j;
				}
			}
		}
		visit = new boolean[arr.size()];
		num = new int[arr.size()];
		perm(0);

		System.out.println(min);
	}

	private static void perm(int cnt) {
		if (cnt == arr.size()) {
			sum = 0;
			//res++;
			int tempX = Sx;
			int tempY = Sy;
			for (int i = 0; i < cnt; i++) {
				if (visit[i]) {
					Point n = arr.get(num[i]);
					bfs(tempX, tempY, n.x, n.y);
					tempX = n.x;
					tempY = n.y;
				}
			}
			bfs(tempX, tempY, Ex, Ey);
			
			min = Math.min(min, sum);
			
			return;
		}

		for (int i = 0; i < arr.size(); i++) {
			if (visit[i]) {
				continue;
			}
			num[cnt] = i;
			visit[i] = true;
			perm(cnt + 1);
			visit[i] = false;

		}

	}

	private static void bfs(int sx, int sy, int ex, int ey) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sx, sy));
		boolean[][] isvisit = new boolean[M][N];
		isvisit[sx][sy] = true;
		int ans = 0;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int s = 0; s < size; s++) {
				Point n = q.poll();

				if(n.x==ex && n.y == ey) {
					sum += ans;
					return;
				}
				for (int i = 0; i < 4; i++) {
					int nx = n.x + dx[i];
					int ny = n.y + dy[i];

					if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
						if (!isvisit[nx][ny] && map[nx][ny] !='#') {
							q.add(new Point(nx, ny));
							isvisit[nx][ny] = true;
						}
					}
				}

			}
			ans++;

		}
		
		return;
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