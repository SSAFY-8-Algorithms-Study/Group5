package com.ssafy.week3;
import java.util.Scanner;

public class BOJ_1193_김지환{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int cross_count = 1;
		int tail_sum = 0;
		//1<=X<=10000000000
		for(int i=1;i<=10000000;i++) {
			//대각선 누적합과 해당 대각선을 이용하여 범위 판별 
			if(X<=cross_count+tail_sum) {
				//대각선의 타일 갯수가 짝수 , 분모와 분자의 합이 홀수인경우 
				//분모가 큰 수부터 시작을 함.
				//분모는 대각선상 내의 블럭 개수 - (X번째 - 직전 대각선까지의 블럭 개수 -1)
				//분자는 x번째 - 직전 대각선까지의 블럭개수 
				if(cross_count % 2 == 0) {
					System.out.println((X-tail_sum)+"/"+(cross_count-(X-tail_sum-1)));
					break;
				}
				//대각선의 타일 갯수가 홀수, 분모와 분자의 합이 짝수인 경우 왼쪽 아랫방향
				else {
					//반대로 
					System.out.println((cross_count-(X-tail_sum-1))+"/"+(X-tail_sum));
					break;					
				}
			}
			else {
				tail_sum += cross_count;
				cross_count++;
			}
		}
	}

}
