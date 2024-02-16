import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	private static int N, M;
	private static int[][] map;
	private static boolean[] virus;

	public static int bfs(int v) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(v);
		virus[v] = true;
		int count = 0;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 1; i <= N; i++) {
				if(!virus[i] && map[now][i] == 1) {
					virus[i] = true;
					q.offer(i);
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		virus = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
	
		System.out.println(bfs(1));
	}

}
