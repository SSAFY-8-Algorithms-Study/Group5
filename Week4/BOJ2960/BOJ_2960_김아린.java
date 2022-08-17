import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] arr = new boolean[N + 1];
		
		int count = 0;
		int answer = 0;
		
		while(true) {
			//P 찾기
			int P = 0;
			for(int i = 2; i <= N; i++) {
				if(!arr[i]) {
					P = i;
					break;
				}
			}
			
			//P의 배수 지우기
			int i = 1;
			int n = P * i;
			
			while(n <= N) {
				if(!arr[n]) {
					arr[n] = true;
					count++;
				}
				
				if(count == K) {
					answer = n;
					break;
				}
				
				i++;
				n = P * i;
			}
		
			if(count == K) break;
		}
		
		System.out.println(answer);
	}

}
