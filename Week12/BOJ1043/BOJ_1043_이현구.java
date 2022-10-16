import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1043 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		int truth_num = sc.nextInt();
		if (truth_num > 0) {
			for (int i = 0; i < truth_num; i++) {
				arr.add(sc.nextInt());
			}
		}

		ArrayList<Integer>[] list = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			list[i] = new ArrayList<>();
			int num = sc.nextInt();
			for (int j = 0; j < num; j++) {
				list[i].add(sc.nextInt());
			}
		}

		for (int s = 0; s < M; s++) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < arr.size(); j++) {
					int t = arr.get(j);
					if (list[i].contains(t)) {
						for (int k = 0; k < list[i].size(); k++) {
							if (!arr.contains(list[i].get(k)))
								arr.add(list[i].get(k));
						}
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			boolean check = false;
			for (int j = 0; j < arr.size(); j++) {
				if (check) {
					continue;
				}
				int t = arr.get(j);
				if (list[i].contains(t)) {
					check = true;
				}
			}

			if (!check) {
				cnt++;
			}
		}
		//System.out.println(arr);
		System.out.println(cnt);
	}
}
