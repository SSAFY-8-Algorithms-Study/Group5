package com.ssafy.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2304_김지환 {

	static class storage implements Comparable<storage>{
		int low;
		int high;
		public storage(int low, int high) {
			this.low =low;
			this.high =high;
		}
		@Override
		public String toString() {
			return this.low+" "+this.high;
		}
		@Override
		public int compareTo(storage o) {
			//x축 기준으로 정렬하기 
			return this.low - o.low;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		List<storage> list = new ArrayList<>();
		int L = 0;
		int H = 0;
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			L = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			list.add(new storage(L,H));
		}
		//x축 기준으로 정렬 
		Collections.sort(list);
		int sum =0;
		int maxHeight_col = Integer.MIN_VALUE;
		int maxHeight_row = Integer.MIN_VALUE;
		int maxHeight = 0;
		int current_high = list.get(0).high;
		int current_low = list.get(0).low;
//		System.out.println(current_low+" "+current_high);
		//가장 큰 높이의 기둥 
		for(int i=0;i<list.size();i++) {
			if(maxHeight_col < list.get(i).high) {
				maxHeight_col = list.get(i).high;
				maxHeight_row = list.get(i).low;
				maxHeight = i;
			}
		}
		// 왼쪽 구간 
		//왼쪽구간에서는 가장 큰 높이의 다각형까지 점점 높이가 커지는 것만 구하면됨
		for(int i=1;i<list.size();i++) {
			if(current_low >= maxHeight_row) break;
			if(current_high > list.get(i).high) continue;
			sum+=current_high*(list.get(i).low-current_low);
			current_low = list.get(i).low;
			current_high = list.get(i).high;
		}
		current_low = list.get(list.size()-1).low;
		current_high = list.get(list.size()-1).high;
		//오른쪽구간에서는 가장 큰 높이서 부터 낮아지는 다각형만 구하고 
		for(int i=1;i<list.size();i++) {
//			sum+=current_high*(current_low-maxHeight_row);
//			if((current_low-maxHeight_row) >= (list.get(i).low - maxHeight_row))break;
//			current_high = list.get(i).high;
//			current_low = list.get(i).low;
// 			System.out.println(list.get(list.size()-1-i));
			//현재 높이에서 가장 큰 다각형의 높이까지 현재 높이보다 큰 높이가 있으면 
			if(current_high <= list.get(list.size()-1-i).high) {
				sum+=(current_low-list.get(list.size()-1-i).low)*current_high;
				current_low = list.get(list.size()-1-i).low;
				current_high = list.get(list.size()-1-i).high;
			}
		}
		sum+=maxHeight_col;
		System.out.println(sum);
		//그에 대한 면적을 구하면 됨 .
	}
	

}
