package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2596 {
	public static void main(String[] args) throws IOException {
		int[] A = { 0, 0, 0, 0, 0, 0 };
		int[] B = { 0, 0, 1, 1, 1, 1 };
		int[] C = { 0, 1, 0, 0, 1, 1 };
		int[] D = { 0, 1, 1, 1, 0, 0 };
		int[] E = { 1, 0, 0, 1, 1, 0 };
		int[] F = { 1, 0, 1, 0, 0, 1 };
		int[] G = { 1, 1, 0, 1, 0, 1 };
		int[] H = { 1, 1, 1, 0, 1, 0 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N * 6];
		String line = br.readLine();
		for (int i = 0; i < N * 6; i++) {
			arr[i] = line.charAt(i) - '0';
		}

		for (int tc = 0; tc < N; tc++) {
			boolean check = false;
			for (int j = 0; j < 8; j++) {
				int cnt = 0;
				for (int i = 0; i < 6; i++) {
					switch (j) {
					case 0:
						if (arr[i + 6 * tc] == A[i])
							cnt++;
						if (cnt == 5) {
							check = true;
						}

						break;
					case 1:
						if (arr[i + 6 * tc] == B[i])
							cnt++;
						if (cnt == 5) {
							check = true;
						}
						break;
					case 2:
						if (arr[i + 6 * tc] == C[i])
							cnt++;
						if (cnt == 5) {
							check = true;
						}
						break;
					case 3:
						if (arr[i + 6 * tc] == D[i])
							cnt++;
						if (cnt == 5) {
							check = true;
						}
						break;
					case 4:
						if (arr[i + 6 * tc] == E[i])
							cnt++;
						if (cnt == 5) {
							check = true;
						}
						break;
					case 5:
						if (arr[i + 6 * tc] == F[i])
							cnt++;
						if (cnt == 5) {
							check = true;
						}
						break;
					case 6:
						if (arr[i + 6 * tc] == G[i])
							cnt++;
						if (cnt == 5) {
							check = true;
						}
						break;
					case 7:
						if (arr[i + 6 * tc] == H[i])
							cnt++;
						if (cnt == 5) {
							check = true;
						}
						break;

					default:
						break;
					}
				}
				if (cnt >= 5) {
					char a = (char) (j + 65);
					sb.append(a);
				}
			}
			if (!check) {
				System.out.println(tc + 1);
				return;
			}
		}

		System.out.println(sb.toString());
	}
}
