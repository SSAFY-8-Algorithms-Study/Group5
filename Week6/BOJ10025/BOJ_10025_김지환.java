package day0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10025_김지환 {

	static int[] arr;
	static int maxsum;
	static LinkedList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N  = Integer.parseInt(st.nextToken());
		int K  = Integer.parseInt(st.nextToken());
		arr = new int[31];
		list = new LinkedList<>();
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(in.readLine());
			int ice = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[x] = ice; 
		}
		int window = 1+(2*K);
		windowsum(window);
		System.out.println(maxsum+1);
	}

	private static void windowsum(int window) {
		maxsum = Integer.MIN_VALUE;
		int sum =0;
		for(int i=0; i<arr.length; i++) {
			if(i>=window) {
				sum -= arr[i-window];
			}
			sum +=arr[i];
			maxsum = Math.max(maxsum, sum);
		}
		
	}
}
	

