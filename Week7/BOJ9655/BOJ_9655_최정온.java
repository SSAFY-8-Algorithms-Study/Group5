package silver;

import java.util.Scanner;

public class Main_9655 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		while(N > 0) {
			
			//상근이 턴
			if(N >= 3) {
				N -= 3;
			} else {
				N--;
			}
			//N이 0개가 남으면 게임이 끝난다.
			if(N == 0) {
				System.out.println("SK");
				break;
			}
			
			//창영이 턴
			if(N >= 3) {
				N -= 3;
			} else {
				N--;
			}
			//N이 0개가 남으면 게임이 끝난다.
			if(N == 0) {
				System.out.println("CY");
				break;
			}
			
		}
	}
}
