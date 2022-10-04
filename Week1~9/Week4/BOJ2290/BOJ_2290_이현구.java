package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2290 {
	static char[][] arr;
	static char[][] res;
	static int s;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		String line = st.nextToken();
		int len = line.length();
		int resX = s * 2 + 3;
		int resY = (s + 2) * len + (len - 1);
		int dy = 0;
		res = new char[resX][resY];

		for (int i = 0; i < len; i++) {
			arr = new char[s * 2 + 3][s + 2];
			int temp = line.charAt(i) - '0';
			switch (temp) {
			case 1:
				lcd(3);
				lcd(6);
				break;

			case 2:
				lcd(1);
				lcd(3);
				lcd(4);
				lcd(5);
				lcd(7);
				break;
			case 3:
				lcd(1);
				lcd(3);
				lcd(4);
				lcd(6);
				lcd(7);
				break;
			case 4:
				lcd(2);
				lcd(3);
				lcd(4);
				lcd(6);
				break;
			case 5:
				lcd(1);
				lcd(2);
				lcd(4);
				lcd(6);
				lcd(7);
				break;
			case 6:
				lcd(1);
				lcd(2);
				lcd(4);
				lcd(5);
				lcd(6);
				lcd(7);
				break;
			case 7:
				lcd(1);
				lcd(3);
				lcd(6);
				break;
			case 8:
				lcd(1);
				lcd(2);
				lcd(3);
				lcd(4);
				lcd(5);
				lcd(6);
				lcd(7);
				break;
			case 9:
				lcd(1);
				lcd(2);
				lcd(3);
				lcd(4);
				lcd(6);
				lcd(7);

				break;
			case 0:
				lcd(1);
				lcd(2);
				lcd(3);
				lcd(5);
				lcd(6);
				lcd(7);
				break;
			default:
				break;
			}
			for (int x = 0; x < 2 * s + 3; x++) {
				for (int y = 0; y < s + 2; y++) {
					res[x][y + dy] = arr[x][y];
				}
			}
			dy += s + 3;
		}

		for (int x = 0; x < resX; x++) {
			for (int y = 0; y < resY; y++) {
				if(res[x][y] == 0) {
					res[x][y] = ' ';
				}
				System.out.print(res[x][y]);
			}
			System.out.println();
		}
	}

	static void lcd(int idx) {
		// 최상단
		if (idx == 1) {
			for (int i = 1; i <= s; i++) {
				arr[0][i] = '-';
			}
		}
		// 좌측 상단
		if (idx == 2) {
			for (int i = 1; i <= s; i++) {
				arr[i][0] = '|';
			}
		}
		// 우측 상단
		if (idx == 3) {
			for (int i = 1; i <= s; i++) {
				arr[i][s + 1] = '|';
			}
		}
		// 중앙
		if (idx == 4) {
			for (int i = 1; i <= s; i++) {
				arr[s + 1][i] = '-';
			}
		}
		// 좌측 하단
		if (idx == 5) {
			for (int i = s + 2; i <= s * 2 + 1; i++) {
				arr[i][0] = '|';
			}
		}
		// 우측 하단
		if (idx == 6) {
			for (int i = s + 2; i <= s * 2 + 1; i++) {
				arr[i][s + 1] = '|';
			}
		}
		// 최하단
		if (idx == 7) {
			for (int i = 1; i <= s; i++) {
				arr[s * 2 + 2][i] = '-';
			}
		}
	}
}
