package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21610 {
	static int N, M, d, s;
	static int[][] map;
	// 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
	static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static Queue<Cloud> q = new LinkedList<>();
	static ArrayList<Cloud> list;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 초기 비구름
		q.add(new Cloud(N, 1));
		q.add(new Cloud(N, 2));
		q.add(new Cloud(N - 1, 1));
		q.add(new Cloud(N - 1, 2));

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			list = new ArrayList<>();
			visit = new boolean[N + 1][N + 1];

			move1();
			move2();
			move4();
			move5();
		}

		int res = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] > 0) {
					res += map[i][j];
				}
			}
		}
		System.out.println(res);
	}

	private static void move1() {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			Cloud c = q.poll();
			int nx = c.x, ny = c.y;
			for (int j = 0; j < s; j++) {
				nx += dx[d];
				ny += dy[d];
				// 이동했는데 맵 밖이면
				if (nx < 1 || ny < 1 || nx > N || ny > N) {
					if (nx == 0) {
						if (ny == 0) {
							nx = N;
							ny = N;
						} else if (ny >= 1 && ny <= N) {
							nx = N;
						} else if (ny == N + 1) {
							nx = N;
							ny = 1;
						}
						continue;
					}
					if (nx == N + 1) {
						if (ny == 0) {
							nx = 1;
							ny = N;
						} else if (ny >= 1 && ny <= N) {
							nx = 1;
						} else if (ny == N + 1) {
							nx = 1;
							ny = 1;
						}
						continue;
					}
					if (ny == 0) {
						ny = N;
						continue;
					}
					if (ny == N + 1) {
						ny = 1;
						continue;
					}

				}
			}
			q.add(new Cloud(nx, ny));
		}
	}

	private static void move2() {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			Cloud c = q.poll();
			map[c.x][c.y]++;
			visit[c.x][c.y] = true;
			list.add(new Cloud(c.x, c.y));
		}
	}

	private static void move4() {
		for (int i = 0; i < list.size(); i++) {
			Cloud n = list.get(i);

			int cnt = 0;
			for (int j = 2; j <= 8; j = j + 2) {
				int nx = n.x + dx[j];
				int ny = n.y + dy[j];
				if (nx >= 1 && ny >= 1 && nx <= N && ny <= N) {
					if (map[nx][ny] > 0) {
						cnt++;
					}
				}
			}
			map[n.x][n.y] += cnt;

		}
	}

	private static void move5() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] >= 2 && !visit[i][j]) {
					q.add(new Cloud(i, j));
					map[i][j] -= 2;
				}
			}
		}
	}

	static class Cloud {
		int x;
		int y;

		public Cloud(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
