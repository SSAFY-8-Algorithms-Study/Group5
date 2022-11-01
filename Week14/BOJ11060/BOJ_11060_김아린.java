import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11060_김아린 {
	static int[] maze;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//구현
		int[] dp = new int[N + 1];
		Arrays.fill(dp, 1000);
		
		dp[1] = 0;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= arr[i]; j++) {
				if(i + j <= N) {
					dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
				}
			}
		}
		
		//출력
		int answer = (dp[N] == 1000) ? -1 : dp[N];
		System.out.println(answer);
	}

}
