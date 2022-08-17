package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> list = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) >= (Math.abs(o2))) {
					if (Math.abs(o1) > (Math.abs(o2)))
						return 1;
					else
						return o1 > o2 ? 1 : -1;
				} else if (Math.abs(o2) > (Math.abs(o1)))
					return -1;
				return 0;
			}
		});

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp != 0) {
				list.add(temp);
			} else if (temp == 0) {
				if (list.size() == 0)
					System.out.println("0");
				else {
					System.out.println(list.peek());
					list.poll();

				}
			}
		}

	}

}
