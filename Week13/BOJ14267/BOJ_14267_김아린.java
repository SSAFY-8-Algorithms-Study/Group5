import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14267_김아린 {
	static int[] boss, score;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		boss = new int[n + 1]; //n번의 상사
		
		for(int i = 1; i <= n; i++) { //직속 상사에 연결시키기
			int x = Integer.parseInt(st.nextToken());
			
			if(x != -1) {
				boss[i] = x; //연결
			}
		}
		
		score = new int[n + 1];
		
		for(int a = 0; a < m; a++) { //칭찬하기
			st = new StringTokenizer(br.readLine(), " ");
		
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			score[i] += w;
		}
		
		for(int i = 2; i <= n; i++) {
			//상사의 칭찬 점수 + 본인이 직접 받은 칭찬 점수
			score[i] = score[boss[i]] + score[i];
		}
		
		//출력
		for(int i = 1; i <= n; i++) {
			System.out.print(score[i] + " ");
		}
	}

}
