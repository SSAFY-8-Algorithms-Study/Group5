package day0819.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2290_김지환 {

	static int s;
	static String n;
	static char[][] display;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		s = Integer.parseInt(st.nextToken());
		n = st.nextToken();
		display = new char[2*s+3][(s+2)*n.length()+n.length()-1];
		for(int i=0;i<display.length;i++) {
			for(int j=0; j<display[i].length; j++) {
				display[i][j] = ' ';
			}
		}
		
		for(int i=0; i<n.length();i++) {
			segPrint(n.charAt(i)-'0',i,s,display);
			
		}
		for(int i=0;i<display.length;i++) {
			for(int j=0; j<display[i].length;j++) {
				System.out.print(display[i][j]);
			}
			System.out.println();
		}
		
		
	}
	
	//세그먼트 출력  //number, 현재 index, s, display 2차원 배열 
	private static void segPrint(int num, int loc, int size, char[][] display) {
		//현재 index에 따라서 열의 시작 포인트를 잡아줌 
		int x = loc*(size+3);
		int y = 0;
		//각 number를 세그먼트 넘버로 
		if(num == 1) {
			segment(x, y, size, display, 1);
			segment(x, y, size, display, 2);
		}
		else if(num == 2) {
			segment(x,y,size,display,1);
			segment(x,y,size,display,3);
			segment(x,y,size,display,5);
			segment(x,y,size,display,6);
			segment(x,y,size,display,7);
		}
		else if(num == 3){
			segment(x,y,size,display,3);
			segment(x,y,size,display,1);
			segment(x,y,size,display,2);
			segment(x,y,size,display,5);
			segment(x,y,size,display,7);
			
		}
		else if(num == 4) {
			segment(x,y,size,display,1);
			segment(x,y,size,display,2);
			segment(x,y,size,display,4);
			segment(x,y,size,display,5);
			
		}
		else if(num == 5) {
			segment(x,y,size,display,3);
			segment(x,y,size,display,4);
			segment(x,y,size,display,5);
			segment(x,y,size,display,2);
			segment(x,y,size,display,7);
			
		}
		else if(num == 6) {
			segment(x,y,size,display,3);
			segment(x,y,size,display,4);
			segment(x,y,size,display,5);
			segment(x,y,size,display,6);
			segment(x,y,size,display,2);
			segment(x,y,size,display,7);
			
		}
		else if(num == 7) {
			segment(x,y,size,display,3);
			segment(x,y,size,display,1);
			segment(x,y,size,display,2);
			
		}
		if(num == 8) {
			segment(x,y,size,display,1);
			segment(x,y,size,display,2);
			segment(x,y,size,display,3);
			segment(x,y,size,display,4);
			segment(x,y,size,display,5);
			segment(x,y,size,display,6);
			segment(x,y,size,display,7);
			
		}
		else if(num == 9) {
			segment(x,y,size,display,1);
			segment(x,y,size,display,2);
			segment(x,y,size,display,3);
			segment(x,y,size,display,4);
			segment(x,y,size,display,5);
			segment(x,y,size,display,7);
			
			
		}
		else if(num == 0) {
			segment(x,y,size,display,1);
			segment(x,y,size,display,2);
			segment(x,y,size,display,3);
			segment(x,y,size,display,4);
			segment(x,y,size,display,6);
			segment(x,y,size,display,7);
			
		}
	}
	//세그먼트 설정 
	private static void segment(int x, int y, int size, char[][]diplay, int segnum) {
		//7 세그먼트 기준 최상단의 오른쪽  
		if(segnum == 1) {
			int pos = 1;
			for(int i=0; i<size; i++) {
				display[i+pos][x+size+1] = '|';
			}
		}
		//7 세그먼트 기준 최하단의 오른쪽 
		else if(segnum == 2) {
			int pos = size+2;
			for(int i=0; i<size; i++) {
				display[i+pos][x+size+1] = '|';
			}
		}
		//7 세그먼트 기준 최상단 
		else if(segnum == 3) {
			
			for(int i=0; i<size;i++) {
				display[y][i+x+1] = '-';
			}
		}
		//7 세그먼트 기준 최상단 좌측 
		else if(segnum == 4) {
			int pos = 1;
			for(int i=0;i<size;i++) {
				display[i+pos][x] = '|';
			}
		}
		//7 세그먼트 기준 가운데 
		else if(segnum == 5) {
			int pos = size+1;
			for(int i = 0; i<size;i++) {
				display[y+pos][i+x+1] = '-';
			}
		}
		
		//7 세그먼트 기준 최하단의 좌측 
		else if(segnum == 6) {
			int pos = size+2;
			for(int i=0; i<size; i++) {
				display[i+pos][x] = '|';
			}
		}
		
		//7세그먼트 기준 최하단 
		else if(segnum == 7) {
			int pos = 2*size+2;
			for(int i=0;i<size;i++) {
				display[y+pos][i+x+1] = '-';
			}
		}
	}
}

