package day1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14267 {
	static int n, m, w;
	static int[] arr;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= n; i++) {
			int t = Integer.parseInt(st.nextToken());
			if (t != -1) {
				list[t].add(i);
			}
		}

		arr = new int[n + 1];
		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr[i] += w;
		}
		//System.out.println(Arrays.toString(arr));
		dfs(1);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(arr[i] + " ");
		}

		System.out.println(sb);
	}

	// idx = 직원 번호
	private static void dfs(int idx) {
		if (idx == n + 1) {
			return;
		}
		for (int n : list[idx]) {
			arr[n] += arr[idx];
			dfs(n);
		}

	}
}