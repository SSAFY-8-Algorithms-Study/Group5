package day0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2805 {
	/*
	 * 전략: pq정렬하고 max값 구하고/ex) 20, 17, 15, 10 / 최대 높이가 걸리는 구간을 찾는다 / 3*1 + 2*2 + 5*3
	 */
	static int N, M, max, getTree = 0;
	static PriorityQueue<Point> q = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			q.add(new Point(Integer.parseInt(st.nextToken())));
		}
		Point n = q.poll();
		// 나무의 개수가 1개일 경우
		if (q.isEmpty()) {
			max = n.tree - M;
			System.out.println(max);
			return;
		}
		int cnt = 1;
		while (true) {
			Point n2 = q.poll();
			getTree += (n.tree - n2.tree) * cnt;
			if (getTree >= M) {
				max = n2.tree;
				for (int i = 0; i < n.tree - n2.tree; i++) {
					if (getTree - cnt >= M) {
						getTree -= cnt;
						max++;
					} else
						break;
				}
				break;
			}

			if (q.isEmpty()) {
				max = n2.tree;
				while (true) {
					getTree += cnt+1;
					max--;
//					System.out.println(getTree);
//					System.out.println(max);
//					System.out.println();
					if (getTree >= M) {
						break;
					}
				}
				break;
			}
			n = n2;
			cnt++;
		}
		System.out.println(max);
	}

	static class Point implements Comparable<Point> {
		int tree;

		@Override
		public int compareTo(Point o) {
			return o.tree - this.tree;
		}

		public Point(int tree) {
			this.tree = tree;
		}

	}
}
