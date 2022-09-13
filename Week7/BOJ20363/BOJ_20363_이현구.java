
import java.util.Scanner;

public class BOJ_20363 {
	//    1) 큰 값 + 작은 값 10으로 나눈 몫
	//	  2) 작은 값 더함 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int max = Math.max(X, Y);
		int min = Math.min(X, Y);
		int cnt =0;
		
		cnt = max + min/10 + min;
		System.out.println(cnt);
		
	}
}