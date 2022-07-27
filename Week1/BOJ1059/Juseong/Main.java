import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] S = new int[L];
        for(int i = 0; i < L; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(S);
        int n = Integer.parseInt(br.readLine());
        int a = 0;//구간 시작 수 초기화
        int b = 0;//구간 끝 수 초기화
        boolean exist = false;
        for(int i = 0; i < S.length; i++){
            if(S[i] == n){//S에 n이 존재하면
                exist = true;
                break;
            }else if(i + 1 < S.length){
                if(S[i] < n && S[i+1] > n){
                    a = S[i];
                    b = S[i + 1];
                    break;
                }
            }
        }
        int count = 0;
        if(!exist){
            int A = n - (a + 1); //a와 n사이의 수의 개수
            int B = b - 1 - n;//n과 b사이의 수의 개수
            if (n < S[0]){//n이 S[0]보다 작을 때
                a = 1;
                b = S[0] - 1;
                A = n - a; //a와 n사이의 수의 개수
                B = b - n;//n과 b사이의 수의 개수
            }
            //CASE1: n이 사이에 있는 구간
            count += A * B;
            //CASE2: n으로 끝나는 구간
            count += A;
            //CASE3: n으로 시작하는 구간
            count += B;
        }
        System.out.println(count);
    }
}
