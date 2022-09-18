package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1764 {
	
	//듣도 못한 사람의 수
	static int N;
	
	//보도 못한 사람의 수
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<String> answerList = new ArrayList<>();
		
		String[] n_list = new String[N];
		String[] m_list = new String[M];
		
		for (int i = 0; i < N; i++) {
			n_list[i] = br.readLine();
		}
		
		for (int i = 0; i < M; i++) {
			m_list[i] = br.readLine();
		}
		
		Arrays.sort(n_list);
		
		for (int i = 0; i < m_list.length; i++) {
			int idx = Arrays.binarySearch(n_list, m_list[i]);
			
	        if(idx >= 0){
	        	answerList.add(m_list[i]);
	        }
		}
		
		Collections.sort(answerList);
		
		System.out.println(answerList.size());
		for(String str : answerList) {
			System.out.println(str);
		}
	}
}
