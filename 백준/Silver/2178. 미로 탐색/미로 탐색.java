import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tmpX = tmp[0], tmpY = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nx = tmpX + dx[i];
				int ny = tmpY + dy[i];

				if (nx > 0 && nx <= N && ny > 0 && ny <= M && board[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
					board[nx][ny] = board[tmpX][tmpY] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++)
				board[i][j] = str.charAt(j - 1) - '0';
		}
		
		bfs(1,1);
		System.out.println(board[N][M]);
	}
}
