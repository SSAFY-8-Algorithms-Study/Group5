package day0831;

import java.util.Scanner;

public class BOJ_10162 {
	static int T, A, B, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		int cnt = 0;
		if (T % 10 != 0) {
			System.out.println("-1");
			return;
		}

		if (T < 60) {
			div10();
		} else if (T >= 60 && T < 300) {
			div60();
		} else {
			div300();
		}

		System.out.println(A + " " + B + " " + C);
	}

	static void div10() {
		C = T / 10;
	}

	static void div60() {
		while (true) {
			T -= 60;
			B++;
			if (T < 60) {
				div10();
				break;
			}
		}
	}

	static void div300() {
		while (true) {
			T -= 300;
			A++;
			if (T < 300) {
				if (T < 60) {
					div10();
					break;
				} else {
					div60();
				}
				break;
			}
		}
	}
}
