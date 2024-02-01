import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[][] board;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			max = 0;
			board = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++)
					board[i][j] = board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1]
							+ Integer.parseInt(st.nextToken());
			}

			for (int i = M; i <= N; i++)
				for (int j = M; j <= N; j++)
					max = Math.max(max, board[i][j] - board[i - M][j] - board[i][j - M] + board[i - M][j - M]);

			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);
	}

}