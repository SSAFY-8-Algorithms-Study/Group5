package study;

import java.util.Scanner;

public class Boj_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] arr = new int[100][100];
		int[][] info = new int[N][2];
		int sum=0;

		for (int n = 0; n < N; n++) {
			info[n][0] = sc.nextInt();
			info[n][1] = sc.nextInt();
			for (int i = info[n][0]; i < info[n][0]+10; i++) {
				for (int j = info[n][1]; j < info[n][1]+10; j++) {
					arr[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(arr[i][j] ==1)
					sum++;
			}
		}
		System.out.println(sum);
	}
}
