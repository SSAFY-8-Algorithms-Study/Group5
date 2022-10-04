import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] paper = new int[100][100];
		
		int N = Integer.parseInt(br.readLine()); //색종이 수
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//구현
			for(int j = x; j < x + 10; j++) {
				for(int k = y; k < y + 10; k++) {
					paper[j][k] = 1;
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(paper[i][j] == 1) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
