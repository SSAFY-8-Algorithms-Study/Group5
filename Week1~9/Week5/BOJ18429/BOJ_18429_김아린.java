import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429_김아린 {
	static int N, K;
	static int[] arr; 
	static boolean[] visited;
	static int[] result;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//구현
		visited = new boolean[N];
		result = new int[N];
		count = 0;
		
		permutation(0); //순열
		
		//출력
		System.out.println(count);
	}

	public static void permutation(int depth) {
		if(depth == N) {
			//운동 기간동안 항상 중량이 500 이상이 되도록 하는 경우의 수
			int muscle = 500;
			
			for(int i = 0; i < N; i++) {
				muscle = muscle + result[i] - K;
				
				if(muscle < 500) return; //500보다 작아지면 X
			}
			count++;
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			result[depth] = arr[i];
			permutation(depth + 1);
			visited[i] = false;
		}
	}
	
}
