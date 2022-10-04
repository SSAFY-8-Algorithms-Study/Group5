package day0810;

import java.util.Scanner;

public class BOJ_1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 0;
		int std = 1;
		int first = 0;
		int end = 0;
		int temp = 0;
		for (int i = 1; i <= 10000000; i++) {
			if (i == N) {
//				System.out.println("std:" + std);
//				System.out.println("cnt:" + cnt);
				break;
			}
			if (cnt <= std)
				cnt++;
			if (cnt == std) {
				std++;
				cnt = 0;
			}
		}

		if (std % 2 == 0) {
			first = 1;
			end = std;
			while (true) {
				if (cnt == 0)
					break;
				first++;
				end--;
				temp++;
				if (cnt == temp)
					break;
			}
		} else if (std % 2 == 1) {
			first = std;
			end = 1;
			while (true) {
				if (cnt == 0)
					break;
				first--;
				end++;
				temp++;
				if (cnt == temp)
					break;
			}
		}
		System.out.println(first + "/" + end);

	}
}
