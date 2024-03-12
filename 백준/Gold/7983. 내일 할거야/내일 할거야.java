import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node> {
		int day;
		int end;
		public Node(int day, int end) {
			this.day = day;
			this.end = end;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(o.end == this.end)
				return this.day - o.day;
			return o.end - this.end;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Node> nodes = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			nodes.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Node node = nodes.poll();
		int now = node.end - node.day;
		while(!nodes.isEmpty()) {
			node = nodes.peek();
			
			if(now <= node.end) {
				now -= node.day;
				nodes.poll();
			} else {
				now -= now - node.end;
			}
			
			
		}
		System.out.println(now);
		
		
	}

}
