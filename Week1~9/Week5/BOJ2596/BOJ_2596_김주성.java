import java.util.HashMap;
import java.util.Scanner;

public class BOJ_2596_김주성 {
    static HashMap<String, Integer> ht;
    static HashMap<String, String> ht2;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        ht = new HashMap<>();
        ht2 = new HashMap<>();
        ht.put("000000", 0);
        ht.put("001111", 15);
        ht.put("010011", 19);
        ht.put("011100", 28);
        ht.put("100110", 38);
        ht.put("101001", 41);
        ht.put("110101", 53);
        ht.put("111010", 58);
        ht2.put("000000", "A");
        ht2.put("001111", "B");
        ht2.put("010011", "C");
        ht2.put("011100", "D");
        ht2.put("100110", "E");
        ht2.put("101001", "F");
        ht2.put("110101", "G");
        ht2.put("111010", "H");


        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String str = scan.next();
        int idx = -1;
        for (int i = 1; i <= n; i++) {
            String s = str.substring(6*(i-1), 6*i);
            int count = 0;
            for (String key: ht.keySet()) {
                count = compare_binary(key, s);
                if (count < 2) {
                    sb.append(ht2.get(key));
                    break;
                }
            }
            if (count >= 2) {
                idx = i;
                break;
            }
        }
        if (idx > 0) {
            System.out.println(idx);
        } else {
            System.out.println(sb.toString());
        }
    }

    static int compare_binary(String b1, String b2) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (b1.charAt(i) != b2.charAt(i)) count++;
        }
        return count;
    }
}
