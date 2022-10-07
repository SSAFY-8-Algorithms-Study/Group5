package day1007;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2624 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int arr[][] = new int[k + 1][2];
		int dp[][] = new int[k + 1][T + 1];
		Point coin;
		for (int i = 1; i <= k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			dp[i - 1][0] = 1;
		}

		
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= T; j++)
				for (int num = 0; num <= arr[i][1]; num++) {
					if (num * arr[i][0] <= j) {
						dp[i][j] += dp[i - 1][j - num * arr[i][0]];
					}
				}
		}
//		for (int i = 1; i <= k; i++) {
//			for (int j = 1; j <= T; j++) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println();
//		}
		
		System.out.println(dp[k][T]);
	}
}