package week14;

import java.util.Scanner;

public class BOJ_1670_long {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long[] arr = new long[N + 1];
		if (N == 2) {
			System.out.println("1");
			return;
		} else if (N == 4) {
			System.out.println("2");
			return;
		}

		arr[2] = 1;
		arr[4] = 2;

		for (int T = 6; T <= N; T = T + 2) {

			int temp = T - 2;
			int temp2 = 2;
			// 초기세팅
			arr[T] += arr[temp] * 2;
			temp -= 2;
			// 여기서부터 계산
			for (int i = 2; i < T / 2; i++) {
				arr[T] += arr[temp] * arr[temp2];
				if (arr[T] > 987654321) {
					arr[T] = arr[T] % 987654321;
				}
				if (i % 2 == 1) {
					temp -= 2;
					temp2 += 2;
				}
				// System.out.println(sum);
			}

		}

		System.out.println(arr[N]);
	}
}