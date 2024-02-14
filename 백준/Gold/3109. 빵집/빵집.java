import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int[][] board;
	static boolean[][] checked;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static int count;
	static boolean flag;

	public static void dfs(int x, int y) {
		if (y == C - 1) {
			count++;
			flag = true;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!flag && nx >= 0 && nx < R && ny >= 0 && ny < C && board[nx][ny] == 0 && !checked[nx][ny]) {
				checked[nx][ny] = true;
				dfs(nx, ny);

			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		checked = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == '.') {
					board[i][j] = 0;
				} else {
					board[i][j] = 1;
					checked[i][j] = true;
				}
			}
		}

		/*
		 * 0 은 . 1은 x
		 */

		for (int i = 0; i < R; i++) {
			checked[i][0] = true;
			flag  = false;
			dfs(i, 0);
		}

		System.out.println(count);
	}
}
