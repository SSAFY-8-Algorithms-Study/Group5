package day1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_불_김지환 {

	static class Point {
		int i;
		int j;
		int cnt;

		public Point(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + ", cnt=" + cnt + "]";
		}

	}

	static Queue<Point> fire, sanguen;
	static char[][] map;
	static boolean[][] v;
	static int T;
	static int H, W,ans;
	static boolean flag;
	static int si, sj;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			v = new boolean[H][W];
			ans=0;
			flag = false;
			sanguen = new  LinkedList<>();
			fire = new  LinkedList<>();
			for(int i=0;i<H;i++) {
				String str = in.readLine();
				for(int j=0; j<W;j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='@') {
						si = i;
						sj = j;
						sanguen.offer(new Point(si,sj,1));
						v[si][sj] = true;
					}
					if(map[i][j]=='*') {
						fire.offer(new Point(i,j,0));
						v[i][j] = true;
					}
					
				}
			}
			bfs();
//			for(int i=0; i<H; i++) {
//				for(int j=0; j<W; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			if(flag) {
				sb.append(ans).append("\n");
			}
			else {
				sb.append("IMPOSSIBLE").append("\n");
			}
		}
		System.out.println(sb);
	}
	private static void bfs() {
		while(!sanguen.isEmpty()) {
			//불이 먼저 퍼짐
			int fireSize = fire.size();
			for(int i=0; i<fireSize; i++) {
				Point now = fire.poll();
				
				for(int d=0; d<4; d++) {
					int ni = now.i + di[d];
					int nj = now.j + dj[d];
					
					if(isRange(ni,nj)) {
						if(map[ni][nj]=='.' && !v[ni][nj]) {
							v[ni][nj] =  true;
							map[ni][nj] = '*';
							fire.offer(new Point(ni,nj,0));
						}
					}
				}
			}
			//그 후 상근이가 이동함.
			int sanguenSize = sanguen.size();
			for(int i=0;i<sanguenSize; i++) {
				Point now = sanguen.poll();
				if(now.i==0 || now.i==H-1 || now.j==0 || now.j==W-1) {
					flag=true;
					ans = now.cnt;
					return;
				}
				for(int d=0;d<4;d++) {
					int ni = now.i+di[d];
					int nj = now.j+dj[d];
					if(isRange(ni, nj)) {
						if(!v[ni][nj] && map[ni][nj]=='.') {
							v[ni][nj] = true;
							map[ni][nj]='@';
						
							sanguen.offer(new Point(ni,nj,now.cnt+1));
						}
					}
				}
			}
			
		}
		
		
		
	}

	private static boolean isRange(int i, int j) {
		if(i<0 || i>=H || j<0 || j>=W)
			return false;
		return true;
	}

}
