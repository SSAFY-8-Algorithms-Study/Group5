package silver;

import java.util.Scanner;

public class Main_20363 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		// 햇빛을 준 수량
		int sun = 0;
		// 물을 준 수량
		int water = 0;
		
		int totalCount = 0;
		
		//온기
		int temperature = 0;
		
		//수분
		int waterLevel = 0;
		
		while(true) {
			//밭아야 하는 온기가 수분보다 크다면
			if(X >= Y) {
				while(true) {
					if(temperature >= X) {
						break;
					}
					
					sun++;
					temperature++;
					totalCount++;
//					System.out.println("temperature: " + temperature);
					
					if(sun == 10) {
						if(waterLevel > 0) {
							waterLevel--;
							sun=0;
						}
					}
				}
				
				while(true) {
					if(waterLevel >= Y) {
						break;
					}
					water++;
					waterLevel++;
					totalCount++;
//					System.out.println("waterLevel: " + waterLevel);
					
					if(water == 10) {
						if(temperature > 0) {
							temperature--;
							water=0;
						}
					}
				}
			} 
			else {
				while(true) {
					if(waterLevel >= Y) {
						break;
					}
					water++;
					waterLevel++;
					totalCount++;
//					System.out.println("waterLevel: " + waterLevel);
					
					if(water == 10) {
						if(temperature > 0) {
							temperature--;
							water=0;
						}
					}
				}
				
				while(true) {
					if(temperature >= X) {
						break;
					}
					
					sun++;
					temperature++;
					totalCount++;
//					System.out.println("temperature: " + temperature);
					
					if(sun == 10) {
						if(waterLevel > 0) {
							waterLevel--;
							sun=0;
						}
					}
				}
			}
			
//			System.out.println("temperature: " + temperature);
//			System.out.println("waterLevel: " + waterLevel);
			
			if(temperature == X && waterLevel == Y) {
				break;
			}
		}
		
		System.out.println(totalCount);
	}
}
