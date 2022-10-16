import java.util.HashSet;
import java.util.Scanner;

public class BOJ_14225 {
	static int N;
	static int[] arr;
	static boolean[] visit;
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		subset(0);
		//System.out.println(set);
		for(int i=1; i<2000001; i++) {
			if(!set.contains(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	private static void subset(int cnt) {

		if (cnt == N) {
			int sum =0;
			for (int i = 0; i < N; i++) {
				if (visit[i]) {
					sum+= arr[i];
				}
			}
			set.add(sum);
			return;
		}

		visit[cnt] = true;
		subset(cnt + 1);
		visit[cnt] = false;
		subset(cnt + 1);
	}
}
