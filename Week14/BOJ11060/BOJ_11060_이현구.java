package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11060_dp {
	static int N, min = Integer.MAX_VALUE;
	static int[] arr, memo;
	static int bigInteger = 10000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		memo = new int[N + 1];
		Arrays.fill(memo, bigInteger);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(1, 0);
		if (min == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(min);
		}
		// System.out.println(Arrays.toString(memo));
	}

	private static void dfs(int idx, int cnt) {
		if (idx > N || cnt > min || memo[idx] <= cnt) {
			return;
		}
		if (idx == N) {
			min = Math.min(min, cnt);
			return;
		}

		memo[idx] = cnt;

		for (int i = 1; i <= arr[idx]; i++) {
			// System.out.println((idx+i)+" 들어갑니다 카운트는 : "+cnt);
			dfs(idx + i, cnt + 1);
		}

	}
}
