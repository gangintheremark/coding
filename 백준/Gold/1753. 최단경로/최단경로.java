import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int v, e;
    private static int INF = Integer.MAX_VALUE;
    private static int[] d;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

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

    public static void dijkstra(int start) {
        d = new int[v + 1];
        Arrays.fill(d, INF);
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
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }
        dijkstra(start);

        for (int i = 1; i <= v; i++) {
            sb.append(d[i] == INF ? "INF" : d[i]).append('\n');
        }

        System.out.println(sb);
    }

}