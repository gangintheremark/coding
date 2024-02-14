import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] dp;

	public static long fibo(int n) {
		if (dp[n] > 0)
			return dp[n];
		if (n < 2)
			return dp[n] = n;
		else
			return dp[n] = fibo(n - 1) + fibo(n - 2);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		dp = new long[n + 1];
		System.out.println(fibo(n));

	}
}