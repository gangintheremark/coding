import java.io.*;
import java.util.*;

public class Main {
    static final int INF = (int) 1e9;
    static int n, m;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++)
            Arrays.fill(graph[i], INF);

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (i == j) graph[i][j] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], c);
        }

        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF) sb.append(0);
                else  sb.append(graph[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
