import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2624_김아린 {
	
	static class Coin implements Comparable<Coin> {
		int value, quantity;

		public Coin(int value, int quantity) {
			this.value = value;
			this.quantity = quantity;
		}

		@Override
		public int compareTo(Coin o) {
			return this.value - o.value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); //지폐의 금액
		int K = Integer.parseInt(br.readLine()); //동전의 가지 수
 		
		Coin[] coins = new Coin[K];
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()); //동전의 금액
			int n = Integer.parseInt(st.nextToken()); //개수
			
			//저장
			coins[i] = new Coin(p , n);
		}
		
		//구현
		Arrays.sort(coins);
		
		int[][] dp = new int[K][T + 1]; //1원부터 T원까지 가지수 저장
		
		for(int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], 0);
		}
		
		//초기값
		int value = coins[0].value;
		int quantity = coins[0].quantity;

		for(int i = 0; i <= quantity; i++) {
			if(value * i <= T) {
				dp[0][value * i] = 1;
			}
			
		}
		
		for(int i = 1; i < K; i++) {
			value = coins[i].value;
			quantity = coins[i].quantity;
			
			for(int j = 0; j <= T; j++) {
				for(int k = 0; k <= quantity; k++) {
					if(j - value * k >= 0) {
						dp[i][j] += dp[i - 1][j - value * k];
					}
				}
			}
		}
		
		//출력
		System.out.println(dp[K - 1][T]);
	}

}
