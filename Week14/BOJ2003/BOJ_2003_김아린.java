import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_김아린 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//구현
		int[] dp = new int[N + 1]; //N까지의 합
		
		dp[0] = arr[0];
		for(int i = 1; i <= N; i++) {
			dp[i] = dp[i - 1] + arr[i];
		}
		
		int count = 0;
		for(int i = 1; i <= N; i++) { //길이 조절
			for(int j = 0; j < i; j++) { //시작이 되는 인덱스
				int sum = dp[i] - dp[j];
				if(sum == M) count++;
			}
		}
		
		//출력
		System.out.println(count);
	}

}
