import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286_김주성 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] cmds;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cmds = new int[N];
        for (int i = 0; i < N; i++) {
            cmds[i] = Integer.parseInt(br.readLine());
        }
    }

    static class NUM implements Comparable<NUM> { // 숫자 객체
        int num;

        public NUM(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(NUM o) {
            // 오름차순 정렬 : 절대값 -> 마이너스
            if (Math.abs(this.num) > Math.abs(o.num)) { // 절대값이 다르면
                return 1;
            } else if (Math.abs(this.num) == Math.abs(o.num)) {
                long n = (long) this.num * o.num;
                if (n < 0) { // 둘 중 하나가 음수 이면
                    if (this.num < 0) return -1;
                    return 1;
                } else { // 둘다 부호가 같으면
                    return 0;
                }
            } else {
                return -1;
            }
        }
    }

    static void pro() {
        PriorityQueue<NUM> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (cmds[i] != 0) { // 우선 순위 큐에 삽입
                pq.add(new NUM(cmds[i]));
            } else { // 우선 순위 큐에서 삭제
                if (!pq.isEmpty()) { // 우선 순위 큐에 원소가 있으면
                    sb.append(pq.poll().num).append('\n');
                } else { // 우선 순위 큐가 비어 있으면
                    sb.append('0').append('\n');
                }
            }
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}