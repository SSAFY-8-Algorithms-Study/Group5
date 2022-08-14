import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1213_김주성 {
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ht = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            set.add(c);
            if (!ht.containsKey(c)) {
                ht.put(c, 1);
            } else {
                ht.put(c, ht.get(c) + 1);
            }
        }
        alpha = new ArrayList<>(set);
        Collections.sort(alpha); // 알파벳을 오름 차순으로 정렬
    }

    static List<Character> alpha; // 알파벳
    static Map<Character, Integer> ht; // 알파벳 : 알파벳 개수

    static void pro() {
        int odd = 0; //홀수 알파벳의 수
        for (char c : alpha) if (ht.get(c) % 2 == 1) odd++;

        if (odd > 1) { // 홀수 알파벳이 2이상이면 (홀수가 1 or 0 개만 팰린드롬 가능)
            sb.append("I'm Sorry Hansoo");
            return;
        }

        char odd_alpha = 'a'; // 홀수 알파벳 초기화
        // 홀수 알파벳 검색
        for (char c : alpha) if (ht.get(c) % 2 == 1) odd_alpha = c;
        // 팰린드롬 그리기 시작 (3 부분으로 그림)
        // 1 단계: 모든 알파벳의 대하여 '알파벳 개수 / 2'만큼 팰린드롬에 더함
        for (char c : alpha) for (int i = 0; i < ht.get(c) / 2; i++) sb.append(c);
        // 2단계: 팰린드롬의 가운데는 홀수 알파벳 or 없음
        if (odd_alpha != 'a') sb.append(odd_alpha);
        // 3 단계: 모든 알파벳의 대하여 '알파벳 개수 / 2'만큼 팰린드롬에 더함 (역순)
        Collections.sort(alpha, Collections.reverseOrder());
        for (char c : alpha) for (int i = 0; i < ht.get(c) / 2; i++) sb.append(c);

        System.out.println(sb.toString()); //정답 출력
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
