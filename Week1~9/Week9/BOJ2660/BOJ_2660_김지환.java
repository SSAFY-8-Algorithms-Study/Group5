package day0925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 회장뽑기 
 * 월드컵 축구의 응원을 위한 모임에서 회장을 선출하려고 한다.
 * 이 모임은 만들어진지 얼마 되지 않았기 떄문에 회원 사이에 서로 모르는 살마도 있지만, => 단방향 그래프 
 * 몇 사람??????을 통하면 모두가 서로 알 수 있음 
 *  예를 들어 어느 회원이 다른 모든 회원과 친구라면 
 *  이 회원의 점수는 1점이다. 즉 가중치가 1
 *  어느 회원의 점수(가중치) 2라면
 *  다른 회원이 친구이나거 친구의 친구임을 말함
 *  또한 어느 회원의 점수가 3점 가중치가 아니라 깊이라고 설명을 해야되나???
 *  회장은 회원들 중에서 점수가 가장 작은 살마이된다. 그 그래프에서의 루트를 말해야되나/ 
 *  
 * */
public class BOJ_2660_김지환 {
	
	//모든 사람들을 담기 위한 배열 
	static int[][] people;
	static int INF = 9999999;
	//회장 후보를 담기 위한 리스트 
	static List<Integer> chairman;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		
		people = new int[N+1][N+1];
		int[][] dist = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i!=j)
					people[i][j] = INF;
			}
		}
		
		while(true) {
			
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(from == -1 && to == -1)
				break;
			people[from][to] = people[to][from] = 1;
		}
		//end input 
		
		//플로이드 워셜 알고리즘 
		//외부 바깥 k가 중간노드를 결정하기 위한 loop
		//i-j 와 i+k, k+1를 비교하여 모든 경로를 도달하면서 최단거리를 갱신해줌. 
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
						people[i][j]= Math.min(people[i][j], people[i][k]+people[k][j]);
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		int finalScore = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			int midscore = Integer.MIN_VALUE;
			for(int j=1; j<=N; j++) {
				midscore = Math.max(midscore, people[i][j]);
			}
			finalScore = Math.min(finalScore, midscore);
		}
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			int max = Integer.MIN_VALUE;
			for(int j=1;j<=N; j++) {
				max = Math.max(max, people[i][j]);
			}
			if(max == finalScore) {
				cnt++;
				sb.append(i).append(" ");
			}
		}
		System.out.println(finalScore+" "+cnt);
		System.out.println(sb);
	}
	

}
