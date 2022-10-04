import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int white = 0;
	static int blue = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(paper, 0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}

	public static void divide(int[][] paper, int a, int b, int n) {
		if(isSame(paper, a, b, n)) {
			if(paper[a][b] == 0) {
				white++;
			}else {
				blue++;
			}
			return;
		}else {
			divide(paper, a, b, n / 2);
			divide(paper, a, b + n / 2, n / 2);
			divide(paper, a + n / 2, b, n/2);
			divide(paper, a + n / 2, b + n / 2, n/2);
		}
		
	}

	public static boolean isSame(int[][] paper, int a, int b, int n) {
		int num = paper[a][b];
		for(int i = a; i < a + n; i++) {
			for(int j = b; j < b + n; j++) {
				if(paper[i][j] != num) {
					return false;
				}
			}
		}
		return true;
	}
}
