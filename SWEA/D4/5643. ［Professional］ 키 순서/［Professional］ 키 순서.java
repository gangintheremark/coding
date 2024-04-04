import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, m, board[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; ++tc) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			board = new int[n + 1][n + 1];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			int answer = 0;
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					if (i == k)
						continue;
					for (int j = 1; j <= n; j++) {
						if (board[i][j] == 1)
							continue;
						board[i][j] = board[i][k] & board[k][j];
					}
				}
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					board[i][0] += board[i][j]; 
					board[0][j] += board[i][j]; 
				}
			}
			for (int k = 1; k <= n; k++) {
				if (board[k][0] + board[0][k] == n - 1)
					answer++;
			}
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		System.out.println(sb);
	}
}
