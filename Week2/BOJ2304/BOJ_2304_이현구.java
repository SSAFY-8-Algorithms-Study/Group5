package study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Boj_2304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] block = new int[N][2];

		int maxheight = 0;
		int maxwidth = 0;
		int std_width = 0;
		int std_height = 0;
		int idx = 0;
		int area_sum = 0;
		int last_maxwidth = 0;
		int last_maxheight = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				block[i][j] = sc.nextInt();
			}
		}

		Arrays.sort(block, Comparator.comparingInt(o1 -> o1[0]));

		for (int i = 0; i < N; i++) {
			if (block[i][1] > maxheight) {
				maxheight = block[i][1];
				maxwidth = block[i][0];
				idx = i;
			} else if (block[i][1] == maxheight) {
				last_maxheight = block[i][1];
				last_maxwidth = block[i][0];
			}
		}

		// 구간1 (올라가는 구간)
		for (int i = 0; i <= idx; i++) {
			if (block[i][1] > std_height) {
				int area = (block[i][0] - std_width) * std_height;
				area_sum += area;
				System.out.println(area_sum);
				std_height = block[i][1];
				std_width = block[i][0];
			}
		}

		// 구간2 (정상 구간)
		if (last_maxheight != 0)
			area_sum += (last_maxwidth + 1 - maxwidth) * maxheight;
		else
			area_sum += maxheight;

		// 구간3 (내려가는 구간)
		std_width = 0;
		std_height = 0;
		for (int i = N - 1; i >= idx; i--) {
			if (block[i][1] > std_height) {
				int area = (std_width - block[i][0]) * std_height;
				area_sum += area;
				System.out.println(area_sum);
				std_height = block[i][1];
				std_width = block[i][0];
			}
		}

		System.out.println(area_sum);
	}
}
