import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int R, C;
	static String result = "NO";
	static char[][] board;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][][][] visited;

	static class Node {
		int x;
		int y;
		int d;
		int memory;

		public Node(int x, int y, int d, int memory) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.memory = memory;
		}
	}

	// (0, -1) 시작
	public static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, 0, 3, 0));
		while (!q.isEmpty()) {
			Node now = q.poll();

			if (visited[now.x][now.y][now.d][now.memory])
				continue;

			visited[now.x][now.y][now.d][now.memory] = true;

			char c = board[now.x][now.y];

			if (c == '@') {
				result = "YES";
				break;
			} else if (c == '?') {
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					
					nx = nx == R ? 0 : nx;
					nx = nx == -1 ? R - 1 : nx;
					ny = ny == C ? 0 : ny;
					ny = ny == -1 ? C - 1 : ny;
					
					q.add(new Node(nx, ny, i, now.memory));
				}
				continue;
			} else if (c == '<')
				now.d = 2;
			else if (c == '>')
				now.d = 3;
			else if (c == '^')
				now.d = 0;
			else if (c == 'v')
				now.d = 1;
			else if (c == '_')
				now.d = now.memory == 0 ? 3 : 2;
			else if (c == '|')
				now.d = now.memory == 0 ? 1 : 0;
			else if (c - '0' >= 0 && c - '0' <= 9)
				now.memory = c - '0';
			else if (c == '+')
				now.memory = now.memory == 15 ? 0 : now.memory + 1;
			else if (c == '-')
				now.memory = now.memory == 0 ? 15 : now.memory - 1;

			now.x += dx[now.d];
			now.y += dy[now.d];

			now.x = now.x == R ? 0 : now.x;
			now.x = now.x < 0 ? R - 1 : now.x;
			now.y = now.y == C ? 0 : now.y;
			now.y = now.y < 0 ? C - 1 : now.y;

			q.add(now);
		}
	}

	public static void main(String[] args) throws IOException {
	//	System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			board = new char[R][C];
			visited = new boolean[R][C][4][16];

			// 상0 하1 좌2 우3
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++)
					board[i][j] = str.charAt(j);
			}

			/// (0,0) 부터시작
			bfs();
			
			sb.append('#').append(t).append(' ').append(result).append('\n');
			result = "NO";
		}
		System.out.println(sb);
	}
}