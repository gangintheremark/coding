import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	private static int N, M, V;
	private static int[][] map;
	private static boolean[] visited;

	public static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(' ');

		for (int i = 1; i <= N; i++)
			if (!visited[i] && map[v][i] == 1)
				dfs(i);
	}

	public static void bfs(int v) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(v);
		visited[v] = true;
		sb.append(v).append(' ');

		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && map[tmp][i] == 1) {
					q.offer(i);
					visited[i] = true;
					sb.append(i).append(' ');
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = 1;
			map[b][a] = 1;
		}

		visited[V] = true;
		dfs(V);
		sb.append('\n');
		Arrays.fill(visited, false);
		bfs(V);

		System.out.println(sb);
	}
}
