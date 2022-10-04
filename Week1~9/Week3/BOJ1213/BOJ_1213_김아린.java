import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		int[] alphabet = new int[26];
		
		for(int i = 0; i < input.length(); i++) { //알파벳 수 저장
			alphabet[input.charAt(i) - 'A']++;
		}
		
		int oddCount = 0;
		char oddChar = ' ';
		for(int i = 0; i < 26; i++) { //홀수개인 알파벳 개수 세기
			if(alphabet[i] % 2 == 1) {
				oddCount++;
				oddChar = (char)(i + 65);
			}
			
			if(oddCount == 2) break;
		}
		
		String answer = "";
		if(oddCount == 2) { //불가능
			answer = "I'm Sorry Hansoo";
		} else { //홀수개인 알파벳 0개 or 1개
			String front = "";
			String tail = "";
			
			for(int i = 0; i < 26; i++) {
				if(alphabet[i] >= 2) {
					for(int j = 0; j < alphabet[i] / 2; j++) {
						front += (char)(i + 65);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder(front);
			tail = sb.reverse().toString();
			
			if(oddCount == 0) { //정답 도출
				answer = front + tail;
			}else if(oddCount == 1){
				answer = front + oddChar + tail;
			}
		}
		
		//출력
		System.out.println(answer);
	}

}
