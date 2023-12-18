import java.util.Scanner;

public class Main {

    static int[][][] dxdy = {
            {{0, 0}, {0, 1}, {1, 0}},
            {{0, 0}, {0, 1}, {1, 1}},
            {{0, 0}, {1, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {1, -1}}
    };
    static int H, W, result, count;
    static int[][] board;

    public static boolean check(int x, int y, int type, int tmp) {
        boolean flag = true;
        for (int i = 0; i < 3; i++) {
            int nx = x + dxdy[type][i][0];
            int ny = y + dxdy[type][i][1];

            if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
                flag = false;
            } else {
                board[nx][ny] += tmp;
                if (board[nx][ny] > 1)
                    flag = false;
            }
        }
        return flag;
    }

    public static int solution(int L) {
        if (L == count / 3) {
            result++;
        } else {

            int x = -1, y = -1;
            for (int i = 0; i < H && x == -1; i++) {
                for (int j = 0; j < W && y == -1; j++) {
                    if (board[i][j] == 0) {
                        x = i;
                        y = j;
                    }
                }
            }

            for (int type = 0; type < 4; type++) {
                if (check(x, y, type, 1)) {
                    solution(L + 1);
                }
                check(x, y, type, -1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int C = s.nextInt();

        for (int t = 0; t < C; t++) {
            H = s.nextInt();
            W = s.nextInt();

            board = new int[H][W];
            count = 0;
            result = 0;

            for (int i = 0; i < H; i++) {
                String tmp = s.next();
                int j = 0;
                for (char c : tmp.toCharArray()) {
                    if (c == '#') {
                        board[i][j++] = 1;
                    } else {
                        board[i][j++] = 0;
                        count++;
                    }
                }
            }

            if (count % 3 != 0) {
                System.out.println(0);
            } else {
                System.out.println(solution(0));
            }
        }
    }
}