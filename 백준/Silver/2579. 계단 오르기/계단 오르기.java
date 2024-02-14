import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		long[] dp = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = arr[1];
		if (N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		/*
		 * 연속으로 세 개의 계단을 밟으면 안되므로 max(두 칸 전 계단 , (세 칸 전 계단 + 한 칸 전 계단))
		 */
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
		}

		System.out.println(dp[N]);

	}
}