import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11286_김아린 {
	static PriorityQueue<Integer> minHeap;
	static PriorityQueue<Integer> maxHeap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		minHeap = new PriorityQueue<>(); //최소힙 -> 양수 저장
		maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //최대힙 -> 음수 저장 
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x != 0) { //배열에 x라는 값 추가
				if(x > 0) { //양수
					minHeap.add(x);
				}else { //음수
					maxHeap.add(x);
				}
			}else { //배열에서 절댓값이 가장 작은 값을 출력
				if(minHeap.isEmpty() && maxHeap.isEmpty()) { //배열이 비어 있는 경우
					sb.append(0 + "\n");
				}else { //안비어 있는 경우
					if(minHeap.isEmpty() && !maxHeap.isEmpty()) {
						sb.append(maxHeap.poll() + "\n");
					}else if(maxHeap.isEmpty() && !minHeap.isEmpty()) {
						sb.append(minHeap.poll() + "\n");
					}else {
						int plusMin = minHeap.peek();
						int minusMin = Math.abs(maxHeap.peek());
						
						if(plusMin < minusMin) {
							sb.append(minHeap.poll() + "\n");
						}else if(minusMin < plusMin) {
							sb.append(maxHeap.poll() + "\n");
						}else if(minusMin == plusMin){ //같은 경우, 가장 작은 수를 출력
							sb.append(maxHeap.poll() + "\n");
						}
					}
				}
			}
		}
		
		System.out.println(sb);
	}

}
