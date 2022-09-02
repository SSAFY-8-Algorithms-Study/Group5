import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10162_김아린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int A = 300; //5분
		int B = 60; //1분
		int C = 10; //10초
		
		int countA = 0, countB = 0, countC = 0;
		
		while(T >= 300) {
			T -= 300;
			countA++;
		}
		
		while(T >= 60) {
			T -= 60;
			countB++;
		}
		
		while(T >= 10) {
			T -= 10;
			countC++;
		}
		
		//출력
		if(T == 0) { //버튼으로 정확히 맞출 수 있음
			System.out.println(countA + " " + countB + " " + countC);
		}else { //T초 맞출 수 없음
			System.out.println(-1);
		}
	}

}
