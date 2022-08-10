package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		char[] arr = new char[line.length()];
		int[] alpha = new int[26];

		for (int i = 0; i < line.length(); i++) {
			arr[i] = line.charAt(i);
			int a = arr[i];
			for (int j = 65; j < 91; j++) {
				if (j == a) {
					alpha[j - 65]++;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] % 2 == 1)
				cnt++;
			if (cnt >= 2) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
		}

//		for (int i = 0; i < alpha.length; i++) {
//			System.out.print(alpha[i] + " ");
//		}
//		System.out.println();

		char center = 0;
		for (int i = 0; i < (arr.length / 2) + 1; i++) {
			for (int j = 0; j < 26; j++) {
				if (alpha[j] >= 2) {
					arr[i] = (char) (j + 65);
					arr[arr.length - 1 - i] = (char) (j + 65);
					alpha[j] -= 2;
					break;
				} else if (alpha[j] == 1) {
					center = (char) (j + 65);
					alpha[j] -= 1;
				}
			}
//			for (int j = 0; j < alpha.length; j++) {
//				System.out.print(alpha[j] + " ");
//			}
//			System.out.println();

		}
		if (center != 0)
			arr[arr.length / 2] = center;

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
