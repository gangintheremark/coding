import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] graph = new int[n + 1][n + 1];
		boolean[] visited = new boolean[101];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		Queue<Integer> q = new ArrayDeque<>();
		// 1번 사람이 소문을 올렸을 때,
		q.offer(1);
		visited[1] = true;
		int count = 0;
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 1; i <= n; i++) {
				if (!visited[i] && graph[now][i] == 1) {
					visited[i] = true;
					count++;
					q.offer(i);
				}
			}
		}
		System.out.println(count);

	}
}
