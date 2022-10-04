package study;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		boolean use = true;
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// 정렬
		Arrays.sort(arr, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			} else {
				return Integer.compare(o1[1], o2[1]);
			}
		});

		int start = 0;
		int end = 0;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			if (arr[i][0] >= end) {
				start = arr[i][0];
				end = arr[i][1];
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
