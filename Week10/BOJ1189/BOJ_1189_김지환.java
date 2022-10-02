package day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189_김지환 {

	static int R, C, K;
	static char[][] map;
	static boolean[][] select;
	static int startX, startY, endX, endY;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// 시작 X와 Y좌표
		startX = R - 1;
		startY = 0;
		// 끝 X와 Y좌표
		endX = 0;
		endY = C - 1;
		// 방문체크를 위한 boolean 2차원 배열
		select = new boolean[R][C];
		select[startX][startY] = true;
		// dfs 돌림 시작시점부터 돌림
		dfs(startX, startY, 1);
		System.out.println(answer);
	}

	private static void dfs(int nowX, int nowY, int cnt) {
		// 현재 좌표가 끝좌표에 도달하고 그가짓수가 K라면 이 method는 중단.
		if (nowX == endX && nowY == endY) {
			if(cnt == K) {
				answer++;
			}
			return;
		}
//		System.out.println(nowX+" "+nowY+" "+cnt);

		// 상
		if(nowX-1>=0) {
			if(!select[nowX-1][nowY]&&map[nowX-1][nowY]!='T') {
				select[nowX- 1][nowY] = true;
				dfs(nowX-1, nowY, cnt + 1);
				select[nowX-1][nowY] = false;
			}
		}
		//하
		if(nowX+1<R) {
			if(!select[nowX+1][nowY]&&map[nowX+1][nowY]!='T') {
				select[nowX+1][nowY] = true;
				dfs(nowX+1, nowY, cnt + 1);
				select[nowX+1][nowY] = false;
			}
		}
		//우
		if(nowY+1<C) {
			if(!select[nowX][nowY+1]&&map[nowX][nowY+1]!='T') {
					select[nowX][nowY + 1] = true;
					dfs(nowX, nowY + 1, cnt + 1);
					select[nowX][nowY+1] = false;
				}
			}
		//좌
		if(nowY-1>=0) {
			if(!select[nowX][nowY-1]&&map[nowX][nowY-1]!='T') {
				select[nowX][nowY-1] = true;
				dfs(nowX, nowY-1, cnt + 1);
				select[nowX][nowY-1] = false;
			}
		}

	}
}
