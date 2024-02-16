import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');
			int nx = 0, ny = 0, d = -1;
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			char[][] board = new char[H][W];

			/* d=1(^) d=2(v) d=3(<) d=4(>) */
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					board[i][j] = str.charAt(j);
					if (d == -1) {
						if (board[i][j] == '^') {
							nx = i;
							ny = j;
							d = 0;
						} else if (board[i][j] == 'v') {
							nx = i;
							ny = j;
							d = 1;
						} else if (board[i][j] == '<') {
							nx = i;
							ny = j;
							d = 2;
						} else if (board[i][j] == '>') {
							nx = i;
							ny = j;
							d = 3;
						}
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();

			for (char c : str.toCharArray()) {
				int tmpX = nx, tmpY = ny;
				switch (c) {
				case 'U':
					d = 0;
					tmpX += dx[d];
					tmpY += dy[d];
					board[nx][ny] = '^';
					if (tmpX < 0 || tmpX > H || tmpY < 0 || tmpY > W)
						break;
					if (board[tmpX][tmpY] == '.') {
						board[tmpX][tmpY] = '^';
						board[nx][ny] = '.';
						nx = tmpX;
						ny = tmpY;
					}
					break;
				case 'D':
					d = 1;
					tmpX += dx[d];
					tmpY += dy[d];
					board[nx][ny] = 'v';
					if (tmpX < 0 || tmpX >= H || tmpY < 0 || tmpY >= W)
						break;
					if (board[tmpX][tmpY] == '.') {
						board[tmpX][tmpY] = 'v';
						board[nx][ny] = '.';
						nx = tmpX;
						ny = tmpY;
					}
					break;
				case 'L':
					d = 2;
					tmpX += dx[d];
					tmpY += dy[d];
					board[nx][ny] = '<';
					if (tmpX < 0 || tmpX >= H || tmpY < 0 || tmpY >= W)
						break;
					if (board[tmpX][tmpY] == '.') {
						board[tmpX][tmpY] = '<';
						board[nx][ny] = '.';
						nx = tmpX;
						ny = tmpY;
					}
					break;
				case 'R':
					d = 3;
					tmpX += dx[d];
					tmpY += dy[d];
					board[nx][ny] = '>';
					if (tmpX < 0 || tmpX >= H || tmpY < 0 || tmpY >= W)
						break;
					if (board[tmpX][tmpY] == '.') {
						board[tmpX][tmpY] = '>';
						board[nx][ny] = '.';
						nx = tmpX;
						ny = tmpY;
					}
					break;
				case 'S':
					// 해당 방향으로 포탄 발사
					while (true) {
						tmpX += dx[d];
						tmpY += dy[d];

						if (tmpX < 0 || tmpX >= H || tmpY < 0 || tmpY >= W || board[tmpX][tmpY] == '#')
							break;
						if (board[tmpX][tmpY] == '*') {
							board[tmpX][tmpY] = '.';
							break;
						}
					}
					break;
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					sb.append(board[i][j]);
				sb.append('\n');
			}

		}
		System.out.println(sb);
	}

}