import java.io.*;
import java.util.*;

public class Main {
	// 다익스트라
	static int n, m, result = 0, INF = Integer.MAX_VALUE;
	static int[] d;
	static List<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();

	static class Edge implements Comparable<Edge> {
		int v;
		int dist;

		public Edge(int v, int cost) {
			this.v = v;
			this.dist = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Arrays.fill(d, Integer.MAX_VALUE);
		pq.offer(new Edge(start, 0));
		d[start] = 0;
		while (!pq.isEmpty()) {
			Edge node = pq.poll();
			int dist = node.dist;
			int now = node.v;

			if (d[now] < dist)
				continue;

			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).dist;

				if (cost < d[graph.get(now).get(i).v]) {
					d[graph.get(now).get(i).v] = cost;
					pq.offer(graph.get(now).get(i));
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		d = new int[n + 1];
		Arrays.fill(d, INF);

		for (int i = 0; i <= n; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		int startU = 0;
		int startV = 0;

		dijkstra(u);

		if (d[v] != INF && d[1] != INF)
			startU = d[v] + d[1];
		else
			startU = -1;

		if (d[n] != INF) {
			startV = d[n];
		} else
			startV = -1;

		dijkstra(v);

		if (startV != -1 && d[u] != INF && d[1] != INF)
			startV += d[u] + d[1];
		else
			startV = -1;

		if (startU != -1 && d[n] != INF)
			startU += d[n];
		else
			startU = -1;

		if (startU != -1 && startV != -1)
			result = Math.min(startU, startV);
		else if (startU != -1)
			result = startU;
		else if (startV != -1)
			result = startV;
		else
			result = -1;
		System.out.println(result);

		/*
		 * u에서 출발 d[1] d[v] d[N]
		 * 
		 * v에서 출발 d[1] d[u] d[N]
		 * 
		 */

	}

}

/*
 * 4 2 1 3 5 2 4 5 3 2
 * 
 * 답 : -1
 */
