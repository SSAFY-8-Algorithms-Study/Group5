import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int[][] arr = new int[N][N];
	static int max = 0;
	static int max_block_cnt = 0;
	static int[][] arr_rain = new int[N][N];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				arr_rain[i][j] = arr[i][j];
				if (arr[i][j] > max) {
					max = arr[i][j];
				}
			}
		}

		for (int k = 0; k < max; k++) {
			int only_block = 0;
			boolean[][] visit = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] <= k) {
						arr[i][j] = 0;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] != 0) {
						int cnt = 0;

						if (!visit[i][j]) {
							DFS(i, j, visit);
							only_block++;
						}
					}
				}
			}

			if (only_block > max_block_cnt)
				max_block_cnt = only_block;
		}

		System.out.println(max_block_cnt);
	}

	public static void DFS(int x, int y, boolean[][] visit) {
		visit[x][y] = true;

		int dX, dY;
		for (int i = 0; i < 4; i++) {
			dX = x + dx[i];
			dY = y + dy[i];

			if (dX < 0 || dY < 0 || dX >= N || dY >= N) {
				continue;
			}

			if (arr[dX][dY] != 0 && !visit[dX][dY]) {
				DFS(dX, dY, visit);
			}
		}
	}
}
