package day0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10025 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[1000001];
		int max = 0;
		int sum = 0;
		int dis = K * 2 + 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[x] = g;
		}
		for (int i = 0; i <1000001; i++) {
		
			if (i >= dis) {
				sum -= arr[i - dis];
				sum += arr[i];
				max = Math.max(max, sum);
			} else {
				sum += arr[i];
				max = Math.max(max, sum);
			}
		}
		System.out.println(max);
	}
}
