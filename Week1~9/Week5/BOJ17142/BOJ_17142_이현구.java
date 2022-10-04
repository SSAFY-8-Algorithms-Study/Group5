package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142 {
	static int N, M, min;
	static int[][] arr;
	static int[] num;
	static ArrayList<Point> list = new ArrayList<>();
	static Queue<Point> q;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		num = new int[M];
		min = 2500;
		boolean zerochk = false;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					list.add(new Point(i, j));
				}
				if (arr[i][j] == 0) {
					zerochk = true;
				}
			}
		}
		if (zerochk == false) {
			System.out.println(0);
			return;
		}
		comb(0, 0);
		if (min == 2500) {
			System.out.println(-1);
		} else
			System.out.println(min);
	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			q = new LinkedList<>();
			int[][] arr2 = new int[N][N];
			arr2 = copy(arr2);
			//M개 뽑은 바이러스 위치
			for (int i = 0; i < cnt; i++) {
				Point n = list.get(num[i]);
				arr2[n.x][n.y] = 3;
				q.add(new Point(n.x, n.y));
			}

			int time = bfs(arr2);
			// -1이면 퍼뜨릴 수 없는 경우임 , 아니면 정상적으로 퍼진거기 때문에 최소 시간 비교
			if (time != -1) {
				min = Math.min(min, time);
			}
			return;
		}

		for (int i = start, size = list.size(); i < size; i++) {
			num[cnt] = i;
			comb(cnt + 1, i + 1);
		}

	}

	private static int bfs(int[][] arr2) {
		int cnt = 0;
		boolean[][] visit = new boolean[N][N];
		while (!q.isEmpty()) {
			boolean check = false;
			int size = q.size();

			for (int s = 0; s < size; s++) {
				Point n = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = n.x + dx[i];
					int ny = n.y + dy[i];
					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if (!visit[nx][ny] && arr2[nx][ny] != 1) {
							q.add(new Point(nx, ny));
							arr2[nx][ny] = 3;
							visit[nx][ny] = true;
						}
					}
				}
			}
			cnt++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr2[i][j] == 0) {
						check = true;
					}
				}
			}
			if (!check) {
				return cnt;
			}

		}
		//탐색이 끝나고 0이 하나라도 있으면 퍼뜨릴 수 없는 경우이므로 -1로 바꿔줌
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr2[i][j] == 0) {
					cnt = -1;
				}
			}
		}

		return cnt;

	}

	private static int[][] copy(int[][] arr2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr2[i][j] = arr[i][j];
			}
		}
		return arr2;
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
