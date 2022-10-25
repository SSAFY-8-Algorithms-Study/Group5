import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] alphabet = new int[26];
        int[] alphabet2 = new int[26];
        String word = in.readLine();
        int len = word.length();
        int ansCnt =0;
        for(int i=0;i<word.length();i++) {
            alphabet[word.charAt(i)-'A']++;
        }


        for(int i=0;i<N-1;i++) {

            String word2 = in.readLine();
            alphabet2 = alphabet.clone();
            int res = 0;
            for(int j=0; j<word2.length();j++){
                if(alphabet2[word2.charAt(j)-'A']> 0){
                    res++;
                    alphabet2[word2.charAt(j)-'A']--;
                }
            }
//            System.out.println(res);
            //len : 기준 문자열의 길이
            //res : 기준 문자열과 비교할 문자열과의 비교한 카운트
            //기준문자열에서 길이가 하나 크지만 뺄 수 있는 경우
            if(len-1==word2.length() && res == word2.length()){
                ansCnt++;
            }
            //길이가 같은 경우
            if(len == word2.length()){
                if(res == len || res==len-1)
                {
                    ansCnt++;
                }
            }
            //비교문자열이 길이가 하나 크고 추가시킬 수 있는 경우
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
