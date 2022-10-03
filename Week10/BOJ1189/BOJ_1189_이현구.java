package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189 {
	static int R, C, K, res = 0, cnt = 0;
	static char[][] arr;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			// st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = line.charAt(j);

			}
		}
		visit[R - 1][0] = true;
		dfs(R - 1, 0);

		System.out.println(res);
	}

	private static void dfs(int x, int y) {

		if (x == 0 && y == C - 1 && cnt == K - 1) {
			// System.out.println("cnt: " + cnt);
			res++;
			return;
		}
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx >= 0 && ny >= 0 && nx < R && ny < C && arr[nx][ny] != 'T') {
				if (!visit[nx][ny]) {
					cnt++;
					visit[nx][ny] = true;
					dfs(nx, ny);
					cnt--;
					visit[nx][ny] = false;
				}
			}
		}

	}
}