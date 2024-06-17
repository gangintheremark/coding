import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int INF = Integer.MAX_VALUE;
    private static int n, m, count, time;
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
        d[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;

            if (d[now] < node.cost) continue;
            count++;
            time = node.cost;
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
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            graph.clear();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            d = new int[n + 1];
            Arrays.fill(d, INF);
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<Node>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph.get(v).add(new Node(u, w));
            }
            dijkstra(start);
            sb.append(count).append(' ').append(time).append('\n');
            count = time = 0;
        }
        System.out.println(sb);
    }

}