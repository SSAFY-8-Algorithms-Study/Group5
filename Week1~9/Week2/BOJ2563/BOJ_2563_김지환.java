package com.ssafy.study.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2563_김지환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N =0;
		int M = 0;
		int sum = 0;
		int [][]confetti = new int[100][100];
		for(int tc=0;tc<T;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			for(int i=N;i<N+10;i++) {
				for(int j=M;j<M+10;j++) {
					confetti[i][j]=1;
				}
					
				}
			}
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(confetti[i][j]==1)
					sum+=confetti[i][j];
			}
		}
		System.out.println(sum);
	}

}
