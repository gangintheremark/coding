import java.io.*;
import java.util.*;

public class Main {

	static int n, m, result = Integer.MAX_VALUE;
	static int[][] board;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Node {
		int x;
		int y;
		int dist;

		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

	}

	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Main.Node>();
		q.offer(new Node(x, y, 0));
		board[x][y] = 0;
		while (!q.isEmpty()) {
			Node now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx > 0 && nx <= n && ny > 0 && ny <= m && board[nx][ny] == -1) {
					board[nx][ny] = now.dist + 1;
					q.offer(new Node(nx, ny, now.dist + 1));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n + 1][m + 1];

		int startX = 0, startY = 0;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) board[i][j] = -1;
				if (tmp == 2) {
					startX = i;
					startY = j;
				}
			}
		}
		bfs(startX, startY);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sb.append(board[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
