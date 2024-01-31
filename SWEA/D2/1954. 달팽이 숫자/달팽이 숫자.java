import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[][] board;
	static int N;
	static int distX[] = { 0, 1, 0, -1 };
	static int distY[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			board = new int[N][N];
			int x = 0, y = 0, d = 0;
			for (int i = 1; i <= N * N; i++) {
				board[x][y] = i;
				x = x + distX[d];
				y = y + distY[d];

				if (x + distX[d] < 0 || y + distY[d] >= N || x + distX[d] >= N || y + distY[d] < 0
						|| board[x + distX[d]][y + distY[d]] != 0) {
					d = (d + 1) % 4;
				}
			
			}
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(board[i][j]+ " ");
				}
				System.out.println();
			}
		}
	}
}
