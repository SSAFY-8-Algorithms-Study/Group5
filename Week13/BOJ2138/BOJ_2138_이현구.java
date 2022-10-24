package day1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2138 {
	static int N, cnt = 0;
	static int min = Integer.MAX_VALUE;
	static int[] start;
	static int[] start2;
	static int[] end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		start = new int[N];
		start2 = new int[N];
		end = new int[N];

		String line = br.readLine();
		for (int i = 0; i < N; i++) {
			start[i] = line.charAt(i) - '0';
		}
		start2 = start.clone();
		line = br.readLine();
		for (int i = 0; i < N; i++) {
			end[i] = line.charAt(i) - '0';
		}
		// System.out.println(Arrays.toString(start));

		//////////////// 1번 시작
		if (start[0] == 0) {
			start[0] = 1;
			if (start[1] == 0) {
				start[1] = 1;
			} else {
				start[1] = 0;
			}
		} else {
			start[0] = 0;
			if (start[1] == 0) {
				start[1] = 1;
			} else {
				start[1] = 0;
			}
		}
		cnt++;
		// System.out.println(Arrays.toString(start));
		for (int i = 1; i <= N - 2; i++) {
			if (start[i - 1] != end[i - 1]) {
				push(i);
				cnt++;
			}
		}
		// System.out.println(Arrays.toString(start));
		if ((start[N - 2] != end[N - 2]) && (start[N - 1] != end[N - 1])) {
			start[N - 2] = end[N - 2];
			start[N - 1] = end[N - 1];
			cnt++;
		}
		// System.out.println(Arrays.toString(end));

		if (Arrays.equals(start, end)) {
			min = cnt;
		}
		//////////////// 2번 시작
		cnt = 0;

		for (int i = 1; i <= N - 2; i++) {
			if (start2[i - 1] != end[i - 1]) {
				push2(i);
				cnt++;
			}
		}
		if ((start2[N - 2] != end[N - 2]) && (start2[N - 1] != end[N - 1])) {
			start2[N - 2] = end[N - 2];
			start2[N - 1] = end[N - 1];
			cnt++;
		}

		if (Arrays.equals(start2, end)) {
			min = Math.min(min, cnt);
		}

		////////////// 끝
		if (min == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(min);

		}
	}

	private static void push(int i) {
		// 앞
		if (start[i - 1] == 0) {
			start[i - 1] = 1;
		} else {
			start[i - 1] = 0;
		}

		// 중간
		if (start[i] == 0) {
			start[i] = 1;
		} else {
			start[i] = 0;
		}

		// 뒤
		if (start[i + 1] == 0) {
			start[i + 1] = 1;
		} else {
			start[i + 1] = 0;
		}
	}

	private static void push2(int i) {
		// 앞
		if (start2[i - 1] == 0) {
			start2[i - 1] = 1;
		} else {
			start2[i - 1] = 0;
		}

		// 중간
		if (start2[i] == 0) {
			start2[i] = 1;
		} else {
			start2[i] = 0;
		}

		// 뒤
		if (start2[i + 1] == 0) {
			start2[i + 1] = 1;
		} else {
			start2[i + 1] = 0;
		}
	}
}