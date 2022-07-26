import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = 0;

		for (int i = 0; i < 8; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < 8; j++) {
				char a = str.charAt(j);

				if (i % 2 == 0 && j % 2 == 0 && a == 'F') {
					cnt++;
				} else if (i % 2 == 1 && j % 2 == 1 && a == 'F') {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}