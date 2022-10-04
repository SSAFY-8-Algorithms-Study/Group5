package com.ssafy.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_김지환 {
	static int N;
	static int[][]arr;
	static int white;
	static int blue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		quad(0,0,arr.length);
		System.out.println(white);
		System.out.println(blue);
	}
	//1,2,3,4사분면 나누기 
	private static void quad(int row, int col, int size) {
		if(color_check(row, col, size)) {
			if(arr[row][col] == 1)
				blue+=1;
			else if(arr[row][col]==0)
				white+=1;
			return;
		}
		size = size / 2;
		//1사분면
		quad(row,col,size);
		//2사분면
		quad(row+size,col,size);
		//3사분면
		quad(row,col+size,size);
		//4사분면
		quad(row+size,col+size,size);
	}
	
	// 컬러 체크 -> 블루인지 화이트인지 탐색을 함 
	private static boolean color_check(int row, int col, int size) {
		//첫번쨰 컬러는 배열의 첫원소로 주어진다. 
		int color = arr[row][col];
		for(int i=row; i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(arr[i][j]!=color)
					return false;
			}
		}
		return true;
	}
}
