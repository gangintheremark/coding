import java.util.*;
import java.io.*;

public class Main {

	static int[] dp;

	public static int fibo(int n) {
		if (dp[n] > 0)
			return dp[n];
		if (n < 2)
			return dp[n] = n;
		else
			return dp[n] = fibo(n - 1) + fibo(n - 2);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];

		fibo(n);

		System.out.println(fibo(n));
	}
}