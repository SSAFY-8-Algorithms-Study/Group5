package day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16235_김지환 {	
	
	static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int age;
		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}
		@Override
		public int compareTo(Tree o) {
			return this.age-o.age;
		}
		
	}
	//8방 탐색 
	static int[] di = {-1,-1,-1,0,0,1,1,1};
	static int[] dj = {-1,0,1,-1,1,-1,0,1};
	static int[][] food;
	static int[][] add;
	static Queue<Tree> trees;
	static List<Tree> die;
	static int N,M,K;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		trees = new LinkedList<>();
		food = new int[N+1][N+1];
		add = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1;j<=N;j++) {
				food[i][j] = 5;
				add[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			trees.add(new Tree(x,y,z));
		}
		
		//K년 후가 지남
		while(K-- > 0) {
			//봄
			spring();
			//가을
			fall();
			//겨울
			winter();
		}
		System.out.println(trees.size());
		
	}
	//겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다. 추가 양분의 양은 입력으로 주어진다. 
	private static void winter() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				food[i][j] +=add[i][j];
			}
		}
		
	}
	// 가을에는 나무가 번식을 한다. 번식하는 나무는 나이가 5의 배수이어야하며 인접한 8개의 칸에 나이가 1인 나무가 생김 
	// 땅을 벗어나는 칸에는 나무가 생기지 않는다. 
	private static void fall() {
		//부모의 리스트를 만들어줌 
		List<Tree> op = new ArrayList<>();
		int size = trees.size();
		//해당 나무의 사이즈만 큼 loop
		while(size -- > 0) {
			//현재 나무의 좌표와 나이
			Tree dir = trees.poll();
			
			//현재 나이가 5의 배수일 때 8방탐색을 함 
			if(dir.age%5==0) {
			for(int d=0; d<8; d++) {
				int nextx = dir.x + di[d];
				int nexty = dir.y + dj[d];
				
				//8방탐색하면서 범위가 넘어가면 무시 
				if(nextx < 1 || nextx >=N+1 || nexty<1 || nexty >= N+1)continue;
				//번식을 하면서 나이가 1인 나무가 생김 
				trees.add(new Tree(nextx,nexty, 1));
			}
		}
			//현재 나무의 좌표와 나이는 부모가 되므로 리스트에 다시 넣어줌 
			op.add(dir);
		}
		//자식들은 tree에 잘 저장이 되었으므로 부모의 트리를 다시 넣어줘야함. 
		for(Tree t : op) {
			trees.add(t);
		}
	}
	private static void summer() {
		//죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가가된다. 
		for(Tree e : die) {
			food[e.x][e.y] +=e.age;
		}
	}
	// 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1증가한다. 
	private static void spring() {
		//죽은 나무를 추가하기 위한 리스트 
		die = new ArrayList<>();
		int size = trees.size();
		while(size-- > 0) {
			//현재의 나무를 뽑아서 
			Tree now = trees.poll();
			//나무의 양분이 나이보다 작으면 죽은 것으로 취급하고 나이를 2로 나눈 값이 나무가 있던간에 양분을 죽은나무에 추가시킨다. 
			if(food[now.x][now.y] - now.age < 0) {
				die.add(new Tree(now.x, now.y, now.age /2));
			}
			//나이보다 크다면 자신의나이만큼 양분을 먹는다. 
			else {
				food[now.x][now.y] -= now.age;
				//그리고 나이가 1씩 증가한다. 
				trees.add(new Tree(now.x,now.y,now.age+1));
			}
		}
		summer();
	}

}
