package day0924;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_김지환 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int K = Integer.parseInt(st.nextToken());
		long N = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[K];
		
		long min = 0;
		long max = 0;
		long mid = 0;
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		/*
		 * 0 ~ 802
		 * 반으로 나누어 
		 * 0+802 = 401
		 * 1+1+2+1
		 * */
		Arrays.sort(arr);
		while(min < max) {
			mid = (min+max) /2 ;
			long count = 0;
			
			for(long e : arr) {
				count+=e/mid;
			}
			
			if(count < N) {
				max = mid;
				//202
				//202/
			}
			else {
				min = mid+1;
			}
		}
		System.out.println(min-1);
	}

}