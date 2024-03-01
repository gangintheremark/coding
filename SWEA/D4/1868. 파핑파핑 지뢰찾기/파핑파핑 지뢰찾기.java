import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, result;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void checkBomb(int x, int y) {
		boolean flag = false;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == -2) {
				// 지뢰가 주변에 하나라도 있다면 1저장
				board[x][y] = 1;
				return;

			}
		}
		board[x][y] = 0;
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 8; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
					// 지뢰가 주변에 하나라도 있다면 1저장
					visited[nx][ny] = true;

					if (board[nx][ny] == 0)
						q.add(new int[] { nx, ny });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());

			board = new int[n][n];
			visited = new boolean[n][n];

			/*
			 * 지뢰는 -2 , 지뢰가 없는 칸 -1 지뢰가 하나라도 있는 칸 1. 지뢰가 하나라도 없는 칸 0.
			 */

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					if (str.charAt(j) == '*')
						board[i][j] = -2;
					else
						board[i][j] = -1;
				}
			}



			// 좌표들의 주변 지뢰 먼저 찾아주기
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (board[i][j] == -1)
						checkBomb(i, j);
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 0 && !visited[i][j]) {
						bfs(i, j);
						result++;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 1 && !visited[i][j]) {
						result++;
					}
				}
			}

			sb.append('#').append(t).append(' ').append(result).append('\n');
			result = 0;
		}
		System.out.println(sb);
	}
}