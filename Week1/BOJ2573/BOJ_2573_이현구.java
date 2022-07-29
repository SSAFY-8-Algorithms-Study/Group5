import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int year = 0;
	static int[][] map = new int[N][M];

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 4방향 중 0인 방향의 개수 배열
	static int[][] map_cnt = new int[N][M];

	public static void main(String[] args) {

		// 좌표 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				map_cnt[i][j] = 0;
			}
		}

		while (true) {
			int only_block = 0;
			int dd = 0;
			boolean[][] visit = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0) {
						
						int cnt = 0;
						dd++;
						for (int k = 0; k < 4; k++) { // 4방향 탐색
							if (map[i + dx[k]][j + dy[k]] == 0) {
								cnt++; // 탐색 방향이 0일 때 카운트 증가
							}
						}
						map_cnt[i][j] = cnt;

						if (!visit[i][j]) {
							DFS(i, j, visit);
							only_block++;
						}
					}
				}
			}
			// 분리된 블럭이 2개 이상이면 종료
			if (only_block >= 2 && dd >= 2) {
				System.out.println(year);
				break;
			}

			// 1년 후 변한 모습
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] -= map_cnt[i][j];
					if (map[i][j] < 0)
						map[i][j] = 0;
				}
			}
			year++;

			int check = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						check++;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//System.out.print(map[i][j]);
				}
				//System.out.println();
			}
			//System.out.println("check : " + check + " year:" + year);
			if (check == N * M) {
				year = 0;
				// System.out.println("year : " + year);
				System.out.println(year);
				break;
			}
		}
	}

	public static void DFS(int x, int y, boolean[][] visit) {
		visit[x][y] = true;

		int dX, dY;
		for (int i = 0; i < 4; i++) {
			dX = x + dx[i];
			dY = y + dy[i];

			if (dX < 0 || dY < 0 || dX >= N || dY >= M) {
				continue;
			}

			if (map[dX][dY] != 0 && !visit[dX][dY]) {
				DFS(dX, dY, visit);
			}
		}
	}

}