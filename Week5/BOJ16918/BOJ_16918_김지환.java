package day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16918_김지환 {

	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int []di = {-1,1,0,0};
	static int []dj = {0,0,-1,1};
	static char[][]map;
	static char[][]initial;
	static int R,C,N;
	static Queue<Point> queue;
	static char[][] copy;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		initial = new char[R][C];
		queue = new LinkedList<>();
		for(int i=0; i<R; i++) {
			String str = in.readLine();
			for(int j=0; j<C;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int time = 0;

		while(time <= N) {
			if(time == 1) {
				copy = deepcopy(map);
				q();
			}
			else if(time == 2) {
				init();
			}
			else {				
				init();
				if(time %2 == 1) {
					copy = bfs(initial);
					q();
				}
			}
			time++;
		}
		if(N%2 == 0) {
			init();
			for(int i=0;i<R;i++) {
				for(int j=0; j<C; j++) {
					System.out.print(initial[i][j]);
				}
				System.out.println();
			}
		}
		else {			
			for(int i=0;i<R;i++) {
				for(int j=0; j<C; j++) {
					System.out.print(copy[i][j]);
				}
				System.out.println();
			}
		}
//		copy = deepcopy(map);
//		init();
//		q();
//		copy = bfs(initial);
//		q();
//		init();
//		copy = bfs(initial);
//		q();
//		init();
//		copy = bfs(initial);
//		q();
//		init();
//		copy = bfs(initial);
//		if(N%2==0) {
//			init();
//			for(int i=0;i<R;i++) {
//				for(int j=0; j<C; j++) {
//					System.out.print(initial[i][j]);
//				}
//				System.out.println();
//			}
//		}
//		else {
//			copy = deepcopy(map);
//			if(N%4==1) {
//				if(N==1) {					
//					for(int i=0;i<R;i++) {
//						for(int j=0;j<C;j++) {
//							System.out.print(copy[i][j]);
//						}
//						System.out.println();
//					}
//					q();
//					copy = bfs(initial);
//				}
//			}
//			else if(N%4==3) {
//				q();
//				copy = bfs(initial);
//				for(int i=0;i<R;i++) {
//					for(int j=0;j<C;j++) {
//						System.out.print(copy[i][j]);
//					}
//					System.out.println();
//				}	
//			}
//		}
		
		
		
	}
	private static void q() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(copy[i][j] == 'O') {
					queue.offer(new Point(i,j));
				}
			}
		}
	}
	private static char[][] bfs(char[][] inital) {
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size;i++) {
				Point cur = queue.poll();
				int nowx = cur.x;
				int nowy = cur.y;
				
				if(initial[nowx][nowy] == 'O') {
					initial[nowx][nowy] = '.';
				}
				for(int d=0; d<4; d++) {
					int nextx = nowx+di[d];
					int nexty = nowy+dj[d];
					
					if(nextx< 0 || nextx >=R || nexty < 0 || nexty >=C)continue;
					initial[nextx][nexty] = '.';
				}
			}
		}
		return initial;
	}
	static void print(char[][] map) {
		for(int i=0;i<R;i++) {
			for(int j=0; j<C;j++) {
				System.out.printf("%3c", map[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
	static void init(){
		for(int i=0;i<R;i++) {
			for(int j=0; j<C; j++) {
				initial[i][j] = 'O';
			}
		}
	}
	
	static char[][] deepcopy(char[][] origin){
		char[][] tmp = new char[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				tmp[i][j] = origin[i][j];
			}
		}
		return tmp;
	}
}
