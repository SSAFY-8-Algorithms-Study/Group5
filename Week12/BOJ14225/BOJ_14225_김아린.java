import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14225_김아린 {
	static int N;
	static int[] S;
	static int[] result;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		S = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		check = new boolean[2000001]; //나올 수 있는 자연수 체크
		
		for(int i = 1; i <= N; i++) { //1, 2, .., n개 조합
			result= new int[i];
			combination(0, 0, i);
		}
		
		//부분 수열의 합으로 나올 수 없는 가장 작은 자연수 찾기
		int answer = 0;
		for(int i = 1; i < check.length; i++) {
			if(check[i] == false) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}

	public static void combination(int start, int depth, int n) {
		if(depth == n) {
			int sum = 0;
			for(int i : result) {
				sum += i;
			}
			
			check[sum] = true;
			
			return;
		}
		
		for(int i = start; i < N; i++) {
			result[depth] = S[i];
			combination(i + 1, depth + 1, n);
		}
	}

}
