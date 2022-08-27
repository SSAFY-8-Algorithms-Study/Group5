import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2596_김아린 {
	static String[] alphabet = {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		char[] text = br.readLine().toCharArray();
		
		String result = "";
		for(int i = 0; i < N; i++) { //문자의 개수 만큼 반복
			boolean isFind = false;
			
			for(int j = 0; j < 8; j++) { //알파벳만큼 반복
				int count = 0;
				
				for(int k = 0; k < 6; k++) { //숫자 하나하나 비교
					if(text[i * 6 + k] != alphabet[j].charAt(k)) {
						count++;
					}
					
					if(count > 1) { //숫자 2자 이상 다름
						break;
					}
				}
				
				if(count < 2) { //같은 문자이면
					isFind = true;
					result += (char)(j + 65); //문자 저장
					break;
				}
			}
			
			if(!isFind) { //모르는 문자 있으면
				result = Integer.toString(i + 1); //위치 저장
				break;
			}
		}
		
		//출력
		System.out.println(result);
	}

}
