import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n, m;
    private static long total, cost;
    private static int[] parent;
    private static ArrayList<Edge> graph = new ArrayList<>();

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
            return this.cost - o.cost;
        }
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                total += w;
                graph.add(new Edge(u, v, w));
            }

            Collections.sort(graph);

            for (int i = 0; i < graph.size(); i++) {
                Edge edge = graph.get(i);

                if (find(edge.v) != find(edge.w)) {
                    union(edge.v, edge.w);
                    cost += edge.cost;
                }
            }

            sb.append(total - cost).append('\n');
            graph.clear();
            total = cost = 0;
        }
        System.out.println(sb);

    }
}