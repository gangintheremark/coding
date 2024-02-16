import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			// k층 n호에는 몇명이 살고 있는지

			int[][] dp = new int[k+1][n + 1];

			for (int i = 1; i <= n; i++) {
				dp[0][i] = i;
			}
			// 1, 3
			// 1층 3호에는 0층 1호~3호 까지 전부

			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
			System.out.println(dp[k][n]);
		}
	}

}
