import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int MAX_NODE = 101;
    private static int INF = (int) 1e9; // 무한을 의미하는 값으로 10억 설정
    private static int[][] graph = new int[MAX_NODE][MAX_NODE];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 최단거리 테이블 초기화
        for (int i = 0; i < MAX_NODE; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 본인에서 본인으로 가는 비용은 0으로 초기화
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u][v] = Math.min(graph[u][v], w); // 도시끼리 연결하는 노선은 하나가 아닐 수 있다
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(graph[i][j] == INF ? 0 : graph[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}