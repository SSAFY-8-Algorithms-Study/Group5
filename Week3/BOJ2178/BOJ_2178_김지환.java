package com.ssafy.week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dot{
	int x;
	int y;
	public Dot(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class BOJ_2178_김지환 {
	static int N,M;
	static int[][] map;
	static int[][] visited;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int cnt=0;
	
	static void bfs(int i, int j) {
		Queue<Dot> queue = new LinkedList<>();
		queue.add(new Dot(i,j));
		visited[i][j] = 1;
		while(!queue.isEmpty()) {
			Dot p = queue.poll();
			int x = p.x;
			int y = p.y;
			
			for(int d=0;d<4;d++) {
				
				int nextX = x + di[d];
				int nextY = y + dj[d];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >=M)continue;
				if(map[nextX][nextY] == 0)continue;
				else if(map[nextX][nextY] == 1) {
					if(visited[nextX][nextY] != 1) {
						map[nextX][nextY] +=map[x][y];
						queue.add(new Dot(nextX,nextY));
						visited[nextX][nextY] = 1;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		String s =" ";
		for(int i=0;i<N;i++) {
			s = in.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}//end input
		cnt=0;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				bfs(i,j);

			}
		}
		System.out.println(map[N-1][M-1]);
	}

}
