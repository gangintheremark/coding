import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int INF = Integer.MAX_VALUE;
    private static int n, m;
    private static int[] in, out;
    private static ArrayList<ArrayList<Node>> graphIn = new ArrayList<>();
    private static ArrayList<ArrayList<Node>> graphOut = new ArrayList<>();

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void dijkstra(int start, int[] d, ArrayList<ArrayList<Node>> graph) {
        d[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;

            if (d[now] < node.cost) continue;

            for (Node next : graph.get(now)) {
                int cost = d[now] + next.cost;
                if (d[next.index] > cost) {
                    d[next.index] = cost;
                    pq.offer(new Node(next.index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graphIn.add(new ArrayList<Node>());
            graphOut.add(new ArrayList<Node>());
        }

        in = new int[n + 1];
        out = new int[n + 1];
        Arrays.fill(in, INF);
        Arrays.fill(out, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graphIn.get(v).add(new Node(u, w));
            graphOut.get(u).add(new Node(v, w));
        }

        dijkstra(start, in, graphIn);
        dijkstra(start, out, graphOut);

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, in[i] + out[i]);
        }
        System.out.println(result);
    }

}