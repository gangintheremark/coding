import java.io.*;
import java.util.*;

public class Main {

	static int v, e;
	static int[] parent;
	static long result;
	static List<Edge> graph = new ArrayList<>();

	static class Edge implements Comparable<Edge> {
		int v;
		int w;
		int cost;

		public Edge(int v, int w, int cost) {
			this.v = v;
			this.w = w;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.cost < o.cost)
				return -1;
			return 1;
		}
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);

	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b)
			parent[b] = parent[a];
		else
			parent[a] = parent[b];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		parent = new int[v + 1];
		for (int i = 1; i <= v; i++) 
			parent[i] = i;
		

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.add(new Edge(v, w, c));
		}
		
		Collections.sort(graph);

		for (int i = 0; i < graph.size(); i++) {
			Edge e = graph.get(i);
			
			if(find(e.v) != find(e.w)) {
				union(e.v, e.w);
				result += e.cost;
			}
		}
		System.out.println(result);
	}

}
