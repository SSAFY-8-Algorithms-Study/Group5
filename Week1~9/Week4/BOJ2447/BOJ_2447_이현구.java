package day0819;

import java.util.Scanner;

public class BOJ_2447 {
	static int N, size;
	static char[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];

		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (cnt == 4) {
					arr[i][j] = ' ';
					cnt++;
				} else {
					arr[i][j] = '*';
					cnt++;
				}
			}
		}
		make(1);
	}

	static void make(int num) {
		int temp = (int) Math.pow(3, num);

		size = temp / 3;
		char[][] a = new char[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				a[i][j] = arr[i][j];
			}
		}

		star(0, size, a);
		star(0, size * 2, a);
		star(size, 0, a);
		blank(size, size);
		star(size, size * 2, a);
		star(size * 2, 0, a);
		star(size * 2, size, a);
		star(size * 2, size * 2, a);

		if (temp == N) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]);
				}
				sb.append('\n');
			}
			System.out.println(sb.toString());
			return;
		}

		make(num + 1);
	}

	static void blank(int x, int y) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				arr[i][j] = ' ';
			}
		}
	}

	static void star(int x, int y, char[][] a) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				arr[i][j] = a[i - x][j - y];
			}
		}
	}
}