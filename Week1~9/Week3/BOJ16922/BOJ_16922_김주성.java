import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_16922_김주성 {
    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        set = new HashSet<>();
    }

    static int N; // 로마 숫자의 수
    static Set<Integer> set; // 결과값
    static int[] nums = {1, 5, 10, 50}; // I, V, X, L

    static void pro(int n) {
        for (int k = 0; k < 4; k++) { // 1 5 10 50 을 삽입, n == 1 일때
            set.add(nums[k]);
        }
        if (n > 1) { // n이 1보다 크면
            for(int i = 1; i < n; i++) { // n-1 번 반복
                Set<Integer> set2 = new HashSet<>(); // 새로운 set
                for (int num : set) { //set의 모든 수 꺼냄
                    for (int k = 0; k < 4; k++) { // 꺼낸 수 마다 1 5 10 50 을 더함
                        set2.add(num + nums[k]);
                    }
                }
                set = set2; // 새로운 set으로 변환
            }
        }
        System.out.println(set.size()); // 정답 출력
    }

    public static void main(String[] args) {
        input();
        pro(N);
    }
}
