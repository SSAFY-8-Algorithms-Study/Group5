import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043_김아린 {
	static int N, M;
	static boolean[] check;
	static ArrayList<Integer>[] party;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		check = new boolean[N + 1]; //거짓말 아는 사람 저장
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken()); //진실을 아는 사람의 수
		for(int i = 0; i < A; i++) {
			int x = Integer.parseInt(st.nextToken());
			check[x] = true;
		}
		
		party = new ArrayList[M];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int B = Integer.parseInt(st.nextToken()); //파티오는 사람 수
			
			party[i] = new ArrayList<>();
			
			for(int j = 0; j < B; j++) {
				int x = Integer.parseInt(st.nextToken());
				
				party[i].add(x);
			}
		}
		
		//다른 파티에 전달해주기
		talk();
		
		//과장된 이야기를 할 수 있는 파티 개수 구하기
		int count = 0;
		for(int i = 0; i < M; i++) {
			boolean possible = true;
			
			for(int x : party[i]) {
				if(check[x]) { //진실 아는 사람 있으면
					possible = false;
				}
			}
			
			if(possible) count++;
		}
		
		//출력
		System.out.println(count);
	}

	public static void talk() {
		for(int i = 0; i < M; i++) {
			for(Integer n : party[i]) {
				if(check[n]) { //진실 아는 사람 있음
					for(Integer x : party[i]) {
						if(!check[x]) {
							check[x] = true;
							talk(); //진실 전달하기
						}
					}
				}
			}
		}
	}

}
