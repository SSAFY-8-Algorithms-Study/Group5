import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_김주성 {
    static int bule;
    static int white;
    static int[][] board;

    static class Dot{
        //종이의 왼쪽위 첫번째 위치
        int x;
        int y;

        public Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean check(Dot dot, int color, int n){
        //종이가 모두 같은 색인지 검사
        boolean isSameColor = true;
        for(int i = dot.x; i < n+dot.x; i++){
            for(int j = dot.y; j < n+dot.y; j++){
                if(board[i][j] != color){
                    isSameColor = false;
                    break;
                }
            }
            if(!isSameColor){
                break;
            }
        }
        return isSameColor;
    }

    static void search(Dot[] dots, int n){
        for(Dot dot : dots){//배열로 받은 모든 종이에 대해서 반복
            if(check(dot, 0, n)){//dot의 종이가 모두 0(하얀색)이면
                white++;
            }else if(check(dot, 1, n)){//dot의 종이가 모두 1(파란색)이면
                bule++;
            }else{
                int nextN = n / 2; // 현재 종이의 변을 반으로 자름
                Dot[] nextDots = new Dot[4];// 현재 종이를 4딩분으로 나누어 저장
                nextDots[0] = new Dot(dot.x, dot.y);// 현재 종이의 1사분면
                nextDots[1] = new Dot(dot.x+nextN, dot.y);// 현재 종이의 2사분면
                nextDots[2] = new Dot(dot.x, dot.y+nextN);// 현재 종이의 3사분면
                nextDots[3] = new Dot(dot.x+nextN, dot.y+nextN);// 현재 종이의 4사분면
                search(nextDots, nextN);//nextDots: 자른 종이 4개, nextN: 자른 종이의 변의 길이
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n]; //정사각형 모양의 종이
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }//end input
        Dot[] dots = new Dot[1];
        dots[0] = new Dot(0, 0); // 왼쪽의 첫번째에서 시작
        search(dots, n); // 종이 자르기
        System.out.println(white);
        System.out.println(bule);
    }
}
