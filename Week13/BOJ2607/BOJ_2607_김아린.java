import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2607_김아린 {
	static char[] chs1, chs2;
	static int[] alphabet1, alphabet2;
	static boolean isSimilar;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        chs1 = br.readLine().toCharArray(); //첫번째 단어
        
        alphabet1 = new int[26];
        for(int i = 0; i < chs1.length; i++) { //알파벳 구성 구하기
            alphabet1[chs1[i] - 65]++;
        }
        
        int answer = 0;
        for(int i = 1; i < N; i++) { //두번째 단어부터 비슷한 단어인지 판단하기
        	isSimilar = false;
        	
        	//비교할 단어 입력& 알파벳 구성 구하기
        	chs2 = br.readLine().toCharArray();
            
            alphabet2 = new int[26];
            for(int j = 0; j < chs2.length; j++) {
                alphabet2[chs2[j] - 65]++;
            }
            
            
            //판단하기
            judge();
            
            if(isSimilar) {
            	answer++;
            }
        }
        
        //출력
        System.out.println(answer);
    }
    
	public static void judge() {
		if(Math.abs(chs1.length - chs2.length) <= 1) { //글자수 차이가 1이하인 경우
			int count = 0; //다른 알파벳 수 세기
			
			for(int i = 0; i < 26; i++) {
				count += Math.abs(alphabet1[i] - alphabet2[i]);
			}
			
			if(count <= 2) { //0: 같은 구성, 1: 한 문자 더하거나 빼거나함 2: 한 문자를 다른 문자로 대체
				if(count == 0) {
					isSimilar = true;
				} else {
					if(chs1.length > 1 || chs2.length > 1) {
						isSimilar = true;
					}
				}
			}
		}
	}

}
