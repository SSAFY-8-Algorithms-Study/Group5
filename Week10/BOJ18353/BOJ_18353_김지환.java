package day0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18353_김지환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		
		st = new StringTokenizer(in.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=i;j++) {
				if(arr[i]<arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					}
				}
			}
		System.out.println(Arrays.toString(dp));
		Arrays.sort(dp);
//		System.out.println(Arrays.toString(dp));
		System.out.println(N-dp[N]-1);
	}
	}


