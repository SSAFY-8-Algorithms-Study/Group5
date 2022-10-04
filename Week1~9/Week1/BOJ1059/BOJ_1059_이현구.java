package baekjoon;

import java.util.Scanner;

public class p1059 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int[] arr = new int[L];
		int cnt = 0;
		for (int i = 0; i < L; i++) {
			arr[i] = sc.nextInt();
		}

		int n = sc.nextInt();
		int min = 0;
		int max = 1001;

		for (int i = 0; i < L; i++) {

			if (arr[i] == n) {
				System.out.println(cnt);
				return;
			}
			if (arr[i] > n && arr[i] < max) {
				max = arr[i];
			}
			if (arr[i] < n && arr[i] > min) {
				min = arr[i];
			}
		}

		for (int i = min + 1; i < max - 1; i++) {
			for (int j = i + 1; j < max; j++) {
				if (i <= n && j >= n) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}

}