import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, t;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 }; // 하 우 상 좌
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		t = Integer.parseInt(br.readLine());
		int tx = 0;
		int ty = 0;
		map = new int[n][n];

		makeMap();

		for (int i = 0; i < n; i++) {
			for(int j = 0; j < n ; j++) {
				sb.append(map[i][j]).append(' ');
				if(map[i][j] == t) {
					tx = i;
					ty = j;
				}
			}
			sb.append('\n');
		}
		sb.append(tx + 1).append(' ').append(ty + 1);
		System.out.println(sb);
	}

	public static void makeMap() {
		int x = 0;
		int y = 0;
		int count = n * n;
		int d = 0; // 방향

		while (true) {
			if (count == 0)
				break;
			map[x][y] = count--;
			int nx = x + dx[d];
			int ny = y + dy[d];
			int nd = setDirection(d, nx, ny);
			// 방향이 바뀌면
			if (nd != d) {
				x += dx[nd];
				y += dy[nd];
				d = nd;
			} else {
				x = nx;
				y = ny;
			}
		}
	}

	public static int setDirection(int d, int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
			d = (d + 1) % 4;
		} else if (map[nx][ny] != 0) {
			d = (d + 1) % 4;
		}
		return d;
	}
}
