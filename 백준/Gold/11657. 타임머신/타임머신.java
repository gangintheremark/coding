import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int INF = (int) 1e10;
    private static int n, m;
    private static ArrayList<Edge> graph = new ArrayList<>();
    private static long[] d;

    static class Edge {
        int v;
        int w;
        int cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }

    public static boolean BellmanFord() {
        d[1] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = graph.get(j);

                if (d[edge.v] != INF && d[edge.w] > d[edge.v] + edge.cost) {
                    d[edge.w] = d[edge.v] + edge.cost;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Edge edge = graph.get(i);

            if (d[edge.v] != INF && d[edge.w] > d[edge.v] + edge.cost) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        d = new long[n + 1];
        Arrays.fill(d, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.add(new Edge(u, v, w));
        }

        if (BellmanFord()) {
            for (int i = 2; i <= n; i++) {
                sb.append(d[i] == INF ? -1 : d[i]).append('\n');
            }
        } else {
            sb.append(-1).append('\n');
        }
        System.out.println(sb);
    }

}