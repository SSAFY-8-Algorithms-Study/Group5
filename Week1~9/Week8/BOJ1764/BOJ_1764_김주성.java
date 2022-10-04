import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static HashSet<String> set = new HashSet<>();
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            int size = set.size();
            String name = br.readLine();
            set.add(name);
            if (size == set.size()) result.add(name);
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (String name: result) {
            System.out.println(name);
        }
    }
}
