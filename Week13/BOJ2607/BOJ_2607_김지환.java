package day1020;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2607_비슷한단어_김지환 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] alphabet = new int[26];
        int[] alphabet2 = new int[26];
        String word = in.readLine();
        //첫 단어의 길이 DOG = 3이다. 
        int len = word.length();
        int ansCnt =0;
        for(int i=0;i<word.length();i++) {
            alphabet[word.charAt(i)-'A']++;
        }

        System.out.println(Arrays.toString(alphabet));
        System.out.println("-----------------------------------------");
        for(int i=0;i<N-1;i++) {

            String word2 = in.readLine();
            alphabet2 = alphabet.clone();
            int res = 0;
            //현재 단어와 비슷한 단어인지 비교하기 위해 2번째 줄에서 입력받은 해당알파벳값이 0보다크면 해당 단어와 비슷한  단어이거나 같은 단어이므로 count를 해주고 그 인덱스의 값은 감소시켜준다.
            for(int j=0; j<word2.length();j++){
                if(alphabet2[word2.charAt(j)-'A']> 0){
                    res++;
                    alphabet2[word2.charAt(j)-'A']--;
                }
            }
            System.out.println(res);
            //len : 기준 문자열의 길이
            //res : 기준 문자열과 비교할 문자열과의 비교한 카운트
            //기준문자열에서 길이가 하나 크지만 뺄 수 있는 경우
            
            //첫 단어에서의 길이를 하나를 빼고 그 단어가 같은 구성을 같은 경우는 비슷한 단어의 경우가 된다. 
            //예를 들어 첫단어가 DOG이고 다음으로 들어오는 단어가 DO 일떄 
            if(len-1==word2.length() && res == word2.length()){
                ansCnt++;
            }
            //길이가 같은 경우
            if(len == word2.length()){
            	//이 단어가 첫 단어의 길이가 같거나 하나를 빼도 비슷한 단어이기때문에 카운팅을 한다. 
            	//DOO -> DOG
                if(res == len || res==len-1)
                {
                    ansCnt++;
                }
            }
            //비교문자열이 길이가 하나 크고 추가시킬 수 있는 경우
            //GOD -> GOOD
            if(len+1==word2.length()){
                if(len==res)
                {
                    ansCnt++;
                }
            }
        }
        System.out.println(ansCnt);
    }

}
