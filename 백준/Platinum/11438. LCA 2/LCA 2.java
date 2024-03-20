import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static boolean[] checked;
	static int[] d; // 각 노드의 깊이 배열
	static int[][] parent; // [v][i] : v 노드의 2^i번째 부모 정보
	static List<ArrayList<Integer>> graph = new ArrayList<>();

	static void dfs(int x, int depth) {
		checked[x] = true;
		d[x] = depth;
		for (int y : graph.get(x)) {
			if (checked[y])
				continue;
			parent[y][0] = x;
			dfs(y, depth + 1);
		}
	}

	static int lca(int a, int b) {
		if (d[a] > d[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		for (int i = k; i >= 0; i--) {
			if (d[b] - d[a] >= (1 << i))
				b = parent[b][i];
		}

		if (a == b)
			return a;

		for (int i = k - 1; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		d = new int[n + 1];
		checked = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		
		// 최대 depth 알아내기.
		int tmp = 1;
		while (tmp <= n) { 
            tmp <<= 1;
            k++;
        }
		
		parent = new int[n + 1][k];
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		dfs(1, 0);

		for (int i = 1; i < k; i++) {
			for (int j = 1; j <= n; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(lca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append('\n');
		}
		
		System.out.println(sb);
	}

}
