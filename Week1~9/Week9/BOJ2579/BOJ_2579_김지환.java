package day0926;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2579_김지환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			int element = Integer.parseInt(in.readLine());
			arr[i] = element;
		}
	
		
		dp[1] = arr[1];
		if(N>=2)
			dp[2] = arr[2]+arr[1];
		for(int i=3; i<=N; i++) {
			dp[i] = (Math.max(dp[i-2], dp[i-3]+arr[i-1]))+arr[i];
		}
		System.out.println(dp[N]);
	
		
		
	}

}