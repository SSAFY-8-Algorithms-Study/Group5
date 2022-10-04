package day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

class BOJ_1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// Arraylist - contains() 시간 복잡도 O(n)
		// HashSet   - contains() 시간 복잡도 O(1)
		HashSet<String> hear = new HashSet<>();
		ArrayList<String> nothearlook = new ArrayList<>();

		for (int i = 0; i < N; i++)
			hear.add(br.readLine());

		for (int i = 0; i < M; i++) {
			String line = br.readLine();
			if (hear.contains(line)) 
				nothearlook.add(line);
		}

		System.out.println(nothearlook.size());
		Collections.sort(nothearlook);
		for (String s : nothearlook)
			System.out.println(s);

	}
}
