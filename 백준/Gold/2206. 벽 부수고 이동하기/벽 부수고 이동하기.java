import java.io.*;
import java.util.*;

public class Main {

	static int n, m, result = Integer.MAX_VALUE;
	static int[][] board;
	static boolean[][][] visited;
	static boolean flag;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Node {
		int x;
		int y;
		int count;
		boolean flag;

		public Node(int x, int y, int count, boolean flag) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.flag = flag;
		}
	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<Main.Node>();
		q.offer(new Node(1, 1, 1, false));
		visited[1][1][0] = true;

		while (!q.isEmpty()) {
			Node now = q.poll();

			if (now.count > result)
				continue;
			if (now.x == n && now.y == m)
				result = Math.min(result, now.count);

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx > 0 && nx <= n && ny > 0 && ny <= m) {

					if (board[nx][ny] == 0) {
						if (now.flag && !visited[nx][ny][1]) {
							q.offer(new Node(nx, ny, now.count + 1, now.flag));
							visited[nx][ny][1] = true;
						} else if (!now.flag && !visited[nx][ny][0]) {
							q.offer(new Node(nx, ny, now.count + 1, now.flag));
							visited[nx][ny][0] = true;
						}
					} else {
						if (!now.flag && !visited[nx][ny][0]) {
							q.offer(new Node(nx, ny, now.count + 1, true));
							visited[nx][ny][1] = true;
						}
					}

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1][2];

		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= m; j++)
				board[i][j] = str.charAt(j - 1) - '0';

		}

		// 0은 이동 , 1은 벽 . 한 번 벽을 깰 수 있다.
		bfs();
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
}
