import java.io.*;
import java.util.*;

public class Main {
	// 다익스트라
	static int n, m;
	static List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int[] d;

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

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		while (!pq.isEmpty()) {
			Node tmp = pq.poll();
			int dist = tmp.dist;
			int now = tmp.v;

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
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		d = new int[n + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken()))
					.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(d[end]);
	}

}
