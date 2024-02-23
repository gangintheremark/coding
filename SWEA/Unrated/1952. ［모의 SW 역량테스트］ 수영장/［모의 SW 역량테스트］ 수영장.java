import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int result;
	static int[] year, price = new int[4];

	public static void dfs(int m, int sum) {
		if (m > 12) {
			result = Math.min(result, sum);
			return;
		}
		dfs(m + 1, sum + price[0] * year[m]);
		dfs(m + 1, sum + price[1]);
		dfs(m + 3, sum + price[2]);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			year = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				price[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				year[i] = Integer.parseInt(st.nextToken());
			}

			result = price[3];
			dfs(1, 0);

			sb.append('#').append(t).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
}