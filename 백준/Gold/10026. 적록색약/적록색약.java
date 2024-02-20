import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static char[][] board, board2;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visited, visited2;

	public static void dfs(int x, int y, char[][] board, char c, boolean[][] visited) {

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && board[nx][ny] == c) {
				visited[nx][ny] = true;
				dfs(nx, ny, board, c, visited);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		board2 = new char[N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				board[i][j] = c;
				board2[i][j] = (c == 'G') ? 'R' : c;
			}
		}
		int count = 0;
		int count2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, board, board[i][j], visited);
					count++;
				}
				if (!visited2[i][j]) {
					dfs(i, j, board2, board2[i][j], visited2);
					count2++;
				}
			}
		}
		System.out.println(count + " " + count2);
	}
}
