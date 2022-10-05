import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int R, C, M, king, ans;
    static int[][] A, AA;
    static ArrayList<Shark> sharks = new ArrayList<>();

    static class Shark {
        int x, y, speed, state, size, num;

        public Shark(int x, int y, int speed, int state, int size, int num) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.state = state;
            this.size = size;
            this.num = num; // 상어 고유 번호
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[R+1][C+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Speed = Integer.parseInt(st.nextToken());
            int State = Integer.parseInt(st.nextToken());
            int Size = Integer.parseInt(st.nextToken());
            sharks.add(new Shark(X, Y, Speed, State, Size, i + 1));
            A[X][Y] = i + 1; // 상어 고유 번호
        }
    }

    static void removeShark(int num, int add) {
        for (int k = 0; k < sharks.size(); k++) {
            if (sharks.get(k).num == num) {
                if(add == 1){
                    ans += sharks.get(k).size;
                }
                sharks.remove(k);
                break;
            }
        }
    }


    static int getSize(int num) {
        for (int k = 0; k < sharks.size(); k++) {
            if (sharks.get(k).num == num) {
                return sharks.get(k).size;
            }
        }
        return -1;
    }

    static void fishing(int y) {
        for (int i = 1; i <= R; i++) {
            if(A[i][y] > 0) {
                for (int k = 0; k < sharks.size(); k++) {
                    removeShark(A[i][y], 1);
                    A[i][y] = 0;
                    return;
                }
            }
        }
    }

    static void moveSharks() {
        AA = new int[R+1][C+1];
        for (int k = 0; k < sharks.size(); k++) {
            Shark shark = sharks.get(k);
            int x = shark.x;
            int y = shark.y;
            int state = shark.state;
            int speed = shark.speed;
            while (speed != 0) {
                switch (state) {
                    case 1: // 위
                        if (x - speed > 0) {
                            x = x - speed;
                            speed = 0;
                        } else {
                            speed -= (x - 1);
                            x = 1;
                            state = 2;
                        }
                        break;
                    case 2: // 아래
                        if (x + speed <= R) {
                            x = x + speed;
                            speed = 0;
                        } else {
                            speed -= (R - x);
                            x = R;
                            state = 1;
                        }
                        break;
                    case 3: // 오른쪽
                        if (y + speed <= C) {
                            y = y + speed;
                            speed = 0;
                        } else {
                            speed -= (C - y);
                            y = C;
                            state = 4;
                        }
                        break;
                    case 4: // 왼쪽
                        if (y - speed > 0) {
                            y = y - speed;
                            speed = 0;
                        } else {
                            speed -= (y - 1);
                            y = 1;
                            state = 3;
                        }
                        break;
                }
            }
            shark.x = x;
            shark.y = y;
            shark.state = state;
            if (AA[x][y] == 0) {
                AA[x][y] = shark.num;
            } else {
                if (shark.size > getSize(AA[x][y])) {
                    removeShark(AA[x][y], 0);
                    AA[x][y] = shark.num;
                } else {
                    removeShark(shark.num, 0);
                }
                k--;
            }
        }
        A = AA;
    }

    static void pro() {
        king = 0;
        while(king + 1 <= C) {
            // 1. 낚시왕이 오른쪽으로 한 칸 이동한다.
            king++;
            // 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
            fishing(king);
            // 3. 상어가 이동한다.
            moveSharks();
        }
        System.out.println(ans);
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
