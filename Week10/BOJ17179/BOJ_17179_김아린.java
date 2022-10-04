import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17179_김아린 {
	static int N, M, L;
	static int[] S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		N = Integer.parseInt(st.nextToken()); //자르는 횟수가 담긴 목록의 길이
		M = Integer.parseInt(st.nextToken()); //자를 수 있는 지점의 개수
		L = Integer.parseInt(st.nextToken()); //롤 케이크의 길이
		
		S = new int[M];
		
		for(int i = 0; i < M; i++) {
			S[i] = Integer.parseInt(br.readLine()); //자를 수 있는 지점 - 오름차순
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int q = Integer.parseInt(br.readLine()); //자르는 횟수 - 오름차순
		
			//이분탐색
			int answer = binarySearch(q);
			
			//출력
			sb.append(answer + "\n");
		}
		
		//출력
		System.out.println(sb);
	}

	public static int binarySearch(int q) {
		int answer = 0;
		int left = 0;
		int right = L;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			//mid 길이로 잘랐을 때 얻을 수 있는 조각 수 구하기
			int slice = mid;
			int count = 0; //조각 수
			for(int i = 0; i < M; i++) {
				if (S[i] < slice) continue;
		    	if (S[i] + mid > L) break;
		    	slice = S[i] + mid;
		    	count++;
			}
			
			if(count < q) { //자를 수 있는 조각이 더 작으면
				right = mid - 1; //길이 줄이기(조각 수 늘리기)
        	} else { //자를 수 있는 조각이 많으면
        		left = mid + 1; //길이 늘리기(조각 수 줄이기)
        		answer = mid;
        	}
		}
		return answer;
	}

}
