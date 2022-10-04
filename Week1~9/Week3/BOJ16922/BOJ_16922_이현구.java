package day0810;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_16922 {
	static int N;
	static int[] arr;
	static int[] arr2 = { 1, 5, 10, 50 };
	static int sum = 0;
	static Set<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];

		comb(0, 1);
		System.out.println(set.size());
	}

	static void comb(int cnt, int target) {
		if (cnt == N) {
			sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			set.add(sum);
			return;
		}
		for (int i = target; i <= 4; i++) {
			arr[cnt] = arr2[i - 1];
			comb(cnt + 1, i);
		}

	}

}
