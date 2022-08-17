package day0817;

import java.util.Scanner;

public class BOJ_2960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;

		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= N; i++) {
			int temp = i;
			while (temp <= N) {
				if (arr[temp] != 0) {
					arr[temp] = 0;
					cnt++;
				}
				if (cnt == K) {
					System.out.println(temp);
					return;
				}
				temp += i;
			}
		}

	}
}
