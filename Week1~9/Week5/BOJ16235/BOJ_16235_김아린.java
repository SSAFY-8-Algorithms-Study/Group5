import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16235_김아린 {
	static int N;
	static int[][] A, graph;
	static List<Tree> treeList;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; //8개 칸
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static class Tree implements Comparable<Tree> {
		int x, y, age;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) { //오름차순 정렬
			return this.age - o.age;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1][N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 1; j < N + 1; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		graph = new int[N + 1][N + 1]; //양분 현황 그래프
		
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				graph[i][j] = 5; //가장 처음 양분
			}
		}
		
		treeList = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			treeList.add(new Tree(x, y, z));
		}
		
		//구현
		Collections.sort(treeList); //오름차순 정렬
				
		List<Tree> liveList = new ArrayList<>();
		List<Tree> deadList = new ArrayList<>();
		
		int year = 0;
		while(year < K) {
			//봄 : 자신 나이만큼 양분 먹고, 나이 증가
			for(Tree tree : treeList) {
				if(tree.age <= graph[tree.x][tree.y]) { //자신 나이만큼 먹기 가능
					graph[tree.x][tree.y] -= tree.age; //해당 칸에 양분 감소
					liveList.add(new Tree(tree.x, tree.y, tree.age + 1)); //O(n) 걸리는 remove() 연산 빼려고 추가
				}else { //자신 나이만큼 못 먹으면
					deadList.add(new Tree(tree.x, tree.y, tree.age));
				}
			}
			
			treeList.clear();
			treeList.addAll(liveList);
			liveList.clear();
			//여름 : 죽은 나무 -> 양분
			for(Tree tree : deadList) {
				graph[tree.x][tree.y] += (tree.age / 2);
			}
			
			deadList.clear(); //초기화
			
			//가을 : 나이가 5배수인 나무 번식
			List<Tree> newTreeList = new ArrayList<>(); //새로운 나무
			
			for(Tree tree : treeList) {
				if(tree.age % 5 == 0) {
					for(int i = 0; i < 8; i++) { //8개 인접한 칸 탐색
						int nx = tree.x + dx[i];
						int ny = tree.y + dy[i];
						
						if(1 <= nx && nx <= N && 1 <= ny && ny <= N) { //땅을 벗어나지x
							newTreeList.add(new Tree(nx, ny, 1)); //신생 나무 생김
						}
					}
				}
			}
			
			treeList.addAll(0, newTreeList); //나무 리스트에 옮겨 담기(내림차순이므로 뒤에 넣기)
			
			//겨울 : 양분 추가
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					graph[i][j] += A[i][j];
				}
			}
			
			year++;
		}
		
		//출력 : 살아있는 나무 개수
		System.out.println(treeList.size());
	}

}
