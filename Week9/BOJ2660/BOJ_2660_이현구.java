package day0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2660 {
	static int N, num = 0, min = Integer.MAX_VALUE;
	static ArrayList<Integer>[] arr;
	static int[] score_arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		score_arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (start == -1 && end == -1) {
				break;
			}
			arr[start].add(end);
			arr[end].add(start);
		}

		for (int i = 1; i <= N; i++) {
			int score = bfs(i) - 1;
			score_arr[i] = score;
			min = Math.min(min, score);
			//System.out.println("score: " + score);
		}
		for (int i = 1; i <= N; i++) {
			if (score_arr[i] == min) {
				num++;
			}
		}
		System.out.println(min + " " + num);
		for (int i = 1; i <= N; i++) {
			if (score_arr[i] == min) {
				System.out.print(i+" ");
			}
		}
	}

	private static int bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		boolean[] visit = new boolean[N + 1];
		visit[n] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int temp = q.poll();
				// System.out.println("cnt:" + cnt + "temp:" + temp);
				for (int i = 0; i < arr[temp].size(); i++) {
					int idx = arr[temp].get(i);
					if (!visit[idx]) {
						visit[idx] = true;
						q.add(idx);
					}

				}
			}
			cnt++;
		}

		return cnt;
	}
}
