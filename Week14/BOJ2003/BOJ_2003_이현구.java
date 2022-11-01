package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
	static int N, M, temp, sum = 0, cnt = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		temp = 0;
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			if (sum >= M) {

				while (true) {
					if (sum == M)
						cnt++;
					if (sum < M)
						break;
					sum -= arr[temp];
					temp++;
				}

			} else {

			}
		}
		
		System.out.println(cnt);
	}
}
