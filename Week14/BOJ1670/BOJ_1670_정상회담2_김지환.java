package day1031.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1670_정상회담2_김지환 {

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long[] dp = new long[N+1];
		
		dp[0] = 1;
		dp[2] = 1;
		
		for(int i =4; i<=N; i+=2) {
			long sum = 0;
			for(int j=0; j<=i-2; j+=2) {
				sum+=dp[j]*dp[i-j-2];
				sum%= 987654321;
			}
			dp[i]=sum;
		}
		System.out.println(dp[N]);
	}
	

}
