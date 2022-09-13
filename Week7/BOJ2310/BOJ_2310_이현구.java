import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2310 {
	static int n;
	static char[] type;
	static boolean check;
	static ArrayList<Integer>[] arr;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			type = new char[n + 1];
			arr = new ArrayList[n + 1];
			check = false;

			// 방 type과,금액 ,번호 입력 받기
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				// n번 방 갈 수 있는지 체크하는 변수;
				// 방의 type 받는 배열
				type[i] = st.nextToken().charAt(0);
				// 나머지 정수들 입력받는 배열
				arr[i] = new ArrayList<>();
				// 몇번째 방인지 번호 입력 받기
				arr[i].add(i);
				// 정해놓은 금액 입력 받기
				arr[i].add(Integer.parseInt(st.nextToken()));
				// 갈 수 있는 문의 번호 입력 받기
				while (true) {
					int a = Integer.parseInt(st.nextToken());
					if (a == 0)
						break;
					arr[i].add(a);
				}
			}

			visit = new boolean[n + 1];
			dfs(arr[1], type[1], 0);

			if (check)
				System.out.println("Yes");
			else
				System.out.println("No");

		}

	}

	private static void dfs(ArrayList<Integer> list, char t, int cur_money) {
		int room_num = list.get(0);
		int money = list.get(1);
		if (t == 'L') {
			if (cur_money < money)
				cur_money = money;
		}
		if (t == 'T') {
			if (cur_money >= money)
				cur_money -= money;
			else
				return;
		}
		if (room_num == n) {
			check = true;
			return;
		}
		for (int i = 2; i < list.size(); i++) {
			int idx = list.get(i);
			if (!visit[idx]) {
				visit[idx] = true;
				dfs(arr[idx], type[idx], cur_money);
				visit[idx] = false;
			}
		}
	}
}