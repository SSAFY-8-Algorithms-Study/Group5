import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18353_김아린 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1; //1로 초기화
		}
		
		int max = 0;
		for(int i = N - 1; i >= 0; i--) {
			for(int j = N - 1; j >= i; j--) {
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		
//		for(int i : dp) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		//결과
		int answer = N - max;
		System.out.println(answer);
	}

}
