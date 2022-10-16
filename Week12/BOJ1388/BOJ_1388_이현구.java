import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1388 {
	static int N, M, type, cnt = 0;
	static char[][] arr;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			type = 0;
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == '-') {
					if (type == 1)
						continue;
					type = 1;
					cnt++;
				}
				if (arr[i][j] == '|') {
					type = 2;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			type =0;
			for (int j = 0; j < N; j++) {
				if (arr[j][i] == '-') {
					type = 1;
				}
				if (arr[j][i] == '|') {
					if (type == 2)
						continue;
					type = 2;
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}
