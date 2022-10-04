package day0824;

import java.util.Scanner;

public class BOJ_18429 {
	static int N, K, weight;
	static boolean[] visit;
	static int[] arr, num;
	static int res = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		visit = new boolean[N];
		num = new int[N];
		perm(0);
		System.out.println(res);
	}

	private static void perm(int cnt) {
		if (cnt == N) {
			weight = 500;
			for (int i = 0; i < cnt; i++) {
				weight = weight - K + num[i];
				if (weight < 500)
					return;
			}
			res++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;

			num[cnt] = arr[i];
			visit[i] = true;
			perm(cnt + 1);
			visit[i] = false;

		}
	}
}