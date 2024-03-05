import java.io.*;
import java.util.*;

public class Main {
	// 다익스트라
	static int n, m, x, result = 0;
	static List<ArrayList<Node>> graphIn = new ArrayList<ArrayList<Node>>();
	static List<ArrayList<Node>> graphOut = new ArrayList<ArrayList<Node>>();
	static int[] go, back;

	// go : 1번 ~ N번 노드가 X번 마을로 가는 데 최소 비용
	// back : X번 마을에서 1~N번 마을로 가는 데 최소 비용

	static class Node implements Comparable<Node> {
		int v;
		int dist;

		public Node(int v, int cost) {
			this.v = v;
			this.dist = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}

	public static void dijkstra(int start, int[] d, List<ArrayList<Node>> graph) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.dist;
			int now = node.v;

			if (d[now] < dist)
				continue;

			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).dist;

				if (cost < d[graph.get(now).get(i).v]) {
					d[graph.get(now).get(i).v] = cost;
					if (graph.get(now).get(i).v == x && start != x) {
						go[start] = cost;
						break;
					}
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
		x = Integer.parseInt(st.nextToken());

		back = new int[n + 1];
		go = new int[n + 1];

		for (int i = 0; i <= n; i++)
			graphIn.add(new ArrayList<>());

		for (int i = 0; i <= n; i++)
			graphOut.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graphIn.get(a).add(new Node(b, c));
			graphOut.get(b).add(new Node(a, c));
		}

		Arrays.fill(go, Integer.MAX_VALUE);
		Arrays.fill(back, Integer.MAX_VALUE);

		dijkstra(x, go, graphOut);
		dijkstra(x, back, graphIn);

		for (int i = 1; i <= n; i++)
			result = Math.max(result, go[i] + back[i]);

		System.out.println(result);
	}

}
