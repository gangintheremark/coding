import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] parent;
    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (b > a) parent[b] = parent[a];
        else parent[a] = parent[b];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String result = "YES";
        n = Integer.parseInt(br.readLine()); // 도시의 수
        m = Integer.parseInt(br.readLine()); // 여행다닐 도시의 수

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                if (tmp == 1)
                    union(i, j);
            }

        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        for (int i = 1; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            if (find(a) != find(tmp)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(result);
    }

}
