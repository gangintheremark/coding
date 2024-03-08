import java.io.*;
import java.util.*;

public class Main {
	static int n, m, a, b;
	static int count = 1;
	static int[] d, pre;
	static List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

	static class Node implements Comparable<Node> {
		int index;
		int dist;

		public Node(int v, int cost) {
			this.index = v;
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
			Node node = pq.poll();
			int now = node.index;
			int dist = node.dist;

			if (dist > d[now])
				continue;

			// now와 인접한 노드 중 출발노드에서 now를 거쳐가는 것이 더 빠른경우
			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).dist;
				if (cost < d[graph.get(now).get(i).index]) {
					d[graph.get(now).get(i).index] = cost;
					pq.offer(new Node(graph.get(now).get(i).index, cost));
					pre[graph.get(now).get(i).index] = now;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		d = new int[n + 1];
		pre = new int[n + 1]; // 이전 도시가 무엇인지 저장
		Arrays.fill(d, Integer.MAX_VALUE);
		for (int i = 0; i <= n; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken()))
					.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		dijkstra(a);

		sb.append(d[b]).append('\n');

		Stack<Integer> stack = new Stack<>();
		stack.push(b);
		while (pre[b] != 0) {
			count++;
			stack.push(pre[b]);
			b = pre[b];
		}

		sb.append(count).append('\n');
		while (!stack.isEmpty())
			sb.append(stack.pop()).append(' ');

		System.out.println(sb);
	}
}
