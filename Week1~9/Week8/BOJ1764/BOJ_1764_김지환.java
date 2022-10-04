package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

// 듣도 못한 사람의 수 N 
// 보도 못한 사람의 수 M이 주어진다.
public class BOJ_1764_김지환 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine());
		
		int N =  Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String,Integer> people = new HashMap<>();
		List<String> answer = new ArrayList<>();
		
		for(int i=0; i<N+M; i++) {
			int count = 0;
			String person = in.readLine();
			if(people.containsKey(person)) {
				count++;
			}
			people.put(person, count);
		}
		for(String key : people.keySet()) {
			Integer value = people.get(key);
			
			if(value >= 1) {
				answer.add(key);
			}
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for(String s : answer) {
			System.out.println(s);
		}
	}

}
