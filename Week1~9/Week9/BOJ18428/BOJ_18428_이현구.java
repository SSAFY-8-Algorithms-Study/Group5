package day0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_18428 {
	static int N;
	static char[][] arr;
	static char[][] copy_arr;
	static boolean check = false;
	static int[] num;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Point> blank = new ArrayList<>();
	static ArrayList<Point> stu = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				String s = st.nextToken();
				arr[i][j] = s.charAt(0);
				if (arr[i][j] == 'X') {
					blank.add(new Point(i, j));
				}
				if (arr[i][j] == 'S') {
					stu.add(new Point(i, j));
				}
			}
		}

		num = new int[blank.size()];
		comb(0, 0);

		if (check)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			copy_arr = new char[N][N];
			copy();
			for (int i = 0; i < cnt; i++) {
				//System.out.print(num[i] + " ");
				Point n = blank.get(num[i]);
				copy_arr[n.x][n.y] = 'O';
			}
			if (!search()) {
				check = true;
			}
			return;
		}

		for (int i = start; i < blank.size(); i++) {
			num[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy_arr[i][j] = arr[i][j];
			}
		}
	}

	private static boolean search() {
		for (int i = 0; i < stu.size(); i++) {
			Point s = stu.get(i);
			for (int j = 0; j < 4; j++) {
				int nx = s.x + dx[j];
				int ny = s.y + dy[j];
				while (true) {
					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						// System.out.println(nx + " "+ny);
						if (copy_arr[nx][ny] == 'O') {
							break;
						}
						if (copy_arr[nx][ny] == 'X' || copy_arr[nx][ny] == 'S') {
							nx += dx[j];
							ny += dy[j];
							continue;
						}
						if (copy_arr[nx][ny] == 'T') {
							return true;
						}
					} else {
						break;
					}
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
