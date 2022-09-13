package gold;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_2310 {
	// 방의 갯수
	static int N;

	static Room[] roomList;
	static boolean[] isVisited;
	
	static boolean result = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			N = sc.nextInt();

			if (N == 0) {
				break;
			}

			// 방 번호를 1부터 시작하기 위해 1을 더해줌
			roomList = new Room[N + 1];
			isVisited = new boolean[N + 1];
			result = false;

			// Room 넣기
			for (int i = 1; i < N + 1; i++) {
				char roomStatus = sc.next().charAt(0);
				int money = sc.nextInt();

				ArrayList<Integer> nextRoomList = new ArrayList();

				while (true) {
					int roomNumber = sc.nextInt();

					if (roomNumber == 0) {
						break;
					}

					nextRoomList.add(roomNumber);
				}

				Room nextRoom = new Room(i, roomStatus, money, nextRoomList);
				roomList[i] = nextRoom;
			}
			// Input End
			
//			for (int i = 0; i < roomList.length; i++) {
//				System.out.println(roomList[i]);
//			}
//			System.out.println("-----------------------------");

//			bfs();
			dfs(1, 0);
			
			if(result) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

	}

	static void dfs(int roomNumber, int currentMoney) {
		Room currentRoom = roomList[roomNumber];
		
		// 트롤을 만났다!
		if (currentRoom.roomStatus == 'T') {
			if (currentRoom.money > currentMoney) {
				return;
			} else {
				// 통행료를 내자
				currentMoney -= currentRoom.money;
			}
		}
		
		// 기저 조건
		if (roomNumber == N) {
			result = true;
			return;
		}
//		System.out.println(roomNumber);

		isVisited[roomNumber] = true;
		
		//레프리콘을 만났다!!
		if (currentRoom.roomStatus == 'L') {
			if (currentRoom.money > currentMoney) {
				currentMoney = currentRoom.money;
			}
		}
		
		for(Integer nextRoom : currentRoom.nextRoomList) {
			if(isVisited[nextRoom]) {
				continue;
			}
			
			dfs(nextRoom, currentMoney);
		}
	}

	static class Room {
		int roomNumber;
		char roomStatus;
		int money;
		ArrayList<Integer> nextRoomList = new ArrayList();

		public Room(int roomNumber, char roomStatus, int money, ArrayList<Integer> nextRoomList) {
			this.roomNumber = roomNumber;
			this.roomStatus = roomStatus;
			this.money = money;
			this.nextRoomList = nextRoomList;
		}

		@Override
		public String toString() {
			return "Room [roomNumber=" + roomNumber + ", roomStatus=" + roomStatus + ", money=" + money
					+ ", nextRoomList=" + nextRoomList + "]";
		}
	}
}
