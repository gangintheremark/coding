import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] board;
    static long[][] dp;
    static int[] distX = { 1, 0};
    static int[] distY = { 0, 1};
    static int count = 0;

    public long solution(int x, int y) {
        // 도착한 경우
        if (x == N-1 && y == N-1) {
            return 1;
        }

        if(dp[x][y] == -1) {
            dp[x][y] = 0;
            for(int i=0;i<2;i++) {
                int dx = x + distX[i] * board[x][y];
                int dy = y + distY[i] * board[x][y];

                if(dx < N && dy < N) {
                    dp[x][y] += solution(dx, dy);
                }
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Main M = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new long[N][N];

        for(long[] col : dp) {
            Arrays.fill(col, -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
         * 시작은 0,0 칸. 도착은 N-1,N-1 칸
         */
        M.solution(0, 0);
        System.out.println(dp[0][0]);
    }
}