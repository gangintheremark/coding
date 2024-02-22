import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int index;
	int time;

	public Node(int index, int time) {
		this.index = index;
		this.time = time;
	}
}

public class Solution {

	static int n, start, lastTime, result;
	static Node[] nodes = new Node[101];
	static boolean[][] graph = new boolean[101][101];
	static Queue<Node> q = new ArrayDeque<>();
	static boolean[] visited = new boolean[101];

	public static void bfs() {
		visited[start] = true;
		nodes[start] = new Node(start, 0);
		q.offer(nodes[start]);
		while (!q.isEmpty()) {
			Node now = q.poll();

			for (int i = 1; i <= 100; i++) {
				if(!visited[i] && graph[now.index][i]) {
					// 방문하지 않았고, index가 전화 걸 수 있는 번호 찾기
					visited[i] = true;
					nodes[i] = new Node(i, now.time + 1);
					q.offer(nodes[i]);	
					lastTime = now.time + 1;
				}
			}
		}
		
		for(int i = 1; i<=100; i++) {
				if(nodes[i] != null && nodes[i].time == lastTime) {
					result = Math.max(result, i);
				}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
	//	System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			nodes = new Node[101];
			for(boolean[] col : graph)
				Arrays.fill(col, false);
			Arrays.fill(visited, false);
			result = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph[from][to] = true;
			}
			bfs();
			sb.append('#').append(t).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
}