package study;

import java.util.Scanner;

public class BOJ_2630 {
	static int N;

	static int[][] map;
	static int white= 0;
	static int blue= 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
	

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		divide(0, 0, N);

		System.out.println(white);
		System.out.println(blue);

	}

	static boolean check(int x, int y, int std) {
		int color = map[x][y];
		for (int i = x; i < x + std; i++) {
			for (int j = y; j < y + std; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}

	static void divide(int x, int y, int std) {
		if (check(x, y, std) == true) {
			if (map[x][y] == 1)
				blue++;
			else
				white++;
			return;
		}
		int std_div = std / 2;
		//System.out.println(std_div);

		divide(x, y, std_div);
		divide(x + std_div, y, std_div);
		divide(x, y + std_div, std_div);
		divide(x + std_div, y + std_div, std_div);
	}

}
