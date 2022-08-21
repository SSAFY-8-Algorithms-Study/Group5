package day0820.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960_김지환 {
	static int N, K;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int []arr = new int[N+1];
	
		PrimePrint(N,K, arr);
		System.out.println(sb);
	}
	//지우지 않는 수를 0으로 지운 수를 1로한다. 
	private static void PrimePrint(int N, int K, int[] arr) {
		arr[1] = 1;
		int cnt = 0;
		//2부터 N까지 모든 정수를 적는다.
		for(int i=1; i<arr.length; i++) {
			//아직 지우지 않는 수 중 가장 작은수를 찾는다. 이것을 P라고 하고 이 수는 소수이다.
			if(arr[i] == 1) continue;
			
			else {
				arr[i] =1;
				cnt++;
				if(cnt == K) {
					sb.append(i);
				}
				//P를 지우고 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
				for(int j = 2*i; j<arr.length; j+=i) {
					if(arr[j] == 1) continue;
					arr[j] = 1;
					cnt++;
					if(cnt == K) {
						sb.append(j);
					}
				}
			}
				
		}
	}
}
