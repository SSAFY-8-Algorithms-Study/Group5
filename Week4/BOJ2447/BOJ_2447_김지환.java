package day0820.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_2447_김지환 {

	static char[][] star;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		star  = new char[N][N];
		starPrint(0,0,N,false);
		
		for(int i=0;i<N;i++) {
			for(int j=0; j<N; j++) {
//				System.out.print(star[i][j]);
				sb.append(star[i][j]);
			}
			sb.append("\n");
//			System.out.println();
		}
		System.out.println(sb);
	}

	private static void starPrint(int x, int y, int size, boolean blank) {
		//빈칸 
		if(blank) {
			for(int i=x; i<x+size; i++) {
				for(int j=y; j<y+size; j++) {
					star[i][j] = ' ';
				}
			}
			return;
		}
		//size가 1이 되어 더 이상 나눌 수 없는 경우 
		if(size == 1) {
			star[x][y] = '*';
			return;
		}
		//N > 3이 넘어갈 경우 ex) N = 9, N =27일 때 3x3으로 나누어 가운데 빈칸을 넣어야함. 
		//size는 3으로 나누게 됨
		int newSize = size/3;
		//count 변수를 넣어 5일 때 빈칸을 true
		int count = 0;
		for(int i=x; i<x+size; i+=newSize) {
			for(int j=y; j<y+size; j+=newSize) {
				count++;
				if(count == 5) {
					starPrint(i,j,newSize, true);
				}
				else {
					starPrint(i,j,newSize, false);
				}
			}
		}
		//count 5가 아니면 false 
	}

}
