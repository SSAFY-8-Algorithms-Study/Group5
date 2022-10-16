package day1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_거짓말_김지환 {

	/*
	 * 거짓말 지민이는 파티에 가서 이야기 하는 것을 좋아함. 파티에 갈 때마다, 지민이는 가장 좋아하는 이야기를 함 지민이는 이야기를 말할 때
	 * 진실을 말하거나 과장해서(=거짓말)하는 것을 좋아함 과장해서 이야기 하는 것을 훨씬 더 재미있기 때문에 되도록이면 과장해서 이야기하려고
	 * 함. 하지만, 지민이는 거짓말쟁이로 알려지기는 싫어함. 문제는 몇몇 사람들은 그 이야기의 진실을 안다는 것임 이런 사람들이 파티에 왔을
	 * 떄는 지민이는 진실을 이야기할 수 밖에 없음 그럼 즉 사람들은 그 이야기의 진실을 아는 사람이 주어짐 이런사람을 피해야함. 만약 1 2 3
	 * 4 5 번에 번
	 */
	static int N, M;
	// 진실을 아는 사람의 수와 그 사람의 번호를 알기 위한 변수 그리고 각 파티에 오는 사람의 수와 사람의 번호 변수
	static int tn, truePeople, pn, partyPeople;
	// 거짓말을 알고 있는 사람 메모 boolean 배열
	static boolean[] isTrue;
	static boolean[][] visited;
	static int[][] party;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isTrue = new boolean[N + 1];
		int[][] party = new int[M][];
		visited = new boolean[N + 1][N + 1];
		st = new StringTokenizer(in.readLine());
		// 지민이의 진실을 알고 있는 사람의 수와 그 진실을 알고 있는 사람의 번호
		tn = Integer.parseInt(st.nextToken());
		for (int i = 0; i < tn; i++) {
			truePeople = Integer.parseInt(st.nextToken());
			isTrue[truePeople] = true;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			pn = Integer.parseInt(st.nextToken());
			//각 파티에 온 인원 수 
			party[i] = new int[pn];
			// 처음에 파티에 온사람 
			party[i][0] = Integer.parseInt(st.nextToken());
			// 그 다음에 파티에 온사람
			for (int p = 1; p < pn; p++) {
				party[i][p] = Integer.parseInt(st.nextToken());
				//파티에 온 사람들은 방문처리를 한다. 
				visited[party[i][p - 1]][party[i][p]] = visited[party[i][p]][party[i][p - 1]] = true;
			}
			// 파티를 즐기자 지민의 진실에 대해서 알고있는 사람을 추출해보자!!!!
		}
		for(int i =1; i<=N;i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		//먼저 파티에 온 사람들 중에서 지민이의 거짓말을 알고 있는 사람을 추출 하여
		//isTrue에 true / false 처리를 한다. 
		for (int i = 1; i <= N; i++) {
			if (isTrue[i]) {
				enjoyPeople(i);
			}
		}
		
		System.out.println(Arrays.toString(isTrue));
		//지민이에 대한 진실을 알고있는 사람들을 처리했으니 각 파티에  지민이의 진실을 모르는 사람들은 카운팅해준다. 
		for(int i=0; i<M; i++) {
			if(!isTrue[party[i][0]]) {
				ans++;
			}
		}
		System.out.println(ans);

	}

	private static void enjoyPeople(int n) {
		for (int i = 1; i <= N; i++) {
			if(visited[n][i] && !isTrue[i]) {
				isTrue[i] = true;
				enjoyPeople(i);
			}
		}

	}
}
