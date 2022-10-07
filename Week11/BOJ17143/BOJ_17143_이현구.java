package day1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17143 {
	static int R, C, M, sum = 0;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static PriorityQueue<Shark> list = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R + 1][C + 1];

		if (M == 0) {
			System.out.println("0");
			return;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
			list.add(new Shark(r, c, s, d, z));
		}

		PriorityQueue<Shark> temp = new PriorityQueue<>();
		int time = 1;
		while (true) {
			if (time == C + 1) {
				break;
			}
			// 낚시꾼 이동 + 상어잡기
			int size = list.size();
			boolean eat = false;
			for (int i = 0; i < size; i++) {
				Shark s = list.poll();
				if (s.c == time && !eat) {
					sum += s.z;
					map[s.r][s.c]--;
					eat = true;
				} else {
					temp.add(new Shark(s.r, s.c, s.s, s.d, s.z));
				}
			}
			// 상어 이동
			size = temp.size();
			for (int i = 0; i < size; i++) {
				Shark s = temp.poll();
				map[s.r][s.c]--;
				int dis = s.s;
				int turn = s.d;
				int nx = s.r;
				int ny = s.c;
				
				//dis가 매우 클수도 있으니 줄여줌
				if (turn == 1 || turn == 2) {
					if (dis > (R - 1) * 2) {
						dis = dis % ((R - 1) * 2);
					}
				}
				if (turn == 3 || turn == 4) {
					if (dis > (C - 1) * 2) {
						dis = dis % ((C - 1) * 2);
					}
				}
				while (dis > 0) {
					// 벽을 만나면 반대로 턴
					int tx = nx + dx[turn - 1] * dis;
					int ty = ny + dy[turn - 1] * dis;
					if (tx < 1 || ty < 1 || tx > R || ty > C) {

					}
					if (nx + dx[turn - 1] < 1 || ny + dy[turn - 1] < 1 || nx + dx[turn - 1] > R
							|| ny + dy[turn - 1] > C) {
						if (turn == 1)
							turn = 2;
						else if (turn == 2)
							turn = 1;
						else if (turn == 3)
							turn = 4;
						else if (turn == 4)
							turn = 3;
					}
					nx += dx[turn - 1];
					ny += dy[turn - 1];

					dis--;
				}
				map[nx][ny]++;
				list.add(new Shark(nx, ny, s.s, turn, s.z));
			}

			// 같은 칸 상어 제거
			size = list.size();
			int temp_r = 0;
			int temp_c = 0;

			for (int i = 0; i < size; i++) {
				Shark s = list.poll();
				if (temp_r == s.r && temp_c == s.c) {
					map[s.r][s.c]--;
				} else {
					temp_r = s.r;
					temp_c = s.c;
					temp.add(new Shark(s.r, s.c, s.s, s.d, s.z));
				}
			}

			// temp -> 리스트로 이동
			size = temp.size();
			for (int i = 0; i < size; i++) {
				Shark s = temp.poll();
				list.add(new Shark(s.r, s.c, s.s, s.d, s.z));
			}

			time++;

		}
		System.out.println(sum);
	}

	static class Shark implements Comparable<Shark> {
		int r;
		int c;
		int s;
		int d;
		int z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Shark o) {
			if (this.c == o.c) {
				if (this.r == o.r) {
					return o.z - this.z;
				} else {
					return this.r - o.r;
				}
			} else {
				return this.c - o.c;
			}
		}

	}
}
