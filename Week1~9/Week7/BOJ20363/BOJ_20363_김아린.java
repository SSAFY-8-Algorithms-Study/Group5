package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20363_김아린 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int X = Integer.parseInt(st.nextToken()); //필요한 온기
		int Y = Integer.parseInt(st.nextToken()); //필요한 수분
		
		int answer = 0;
		if(X >= Y) { //값이 더 큰 것을 먼저 준다
			answer = X + (Y / 10) + Y; //필요한 온기 + 손실될 온기 + 필요한 수분 
		}else {
			answer = Y + (X / 10) + X; //필요한 수분 + 손실될 수분 + 필요한 온기
		}
		
		System.out.println(answer);
	}

}
