import java.util.Scanner;

public class BOJ_2447_김주성 {
    static StringBuilder[] sb;
    static int N;

    static void write(int state, int line) {
        if(state == 1) { //  구역에 별이 있을 때
            sb[line-2].append("***");
            sb[line-1].append("* *");
            sb[line].append("***");
        } else { // state == 0, 구역이 비어 있을때
            sb[line-2].append("   ");
            sb[line-1].append("   ");
            sb[line].append("   ");
        }
    }

    static void rec_func(int n,  int state, int line) {
        // n: 구역의 크기, state: 0-> 비어 있음, 1-> 별이 있음, line: 구역의 마지막 줄의 번호
        if (n == 3) { // 최소 구역의 크기
            write(state, line); //
            return;
        }
        if (state == 0) { // 헤딩 구역이 비어 있으면, 이후 작은 구역도 모두 비어 있음
            rec_func(n / 3, 0, line - n / 3 * 2);
            rec_func(n / 3, 0, line - n / 3 * 2);
            rec_func(n / 3, 0, line - n / 3 * 2);
            rec_func(n / 3, 0, line - n / 3);
            rec_func(n / 3, 0, line - n / 3);
            rec_func(n / 3, 0, line - n / 3);
            rec_func(n / 3, 0, line);
            rec_func(n / 3, 0, line);
            rec_func(n / 3, 0, line);
        } else {
            rec_func(n / 3, 1, line - n / 3 * 2);
            rec_func(n / 3, 1, line - n / 3 * 2);
            rec_func(n / 3, 1, line - n / 3 * 2);
            rec_func(n / 3, 1, line - n / 3);
            rec_func(n / 3, 0, line - n / 3);
            rec_func(n / 3, 1, line - n / 3);
            rec_func(n / 3, 1, line);
            rec_func(n / 3, 1, line);
            rec_func(n / 3, 1, line);
        }

    }

    static void pro() {
        sb = new StringBuilder[N + 1]; // 입력받은 수 만큼 줄을 생성
        for (int i = 1; i <= N; i++) sb[i] = new StringBuilder();
        rec_func(N, 1, N);
        for (int i = 1; i <= N; i++) {
            System.out.println(sb[i].toString());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        pro();
    }
}