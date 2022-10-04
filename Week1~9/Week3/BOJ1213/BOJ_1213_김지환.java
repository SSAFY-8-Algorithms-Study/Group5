package com.ssafy.week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1213_김지환 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = in.readLine().toUpperCase();
		String answer ="";
		String end = "";
		int[] alpha = new int[26];
		int isOne =0;
		
		//해당 알파벳이 있는지 카운팅을 하여 문자열 갯수를 구함 
		for(int i=0;i<str.length();i++) {
			alpha[(str.charAt(i)-'A')]++;
		}		
		//문자열 갯수 중에서 짝수가 아닌 것을 고려하여 그것이 1을 초과하게 된다면 만들수 없다는 문구를 만든다.
		for(int i=0;i<alpha.length;i++) {
			if(alpha[i]%2 !=0) isOne++;
		}
		if(isOne > 1) {
			answer +="I'm Sorry Hansoo";
		}
		
		// 그 이후로 front + mid + end문자열을 만든다. 
		else {
						
			for(int i=0;i<alpha.length;i++) {
				for(int j=0;j<alpha[i]/2;j++) {
					sb.append((char)(i+65));
				}
			}
			answer += sb.toString();
			end = sb.reverse().toString();
			
			sb = new StringBuilder();
			for(int i=0; i<alpha.length;i++) {
				if(alpha[i]%2==1) {
					sb.append((char)(i+65));
				}
			}
			answer+= sb.toString()+end;
			
		}
		System.out.println(answer);
	}

}