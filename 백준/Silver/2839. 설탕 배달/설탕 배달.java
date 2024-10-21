import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];

		if (n >= 3)
			dp[3] = 1;
		if (n >= 5)
			dp[5] = 1;

		for (int i = 6; i <= n; i++) {
			if (i % 5 == 0) {
				dp[i] = dp[i - 5] + 1;
			} else if (i % 3 == 0) {
				dp[i] = dp[i - 3] + 1;
			} else if (dp[i - 5] != 0 && dp[i - 3] != 0) {
				dp[i] = Math.min(dp[i - 5], i - 3) + 1;
			}
		}

		System.out.println(dp[n] == 0 ? -1 : dp[n]);

	}
}