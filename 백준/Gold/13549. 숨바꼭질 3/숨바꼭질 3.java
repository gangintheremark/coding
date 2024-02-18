import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N, K, min = Integer.MAX_VALUE, max = 100000;
    static boolean[] visited;

    public static class Node {
        int x;
        int t;

        public Node(int x, int t) {
            this.x = x;
            this.t = t;
        }
    }

    public static void bfs() {
        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(N, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.x] = true;
            if (node.x == K) min = Math.min(min, node.t);

            if (node.x * 2 <= max && !visited[node.x * 2]) q.offer(new Node(node.x * 2, node.t));
            if (node.x + 1 <= max && !visited[node.x + 1]) q.offer(new Node(node.x + 1, node.t + 1));
            if (node.x - 1 >= 0 && !visited[node.x - 1]) q.offer(new Node(node.x - 1, node.t + 1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[max + 1];

        bfs();
        System.out.println(min);

    }
}
