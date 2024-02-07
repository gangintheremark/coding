import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, max = 0, room = -1;
	static int[][] board;
	static boolean[] visited;
	static int check;
	static int[] distX = { 1, -1, 0, 0 };
	static int[] distY = { 0, 0, 1, -1 };

	public static void dfs(int x, int y, int count, int start) {
		// 기저사례 ) 갈 곳이 없을 떄
		check = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + distX[i];
			int ny = y + distY[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {

				if (board[nx][ny] == board[x][y] + 1 && !visited[board[nx][ny]]) {
					visited[board[nx][ny]] = true;
					dfs(nx, ny, count + 1, start);
					visited[board[nx][ny]] = false;
				} else {
					check++;
				}
			} else
				check++;
		}
		if (check == 4 || count == N*N) {
			if (max == count) {
				room = Math.min(room, start);
			} else if (max < count) {
				max = count;
				room = start;
			}
			return;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			visited = new boolean[N * N + 1];
			max = 0;
			room = 1;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 1, board[i][j]);
				}
			}
			
			sb.append('#').append(t).append(' ').append(room).append(' ').append(max).append("\n");

		}
		System.out.println(sb);
	}
}