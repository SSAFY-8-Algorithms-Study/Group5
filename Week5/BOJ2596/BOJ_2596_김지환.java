package day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_2596_김지환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		HashMap<String, String> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		map.put("000000","A");
		map.put("001111","B");
		map.put("010011","C");
		map.put("011100","D");
		map.put("100110","E");
		map.put("101001","F");
		map.put("110101","G");
		map.put("111010","H");
		
		int Idx=0;
		for(int i=0; i<N; i++) {
			String str2 = str.substring(Idx,Idx+6);
			String result = map.get(str2);
			if(result == null) {
				for(String key : map.keySet()) {
					int cnt =0;
					char[] strs = str2.toCharArray();
					char[] keys = key.toCharArray();
					for(int j =0; j<keys.length; j++) {
						if(strs[j] != keys[j]) {
							cnt++;
						}
					}
					if(cnt == 1) {
						result = map.get(key);
						break;
					}
					
				}
			}
			if(result!=null) {
				sb.append(result);
			}else {
				System.out.println(i+1);
				return;
			}
			Idx+=6;
		}
		System.out.println(sb);
	}

}
