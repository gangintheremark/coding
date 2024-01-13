import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int[][] board = new int[9][9];
        for (int t = 1; t <= T; t++) {
            int ans = 1;
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    board[i][j] = s.nextInt();

            for (int i = 0; i < 9; i++) {
                int rsum = 0;
                int csum = 0;
                for (int j = 0; j < 9; j++) {
                    rsum += board[i][j];
                    csum += board[j][i];
                }
                if (rsum != 45 || csum != 45) {
                    ans = 0;
                    break;
                }
            }
            if (ans == 0) {
                System.out.println("#" + t + " 0");
                continue;
            }

            for (int i = 0; i < 9; i+=3) {
                for (int j = 0; j < 9; j+=3) {
                    int sum = 0;
                    for (int x = 0; x < 3; x++)
                        for (int y = 0; y < 3; y++)
                            sum += board[i+x][j+y];
                    if (sum != 45) {
                        ans = 0;
                        break;
                    }
                }
                if (ans == 0) break;
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}