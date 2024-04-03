import java.util.*;
import java.io.*;

public class Main {

	static int r, c, t;
	static int[][][] board;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken()); // t초가 지난 후 남아있는 미세먼지 양

		board = new int[r][c][t + 1];
		List<int[]> airCleaner = new ArrayList<int[]>();

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				board[i][j][0] = Integer.parseInt(st.nextToken());
				if (board[i][j][0] == -1)
					airCleaner.add(new int[] { i, j });
			}
		}

		for (int time = 1; time <= t; time++) {

			// 미세먼지 확산
			for (int i = 0; i < r; i++)
				for (int j = 0; j < c; j++) {
					if (board[i][j][time - 1] != 0 && board[i][j][time - 1] != -1) {
						int amount = board[i][j][time - 1];
						int count = 0;
						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if (nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny][0] != -1) {
								count++; // 확산
								board[nx][ny][time] += amount / 5;
							}
						}

						board[i][j][time] += amount - amount / 5 * count;
					}
				}

			// 상단 공기청정기 작동 (x - 1, y)
			int x = airCleaner.get(0)[0] - 1;
			int y = 0;

			while (x > 0) {
				// x가 0이 될 때 까지
				board[x][y][time] = board[x - 1][y][time];
				x--;
			}

			while (y + 1 < c) {
				// y가 c가 될 때 까지
				board[x][y][time] = board[x][y + 1][time];
				y++;
			}

			while (x < airCleaner.get(0)[0]) {
				// x가 공기청정기 x좌표가 될 때 까지
				board[x][y][time] = board[x + 1][y][time];
				x++;
			}
			while (y > 0) {
				board[x][y][time] = board[x][y - 1][time];
				y--;
			}

			// 하단 공기청정기 작동 (x + 1, y)
			x = airCleaner.get(1)[0] + 1;
			y = 0;

			while (x + 1 < r) {
				board[x][y][time] = board[x + 1][y][time];
				x++;
			}

			while (y + 1 < c) {
				board[x][y][time] = board[x][y + 1][time];
				y++;
			}

			while (x > airCleaner.get(1)[0]) {
				board[x][y][time] = board[x - 1][y][time];
				x--;
			}

			while (y > 0) {
				board[x][y][time] = board[x][y - 1][time];
				y--;
			}

		}

		int result = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j][t] != 0 && board[i][j][0] != -1) {
					result += board[i][j][t];
				}
			}
		}
		System.out.println(result);

	}
}