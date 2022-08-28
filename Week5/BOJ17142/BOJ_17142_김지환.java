package day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142_김지환 {

	static class Point{
		int x;
		int y;
		int time;
		public Point(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
	}
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static int[][] virus;
	static Point[] active;
	static int N,M;
	static int emptyspace;
	static int minTime = Integer.MAX_VALUE;
	static List<Point> V;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = new ArrayList<>();
		virus = new int[N][N];
		active = new Point[M];
		//빈칸 갯수 
		emptyspace = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				virus[i][j] = Integer.parseInt(st.nextToken());
				//2가 바이러스 놓을 수 있는 위치이므로 좌표를 큐에 담아준다. 
				if(virus[i][j] == 2) {
					V.add(new Point(i,j,0));
				}
				if(virus[i][j] == 0) {
					emptyspace++;
				}
			}
		}//end input
		
		if(emptyspace == 0) {
			System.out.println(0);
		}
		else {
			comb(0,0);
			System.out.println(minTime==Integer.MAX_VALUE?-1:minTime);
		}
//		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(virus[i][j]+" ");
//			}
//			System.out.println();
//		}
	}
	private static void comb(int depth, int start) {
		if(depth == M) {
			spread(emptyspace);
			return;
		}
		
		for(int i=start; i<V.size(); i++) {
			active[depth] = V.get(i);
			comb(depth+1, i+1);
		}
	}
	private static void spread(int emptyspace) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		for(int i=0; i<M; i++) {
			Point v= active[i];
			visited[v.x][v.y] = true;
			queue.add(v);
	}
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int j=0; j<size;j++) {
				Point cur = queue.poll();
				for(int d=0; d<4; d++) {
					int nextx = cur.x + di[d];
					int nexty = cur.y + dj[d];
					
					if(nextx< 0 || nextx>=N || nexty < 0 || nexty >=N) continue;
					if(visited[nextx][nexty] || virus[nextx][nexty] == 1) continue;
					if(virus[nextx][nexty] == 0) {
						emptyspace--;
					}
					if(emptyspace == 0) {
						minTime = Math.min(minTime, cur.time+1);
						return;
					}
						visited[nextx][nexty] = true;
						queue.add(new Point(nextx, nexty, cur.time+1));
					}
				}
			}
	}
	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N;j++) {
				System.out.print(virus[i][j]);
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
	}
}
