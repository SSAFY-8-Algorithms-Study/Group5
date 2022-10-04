package day0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_10162_김지환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		int T = Integer.parseInt(in.readLine());
		
		int A = 300;
		int B = 60;
		int C = 10;
		
		int cnt_A = 0;
		int cnt_B = 0;
		int cnt_C = 0;

		while(true) {
			if(A > T || T == 0)break;
			T -=A;
			cnt_A++;
		}
		while(true) {
			if(B > T || T == 0)break;
			T -=B;
			cnt_B++;
		}

		while(true) {
			if(C > T || T == 0)break;
			T -=C;
			cnt_C++;
		}
		if(T == 0) {
			System.out.println(cnt_A+" "+cnt_B+" "+cnt_C);
		}
		if(T !=0) {
			System.out.println(-1);
		}
	}

}
