import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, m, r;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int point = (n > m ? m : n) / 2;

		for (int i = 0; i < r; i++) {
			rotate(point);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void rotate(int point) {
		for (int t = 0; t < point; t++) {
			int x = t;
			int y = t;
			int d = 0;

			int tmp = map[x][y];

			while (d < 4) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= t && ny >= t && nx < n - t && ny < m - t) {

					map[x][y] = map[nx][ny];
					x = nx;
					y = ny;
				} else {
					d++;
				}
			}
			map[t + 1][t] = tmp;
		}
	}
}