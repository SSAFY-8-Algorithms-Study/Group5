package day1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17837 {
	static int N, K, cnt = 0;
	static int[] dx = { 0, 0, -1, 1 }; // 우, 좌, 상, 하 순서
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map;
	static boolean check = false;
	static ArrayList<Integer>[][] list;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new ArrayList[N][N];
		map = new int[N][N];
		arr = new int[K][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				list[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()) - 1;
			arr[i][1] = Integer.parseInt(st.nextToken()) - 1;
			arr[i][2] = Integer.parseInt(st.nextToken()) - 1;
			list[arr[i][0]][arr[i][1]].add(i);
		}
		while (true) {
			cnt++;
			game();
			if (check)
				break;
			if (cnt > 1000) {
				System.out.println("-1");
				return;
			}
//			for (int i = 0; i < K; i++) {
//				//System.out.println(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]);
//			}
		}

		System.out.println(cnt);
	}

	private static void game() {
		for (int s = 0; s < K; s++) {
			int x = arr[s][0];
			int y = arr[s][1];
			int nx = x + dx[arr[s][2]];
			int ny = y + dy[arr[s][2]];
			// 장외 or 파란색
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 2) {
				if (arr[s][2] == 0) {
					arr[s][2] = 1;
				} else if (arr[s][2] == 1) {
					arr[s][2] = 0;
				} else if (arr[s][2] == 2) {
					arr[s][2] = 3;
				} else if (arr[s][2] == 3) {
					arr[s][2] = 2;
				}
				nx = x + dx[arr[s][2]];
				ny = y + dy[arr[s][2]];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 2) {
					continue;
				} else {
					if (map[nx][ny] == 1) {
						boolean c = false;
						int temp = 0;
						for (int i = list[x][y].size() - 1; i >= 0; i--) {
							int idx = list[x][y].get(i);
							if (!c) {
								list[nx][ny].add(idx);
								arr[idx][0] = nx;
								arr[idx][1] = ny;
							}
							if (idx == s) {
								temp = i;
								c = true;
							}
						}
						int size =  list[x][y].size();
						for (int i = size - 1; i >= temp; i--) {
							list[x][y].remove(i);
						}
					}else if (map[nx][ny] == 0) {
						boolean c = false;
						int temp = 0;
						for (int i = 0; i < list[x][y].size(); i++) {
							int idx = list[x][y].get(i);
							if (idx == s) {
								temp = i;
								c = true;
							}
							if (c) {
								list[nx][ny].add(idx);
								arr[idx][0] = nx;
								arr[idx][1] = ny;
							}

						}
						int size =  list[x][y].size();
						for (int i = temp; i < size; i++) {
							list[x][y].remove(temp);
						}
					}

				}
			}

			// 빨간색
			else if (map[nx][ny] == 1) {
				boolean c = false;
				int temp = 0;
				for (int i = list[x][y].size() - 1; i >= 0; i--) {
					int idx = list[x][y].get(i);
					if (!c) {
						list[nx][ny].add(idx);
						arr[idx][0] = nx;
						arr[idx][1] = ny;
					}
					if (idx == s) {
						temp = i;
						c = true;
					}
				}
				int size =  list[x][y].size();
				for (int i = size - 1; i >= temp; i--) {
					list[x][y].remove(i);
				}
			}

			// 흰색
			else if (map[nx][ny] == 0) {
				boolean c = false;
				int temp = 0;
				for (int i = 0; i < list[x][y].size(); i++) {
					int idx = list[x][y].get(i);
					if (idx == s) {
						temp = i;
						c = true;
					}
					if (c) {
						list[nx][ny].add(idx);
						arr[idx][0] = nx;
						arr[idx][1] = ny;
					}

				}
				int size =  list[x][y].size();
				for (int i = temp; i < size; i++) {
					list[x][y].remove(temp);
				}
			}

			//System.out.println("nx: " + nx + " , ny: " + ny);
			if (list[nx][ny].size() >= 4) {
				check = true;
				return;
			}
		}
	}

	static class Point {
		int x;
		int y;
		int turn;

		public Point(int x, int y, int turn) {
			this.x = x;
			this.y = y;
			this.turn = turn;
		}

	}
}