import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] board;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static List<int[]> rainList = new ArrayList<int[]>();
	static Point D, S;
	static boolean[][] visited;

	static class Node {
		int x;
		int y;
		int count;

		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	static boolean Valid(int nx, int ny) {
		if (nx >= 0 && nx < R && ny >= 0 && ny < C)
			return true;
		return false;
	}

	public static int bfs() {
		Queue<Node> q = new LinkedList<>();
		Queue<int[]> rq = new LinkedList<>();

		q.offer(new Node(S.x, S.y, 0));
		visited[S.x][S.y] = true;

		for (int i = 0; i < rainList.size(); i++) {
			rq.offer(new int[] { rainList.get(i)[0], rainList.get(i)[1] });
		}

		while (!rq.isEmpty() || !q.isEmpty()) {
			// 비 먼저 확장 후 이동하기

			int tmp = rq.size();
			while (tmp > 0) {
				int[] rain = rq.poll();

				for (int i = 0; i < 4; i++) {
					int nx = rain[0] + dx[i];
					int ny = rain[1] + dy[i];

					if (Valid(nx, ny) && board[nx][ny] == '.') {
						board[nx][ny] = '*';
						rq.offer(new int[] { nx, ny });
					}
				}
				tmp--;
			}

			tmp = q.size();

			while (tmp > 0) {
				Node now = q.poll();

				if (now.x == D.x && now.y == D.y)
					return now.count;

				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];

					if (Valid(nx, ny) && (board[nx][ny] == '.' || board[nx][ny] == 'D') && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Node(nx, ny, now.count + 1));
					}
				}
				tmp--;
			}
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);

				if (board[i][j] == '*')
					rainList.add(new int[] { i, j });
				else if (board[i][j] == 'D')
					D = new Point(i, j);
				else if (board[i][j] == 'S')
					S = new Point(i, j);
			}
		}
		int result = bfs();
		System.out.println(result != 0 ? result : "KAKTUS");

	}
}
