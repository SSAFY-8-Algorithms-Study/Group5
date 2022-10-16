package day1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1388_바닥장식_김지환 {
	
	static int[] di= {-1,1,0,0};
	static int[] dj= {0,0,-1,1};
	
	static char[][] map;
	static boolean[][] v;
	static int R,C;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	
		map = new char[R][C];
		
		for(int r=0;r<R;r++) {
			String str = in.readLine();
			map[r] = str.toCharArray();
		}
		
		v = new boolean[R][C];
		int row =0;
		int col = 0;
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]=='-' && !v[r][c]) {
					rowBFS(r,c);
					row++;
				}
				else if(map[r][c]=='|' && !v[r][c]) {
					colBFS(r,c);
					col++;
				}
			}
		}
		ans = row+col;
		System.out.println(ans);
	}
	private static void rowBFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		v[r][c] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int d=0;d<4;d++) {
				int nj=now[1]+dj[d];
				
				if(nj<0 || nj>=C)continue;
				if(map[now[0]][nj]=='-' && !v[now[0]][nj]) {
					v[now[0]][nj] = true;
					q.add(new int[] {now[0], nj});
				}
			}
		}
		
	}
	private static void colBFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		v[r][c] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int d=0;d<4;d++) {
				int ni=now[0]+di[d];
				
				if(ni<0 || ni>=R)continue;
				if(map[ni][now[1]]=='|' && !v[ni][now[1]]) {
					v[ni][now[1]] = true;
					q.add(new int[] {ni, now[1]});
				}
			}
		}
		
		
	}

}
