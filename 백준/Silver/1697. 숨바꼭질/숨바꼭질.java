import java.io.*;
import java.util.*;

public class Main {

	static int n, m, count;
	static int min = Integer.MAX_VALUE;
	static boolean visited[] = new boolean[100001];

	static void bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { start, 0 });
		while (!q.isEmpty()) {
			int[] now = q.poll();
			visited[now[0]] = true;

			if (now[0] == m) {
                min = Math.min(min, now[1]);
				continue;
			}

			int tmp = now[0] * 2;
			int tmp2 = now[0] + 1;
			int tmp3 = now[0] - 1;

			if (tmp >= 0 && tmp <= 100000 && !visited[tmp]) {
				q.offer(new int[] { tmp, now[1] + 1 });

			}
			if (tmp2 >= 0 && tmp2 <= 100000 && !visited[tmp2]) {
				q.offer(new int[] { tmp2, now[1] + 1 });
			}
			if (tmp3 >= 0 && tmp3 <= 100000 && !visited[tmp3]) {
				q.offer(new int[] { tmp3, now[1] + 1 });
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited[n] = true;
		bfs(n);

		System.out.println(min);
	}
}
