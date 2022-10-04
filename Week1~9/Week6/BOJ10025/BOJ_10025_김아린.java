package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10025_김아린 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //양동이 개수
		int K = Integer.parseInt(st.nextToken()); //떨어진 거리
		
		int[] arr = new int[1000001]; //좌표-얼음 저장
		
		int min_x = 1000001;
		int max_x = -1;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			arr[x] = g;
			
			min_x = Math.min(min_x, x);
			max_x = Math.max(max_x, x);
		}
		
		int max = 0;
		
		//누적합 구하기 - 슬라이딩 윈도우
		int sum = 0;
		int length = 2 * K + 1;
		
		for(int i = min_x; i <= max_x; i++) {
			sum += arr[i];
			
			if(i >= min_x + length) {
				sum -= arr[i - length];
			}
			
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

}
