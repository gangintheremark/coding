import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n;
    private static int[] parent;
    private static ArrayList<Edge> graph = new ArrayList<>();

    public static class Edge implements Comparable<Edge> {
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

    public static int find(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        ArrayList<Edge> X = new ArrayList<>();
        ArrayList<Edge> Y = new ArrayList<>();
        ArrayList<Edge> Z = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            X.add(new Edge(i, 0, x));
            Y.add(new Edge(i, 0, y));
            Z.add(new Edge(i, 0, z));
        }

        Collections.sort(X);
        Collections.sort(Y);
        Collections.sort(Z);

        for (int i = 0; i < n - 1; i++) {
            graph.add(new Edge(X.get(i).v, X.get(i+1).v, Math.abs(X.get(i).cost - X.get(i+1).cost)));
            graph.add(new Edge(Y.get(i).v, Y.get(i+1).v, Math.abs(Y.get(i).cost - Y.get(i+1).cost)));
            graph.add(new Edge(Z.get(i).v, Z.get(i+1).v, Math.abs(Z.get(i).cost - Z.get(i+1).cost)));
        }

        Collections.sort(graph);
        
        int result = 0;
        for (int i = 0; i < graph.size(); i++) {
            Edge edge = graph.get(i);

            if (find(edge.v) != find(edge.w)) {
                union(edge.v, edge.w);
                result += edge.cost;
            }
        }
        System.out.println(result);
    }
}