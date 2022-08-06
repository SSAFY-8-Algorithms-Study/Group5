package com.ssafy.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931_김지환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(in.readLine());
		int [][]people = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			people[i][0] = Integer.parseInt(st.nextToken());
			people[i][1] = Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}else {
					return o1[1]-o2[1];
				}
			}
			
		});
		
		int end = 0;
		int cnt =0;
		for(int i=0;i<N;i++) {
			if(end<=people[i][0]) {
				cnt++;
				end = people[i][1];
			}
		}
		System.out.println(cnt);
	}

}
