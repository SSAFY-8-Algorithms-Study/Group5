package bronze;

import java.util.Scanner;

public class Main_10162 {
	static final int A = 300;
	static final int B = 60;
	static final int C = 10;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;
		
		//만약 T가 나누어 떨어지지 않으면
		if(T % C != 0) {
			System.out.println("-1");
		} else {
			if(T < A) {
				aCount = 0;
				
				if(T < B) {
					bCount = 0;
					cCount = T / C;
				} else {
					bCount = T / B;
					int bNamuzi = T % B;
					
					cCount = bNamuzi / C;
				}
			} else {
				aCount = T / A;
				int aNamuzi = T % A;
				
				bCount = aNamuzi / B;
				int bNamuzi = aNamuzi % B;
				
				cCount = bNamuzi / C;
			}
			
			System.out.println(aCount + " " + bCount + " " + cCount);
		}
	}
}
