import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3425_김주성 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    static boolean input() throws IOException {
        sb = new StringBuilder();
        deque = new LinkedList<>();
        nums = new LinkedList<>();
        cmds = new LinkedList<>();
        String line = br.readLine();
        if(line.equals("QUIT")) return false;
        while(!line.equals("END")) {
            StringTokenizer st = new StringTokenizer(line);
            String cmd = st.nextToken();
            cmds.add(cmd);
            if(cmd.equals("NUM")) nums.add(Integer.parseInt(st.nextToken()));
            line = br.readLine();
        }
        N = Integer.parseInt(br.readLine());
        V = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            V.add(Integer.parseInt(br.readLine()));
        }
        br.readLine();
        return true;
    }

    static Deque<Integer> deque; // 스택
    static List<Integer> V; // 프로그램의 입력값
    static Queue<Integer> nums; // NUM 명령어의 X
    static List<String> cmds; // 프로그램의 명령어
    static int N; // // 프로그램의 입력값의 수

    static void pro() {
        for (int v : V) {
            boolean isError = false;
            deque.add(v);
            Queue<Integer> queue1 = new LinkedList<>(nums);
            for (String cmd : cmds) {
                if (cmd.equals("NUM")) {
                    // NUM X: X를 스택의 가장 위에 저장한다. (0 ≤ X ≤ 109)
                    deque.addLast(queue1.poll());
                } else if (cmd.equals("POP")) {
                    // POP: 스택 가장 위의 숫자를 제거한다.
                    if (deque.isEmpty()) {
                        isError = true;
                    } else {
                        deque.pollLast();
                    }
                } else if (cmd.equals("INV")) {
                    // INV: 첫 번째 수의 부호를 바꾼다. (42 -> -42)
                    if (deque.isEmpty()) {
                        isError = true;
                    } else {
                        int n = deque.pollLast();
                        n *= -1;
                        deque.addLast(n);
                    }
                } else if (cmd.equals("DUP")) {
                    // DUP: 첫 번째 숫자를 하나 더 스택의 가장 위에 저장한다.
                    if (deque.isEmpty()) {
                        isError = true;
                    } else {
                        int n = deque.peekLast();
                        deque.addLast(n);
                    }
                } else if (cmd.equals("SWP")) {
                    // SWP: 첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
                    if (deque.size() < 2) {
                        isError = true;
                    } else {
                        int n1 = deque.pollLast();
                        int n2 = deque.pollLast();
                        deque.addLast(n1);
                        deque.addLast(n2);
                    }
                } else if (cmd.equals("ADD")) {
                    // ADD: 첫 번째 숫자와 두 번째 숫자를 더한다.
                    if (deque.size() < 2) {
                        isError = true;
                    } else {
                        int n1 = deque.pollLast();
                        int n2 = deque.pollLast();
                        if (n1 + n2 > 1000000000) { // 예외 : 10^9초과
                            isError = true;
                        } else{
                            deque.addLast(n1 + n2);
                        }
                    }
                } else if (cmd.equals("SUB")) {
                    // SUB: 첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번째)
                    if (deque.size() < 2) {
                        isError = true;
                    } else {
                        int n1 = deque.pollLast();
                        int n2 = deque.pollLast();
                        if (n2 - n1 < -1000000000) { // 예외 : -10^9초과
                            isError = true;
                        } else {
                            deque.addLast(n2 - n1);
                        }
                    }
                } else if (cmd.equals("MUL")) {
                    // MUL: 첫 번째 숫자와 두 번째 숫자를 곱한다.
                    if (deque.size() < 2) {
                        isError = true;
                    } else {
                        int n1 = deque.pollLast();
                        int n2 = deque.pollLast();
                        long n3 = (long) n1 * (long) n2;
                        if (n3 > 1000000000) { // 예외 : 10^9초과
                            isError = true;
                        } else{
                            deque.addLast(n1 * n2);
                        }
                    }
                } else if (cmd.equals("DIV")) {
                    // DIV: 첫 번째 숫자로 두 번째 숫자를 나눈 몫을 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
                    if (deque.size() < 2) { // 예외 : 숫자가 2개 미만이면
                        isError = true;
                    } else {
                        int n1 = deque.pollLast();
                        int n2 = deque.pollLast();
                        if (n1 == 0) { // // 예외 : 0으로 나눌 경우
                            isError = true;
                        } else if ((n1 < 0 && n2 > 0) || (n1 > 0 && n2 < 0)) { // 결과가 음수인 경우
                            n1 = Math.abs(n1);
                            n2 = Math.abs(n2);
                            int n3 = -1 * (n2 / n1);
                            deque.addLast(n3);
                        } else { // 결과가 양수인 경우
                            n1 = Math.abs(n1);
                            n2 = Math.abs(n2);
                            deque.addLast(n2 / n1);
                        }
                    }
                } else if (cmd.equals("MOD")) {
                    // MOD: 첫 번째 숫자로 두 번째 숫자를 나눈 나머지를 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
                    if (deque.size() < 2) { // 예외 : 숫자가 2개 미만이면
                        isError = true;
                    } else {
                        int n1 = deque.pollLast();
                        int n2 = deque.pollLast();
                        if (n1 == 0) { // 예외 : 0으로 나눌 경우
                            isError = true;
                        } else if (n2 < 0) { // 결과가 음수인 경우
                            n1 = Math.abs(n1);
                            n2 = Math.abs(n2);
                            int n3 = -1 * (n2 % n1);
                            deque.addLast(n3);
                        } else { // 결과가 양수인 경우
                            n1 = Math.abs(n1);
                            n2 = Math.abs(n2);
                            deque.addLast(n2 % n1);
                        }
                    }
                }
            }
            if (deque.size() != 1 || isError) { // 수가 1개가 아니거나 예외가 발생하면
                sb.append("ERROR\n");
            } else { // 수가 1개이면
                sb.append(deque.poll()).append('\n');
            }
            deque.clear();
        }
    }

    public static void main(String[] args) throws IOException {
        boolean con = input();
        while(con) {
            pro();
            System.out.println(sb.toString()); // 정답 출력
            con = input();
        }
    }
}