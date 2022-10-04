import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447_김아린 {
	static char[][] arr;
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
	
		arr = new char[N][N];
		
		printStar(0, 0, N, false);
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	public static void printStar(int x, int y, int n, boolean isBlank) {
		//종료 조건
		if(isBlank) { //공백 칸인 경우(5번째 구역)
			for(int i = x; i < x + n; i++) {
				for(int j = y; j < y + n; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		if(n == 1) {
			arr[x][y] = '*';
			return;
		}
		
		//재귀
		int count = 0; //구역 순서 세기
		for(int i = x; i < x + n; i += (n / 3)) {
			for(int j = y; j < y + n; j += (n / 3)) {
				count++;
				
				if(count == 5) { //공백 구역
					printStar(i, j, n / 3, true);
				} else {
					printStar(i, j, n / 3, false);
				}
			}
		}
		
	}

}