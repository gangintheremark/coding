import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] indegree;
    static int[] result;
    static Node[] graph;

    static class Node implements Comparable<Node> {
        int index;
        int time;
        ArrayList<Integer> list;

        public Node() {
            list = new ArrayList<>();
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static void topologySort() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0)
                pq.offer(graph[i]);
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            result[now.index] = now.time;

            for (int i = 0; i < now.list.size(); i++) {
                int work = now.list.get(i);
                indegree[work]--;

                if (indegree[work] == 0) {
                    graph[work].time += now.time;
                    pq.offer(graph[work]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        indegree = new int[n + 1];
        graph = new Node[n + 1];
        result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new Node();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            graph[i].index = i;
            graph[i].time = time;
            while (st.hasMoreTokens()) {
                int preWork = Integer.parseInt(st.nextToken());
                if (preWork == -1) break;

                graph[preWork].list.add(i);
                indegree[i]++;
            }
        }
        topologySort();

        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }

}
