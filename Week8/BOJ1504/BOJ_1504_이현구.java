package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {
	static int N, E, v1, v2;
	static long min, ans1 = 0, ans2 = 0;
	static int[] dis;
	static boolean[] visit;
	static ArrayList<Point>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		dis = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Point(b, c));
			list[b].add(new Point(a, c));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		// 2가지 경우로 다익스트라 돌리기
		ans1 += bfs(1, v1) + bfs(v1, v2) + bfs(v2, N);
		ans2 += bfs(1, v2) + bfs(v2, v1) + bfs(v1, N);
		// System.out.println(ans1+" "+bfs(1, v1)+" "+bfs(v1, v2)+" "+bfs(v2, N));
		// System.out.println(ans2+" "+bfs(1, v2)+" "+bfs(v2, v1)+" "+bfs(v1, N));

		min = Math.min(ans1, ans2);
		if (min >= Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(min);
	}

	private static long bfs(int x, int y) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.add(new Point(x, 0));
		Arrays.fill(dis, Integer.MAX_VALUE);
		visit = new boolean[N + 1];
		dis[x] = 0;
		while (!q.isEmpty()) {
			Point n = q.poll();
			int idx = n.node;
			int w = n.weight;
			if (w > dis[idx] || visit[idx] == true) {
				continue;
			}

			visit[idx] = true;
			for (int i = 0; i < list[idx].size(); i++) {
				Point p = list[idx].get(i);
				if (w + p.weight < dis[p.node]) {
					dis[p.node] = w + p.weight;
					q.add(new Point(p.node, dis[p.node]));
				}
			}
		}
		return dis[y];
	}

	static class Point implements Comparable<Point> {
		int node;
		int weight;

		public Point(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return this.weight - o.weight;
		}
	}
}
