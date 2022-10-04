import java.util.Scanner;

public class BOJ_1193_김주성 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 대각선에서의 순서
        int count = 1; // 대각선의 번호
        while(n > count){ // 분수의 위치 계산
            n -= count++;
        }
        // count 번째 대각선의 n 번째의 수 계산
        if(count % 2 == 0){
            int denominator = n; // 분자는 그대로 (1->2->3.. 으로 바뀜)
            int numerator = count + 1 - n; // 분모는 (count -> count -1 -> count -2... 로 바뀜)
            System.out.println(denominator + "/" + numerator);
        }else{
            int denominator = count + 1 - n; // 분자는 (count -> count -1 -> count -2... 로 바뀜)
            int numerator = n; // 분모는 그대로 (1->2->3.. 으로 바뀜)
            System.out.println(denominator + "/" + numerator);
        }
    }
}
