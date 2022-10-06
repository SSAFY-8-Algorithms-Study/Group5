import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17143_김아린 {
	static int R, C;
	static Shark[][] graph;
	static Shark[][] newGraph;
	
	static class Shark {
		int s, d, z;
		
		
		public Shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new Shark[R + 1][C + 1];
		
		int sum = 0;
		if(M != 0) {
			//입력 받기
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int r = Integer.parseInt(st.nextToken()); //상어 위치
				int c = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken()); //속력
				int d = Integer.parseInt(st.nextToken()); //이동 방향
				int z = Integer.parseInt(st.nextToken()); //크기
				
				graph[r][c] = new Shark(s, d, z);
			}
			
			//구현
			
			for(int c = 1; c <= C; c++) {
				//상어 잡기
				int size = catchShark(c);
				sum += size;
				
				//상어 이동
				newGraph = new Shark[R + 1][C + 1];
				
				for(int i = 1; i <= R; i++) {
					for(int j = 1; j <= C; j++) {
						if(graph[i][j] != null) { //상어가 있으면
							//이동시키기
							moveShark(i, j);
						}
					}
				}
				
				graph = copy(newGraph);
			}
			
		}
		
		System.out.println(sum);
	}

	public static Shark[][] copy(Shark[][] graph) {
		Shark[][] tmp = new Shark[R + 1][C + 1];
		
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				tmp[i][j] = graph[i][j];
			}
		}
		return tmp;
	}
	
	public static void moveShark(int i, int j) {
		Shark shark = graph[i][j];
		int r = i;
		int c = j;
		
		for(int s = 0; s < shark.s; s++) { //속력만큼 이동
			if(shark.d == 1) { //이동 방향 위인 경우
				if(r == 1) { //위에가 경계인 경우에
					shark.d = 2; //아래로 방향 바꾸기 
					r++;
				} else {
					r--;
				}
			} else if(shark.d == 2) { //이동 방향 아래인 경우
				if(r == R) { //아래가 경계인 경우에
					shark.d = 1; //위로 방향 바꾸기 
					r--;
				} else {
					r++;
				}
			} else if(shark.d == 3) { //이동 방향 오른쪽인 경우
				if(c == C) { //오른쪽이 경계인 경우에
					shark.d = 4; //왼쪽으로 방향 바꾸기 
					c--;
				} else {
					c++;
				}
			} else if(shark.d == 4) { //이동 방향 왼쪽인 경우
				if(c == 1) { //왼쪽이 경계인 경우에
					shark.d = 3; //오른쪽으로 방향 바꾸기 
					c++;
				} else {
					c--;
				}
			}
		}
		
		if(newGraph[r][c] == null) { //이동하는 자리에 상어가 없으면
			newGraph[r][c] = new Shark(shark.s, shark.d, shark.z); //이동
			
		} else { //있으면
			if(newGraph[r][c].z < shark.z) { //새로운 상어가 더 크다면
				newGraph[r][c] = new Shark(shark.s, shark.d, shark.z);
			}
		}
	}

	public static int catchShark(int c) {
		for(int r = 1; r <= R; r++) {
			if(graph[r][c] != null) { //상어가 있으면
				Shark shark = graph[r][c];
				int size = shark.z; //상어 크기 저장
				
				graph[r][c] = null; //상어 사라진다
				
				return size;
			}
		}
		return 0; //상어 없음
	}

}
