import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 말의 움직임 => 두 칸 앞으로 후, 90도 방향으로 꺾어 L 모양이 되도록
 */
public class Main {
	static int n, start;
	static int[][] graph;
	static long result = Long.MAX_VALUE;
	static boolean[] visited;

	public static void dfs(int count, long cost, int now) {
		if (count == n) {
			if (graph[now][start] != 0)
				result = Math.min(result, cost + graph[now][start]);
			return;
		}

		for (int i = 1; i < n; i++) {
			if (!visited[i] && graph[now][i] != 0) {
				visited[i] = true;
				dfs(count + 1, cost + graph[now][i], i);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		/*
		 * 1번부터 N번까지 도시
		 */
		n = Integer.parseInt(br.readLine());

		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++)
				graph[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			visited[i] = true;
			start = i;
			dfs(1, 0, i);
			visited[i] = false;
		}

		System.out.println(result);
	}
}