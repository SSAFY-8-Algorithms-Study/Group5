package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17608 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = 0;
		int idx = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] > max) {
				max = arr[i];
				idx = i;
			}
		}

		max = 0;
		for (int i = N - 1; i >= idx; i--) {
			if (arr[i] > max) {
				max = arr[i];
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
