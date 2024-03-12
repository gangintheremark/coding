import java.io.*;
import java.util.*;

public class Main {

	static int n, m;

	static long bfs(int start) {
		Queue<long[]> q = new LinkedList<>();
		q.offer(new long[] { start, 0 });
		while (!q.isEmpty()) {
			long[] now = q.poll();

			long tmp1 = now[0] * 2;

			StringBuilder sb = new StringBuilder();
			sb.append(now[0]).append(1);
			long tmp2 = Long.parseLong(sb.toString());

			if (tmp1 == m || tmp2 == m) {
				return now[1] + 1;
			}
			if (tmp1 <= m)
				q.offer(new long[] { tmp1, now[1] + 1 });
			if (tmp2 <= m)
				q.offer(new long[] { tmp2, now[1] + 1 });
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		long result = bfs(n);
		System.out.println(result == -1 ? -1 : result + 1);
	}
}
