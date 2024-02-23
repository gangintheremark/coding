import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean flag;
	static boolean[][] graph;
	static int[] visited;
	static ArrayList<Integer>[] friend;
	/*
	 * friend[0][1] = true; friend[1][2] = true; friend[2][3] = true; friend[3][4] =
	 * true;
	 */

	public static void dfs(int index, int count) {
		if (count == 4) {
			System.out.println(1);
			System.exit(0);
			return;
		}
		for (int i : friend[index]) {
			if (visited[i] == 0) {
				visited[i] = 1;
				dfs(i, count + 1);
				visited[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		friend = new ArrayList[n]; // 자신과 친구들을 연결
        for(int i=0; i<n; i++) 
            friend[i] = new ArrayList<>();
        
		visited = new int[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			friend[a].add(b);
			friend[b].add(a);
		}

		for (int i = 0; i < n; i++) {
			visited[i] = 1;
			dfs(i,0);
			visited[i] = 0;
		}
		System.out.println(0);
	}
}