import java.io.*;
import java.util.*;

public class Main {
	static int n, m, INF = (int) 1e10;
	static ArrayList<Edge> graph = new ArrayList<>();;
	static long[] d;

	static class Edge {
		int v;
		int w;
		int cost;

		public Edge(int start, int end, int cost) {
			this.v = start;
			this.w = end;
			this.cost = cost;
		}
	}

	public static boolean BellmanFord(int start) {
		d[start] = 0;

		// 정점의 개수만큼 반복
		for (int i = 0; i < n; i++) {
			// 간선의 개수만큼 반복
			for (int j = 0; j < m; j++) {
				Edge edge = graph.get(j);

				// 현재 간선의 들어오는 정점에 대해 비교
				if (d[edge.v] != INF && d[edge.w] > d[edge.v] + edge.cost)
					d[edge.w] = d[edge.v] + edge.cost;
			}
		}

		// 음의 가중치 확인
		for (int i = 0; i < m; i++) {
			Edge edge = graph.get(i); // 현재 간선

			// 현재 간선의 들어오는 정점에 대해 비교 => 더 작은 값이 생기면 음수 사이클 존재
			if (d[edge.v] != INF && d[edge.w] > d[edge.v] + edge.cost)
				return false;
		}

		return true;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		d = new long[n + 1];
		Arrays.fill(d, INF);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			graph.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		boolean flag = BellmanFord(1);

		for (int i = 2; i <= n; i++) {
			if (flag) {
				if (d[i] == INF)
					sb.append(-1);
				else
					sb.append(d[i]);
			} else {
				sb.append(-1).append('\n');
				break;
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
