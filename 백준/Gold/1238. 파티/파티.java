import java.io.*;
import java.util.*;

public class Main {
	// 다익스트라
	static int n, m, x, result = 0;
	static List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int[][] go;
	static int[] back;

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

	public static void dijkstra(int start, int[] d) {
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
					if(graph.get(now).get(i).v == x) break;
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
		go = new int[n + 1][n + 1];

		Arrays.fill(back, Integer.MAX_VALUE);
		for (int i = 1; i <= n; i++)
			Arrays.fill(go[i], Integer.MAX_VALUE);

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken()))
					.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		for (int i = 1; i <= n; i++) {
			// i번 노드에서 모든 노드까지의 최소거리 구하기
			if (i == x)
				continue;
			dijkstra(i, go[i]);
		}

		dijkstra(x, back);

		for (int i = 1; i <= n; i++) {
			if (go[i][x] != Integer.MAX_VALUE)
				result = Math.max(result, go[i][x] + back[i]);
		}

		System.out.println(result);
	}

}
