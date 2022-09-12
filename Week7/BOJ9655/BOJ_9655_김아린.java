package algorithm;

import java.util.Scanner;

public class BOJ_9655_김아린 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N % 2 == 1) { //홀수이면 
			System.out.println("SK"); //상근이가 이김
		}else { //짝수이면
			System.out.println("CY"); //창영이가 이김
		}
	}

}
