package baekjoon;

import java.util.Scanner;

public class p1051 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] arr = new int[N][M];
		int std = Math.min(N, M);
		int max = 0;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < std; k++) {
					if (i + k < N && j + k < M) {
						if (arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i][j + k]
								&& arr[i][j] == arr[i + k][j + k]) {
							if (k > max) {
								max = k;
								cnt = (k + 1) * (k + 1);
							}
						}
					}

				}
			}
		}
		if (cnt == 0)
			cnt = 1;

		System.out.println(cnt);
	}
}