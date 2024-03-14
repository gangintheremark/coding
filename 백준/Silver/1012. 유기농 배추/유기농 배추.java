import java.io.*;
import java.util.*;

public class Main {
	static int n, m, k, result;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] board;
	static List<int[]> points = new ArrayList<int[]>();
	static boolean[][] visited;

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			board = new int[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[y][x] = 1;
				points.add(new int[] { y, x });
			}

			for (int i = 0; i < points.size(); i++) {
				if (!visited[points.get(i)[0]][points.get(i)[1]]) {
					bfs(points.get(i)[0], points.get(i)[1]);
					result++;
				}
			}
			sb.append(result).append('\n');
			points.clear();
			result = 0;

		}
		System.out.println(sb);

	}
}
