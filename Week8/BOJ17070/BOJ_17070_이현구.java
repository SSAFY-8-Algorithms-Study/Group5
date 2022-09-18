package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {
	static int N, cnt = 0;
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 1, 0 }; // 순서대로 오른쪽, 아래대각선, 아래방향
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1, 0);
		System.out.println(cnt);
	}

	private static void dfs(int x, int y, int turn) {
		if (x == N - 1 && y == N - 1) {
			cnt++;
			return;
		}

		if (turn == 0) {
			for (int i = 0; i < 2; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (i == 1) {
						if (arr[nx - 1][ny] == 1 || arr[nx][ny - 1] == 1)
							continue;
					}
					if (arr[nx][ny] == 0) {
						dfs(nx, ny, i);
					}
				}
			}
		}
		if (turn == 1) {
			for (int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (i == 1) {
						if (arr[nx - 1][ny] == 1 || arr[nx][ny - 1] == 1)
							continue;
					}
					if (arr[nx][ny] == 0) {
						dfs(nx, ny, i);
					}
				}
			}
		}
		if (turn == 2) {
			for (int i = 1; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (i == 1) {
						if (arr[nx - 1][ny] == 1 || arr[nx][ny - 1] == 1)
							continue;
					}
					if (arr[nx][ny] == 0) {
						dfs(nx, ny, i);
					}
				}
			}
		}
	}
}
