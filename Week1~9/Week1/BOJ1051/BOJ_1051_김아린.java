import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken(" "));
		int M = Integer.parseInt(st.nextToken(" "));
		
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = row.charAt(j) - '0';
			}
		}
		
		//구현
		int max_side = Math.min(N, M);
		int max_area = Integer.MIN_VALUE;
		
		for(int i = 0; i < max_side; i++) { //변 사이즈
			for(int j = 0; j < N; j++) { //시작점 행
				for(int k = 0; k < M; k++) { //시작점 열
					if(j + i < N && k + i < M) { //범위 안에 있는지 확인
						if(arr[j][k] == arr[j + i][k] && arr[j + i][k] == arr[j][k + i] && arr[j][k + i] == arr[j + i][k + i]) {
							max_area = (i + 1) * (i + 1);
						}
					}
				}
			}
		}
		
		System.out.println(max_area);
	}

}
