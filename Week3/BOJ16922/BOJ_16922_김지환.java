package com.ssafy.week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16922_김지환 {
	
	static int N;
	static int[] roma;;
	static int[] input;
	static int[] sum;
	static int totalCnt = 0;
	static void comb(int total,int depth, int start) {
		if(depth == N) {
			//total을 sum 배열에 저장!!! 만약 0 이면 방문했다는 증거를 남기기 위해 1를 할당시킴
			if(sum[total] == 0) {
				sum[total] = 1;
				//할당시킨수 만큼 total 카운트 세기 
				totalCnt++;
			}
			return;
		}
		
		//중복 조합 
		for(int i=start; i<4;i++) {
			comb(total+roma[i],depth+1,i);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		roma = new int[]{1,5,10,50};
		sum = new int[1001];
		comb(0,0,0);
		System.out.println(totalCnt);
	}

}