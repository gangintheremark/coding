import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;

	public Node(int x) {
		this.x = x;
	}
}

class Edge implements Comparable<Edge> {
	private long distance;
	private int nodeA;
	private int nodeB;

	public Edge(long distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public int getNodeA() {
		return nodeA;
	}

	public void setNodeA(int nodeA) {
		this.nodeA = nodeA;
	}

	public int getNodeB() {
		return nodeB;
	}

	public void setNodeB(int nodeB) {
		this.nodeB = nodeB;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.distance < o.distance)
			return -1;
		return 1;
	}
}

public class Solution {
	static int n; // 섬의 개수
	static long[] parent = new long[10001];
	static List<Edge> edges = new ArrayList<>(); // 모든 간선을 담을 리스트
	static long result;
	static double e;

	/* 환경 부담금 = e * 해저터널길이^2 */
	/* 최소가 되는 환경부담금 */

	public static long getParent(long x) {
		if (x == parent[(int) x])
			return x;
		return parent[(int) x] = getParent(parent[(int) x]);
	}

	public static void unionParent(long a, long b) {
		a = getParent(a);
		b = getParent(b);
		if (a < b)
			parent[(int) b] = a;
		else
			parent[(int) a] = b;
	}

	public static boolean findParent(long a, long b) {
		a = getParent(a);
		b = getParent(b);
		return a == b;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new FileInputStream("re_sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			edges.clear();
			n = Integer.parseInt(br.readLine());
			long[] x = new long[n];
			long[] y = new long[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				x[i] = Long.parseLong(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				y[i] = Long.parseLong(st.nextToken());
			}
			e = Double.parseDouble(br.readLine());

			parent = new long[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					// Node(i) 와 Node(i+1)의 간선 길이
					long distance = (long) (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
					edges.add(new Edge(distance, i, j));
				}
			}

			Collections.sort(edges);

			for(Edge e : edges) {
				if(!findParent(e.getNodeA(), e.getNodeB())) {
					unionParent(e.getNodeA(), e.getNodeB());
					result += e.getDistance();
				}
			}

			sb.append('#').append(t).append(' ').append(Math.round(e * result)).append('\n');
			result = 0;
		}
		System.out.println(sb);
	}
}