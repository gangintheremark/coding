import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node> {
		int startT;
		int endT;
		public Node(int startT, int endT) {
			this.startT = startT;
			this.endT = endT;
		}
		@Override
		public int compareTo(Node o) {
			if(this.endT == o.endT)
				return this.startT - o.startT;
			return this.endT - o.endT;
		}		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<Main.Node>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		int endTime = 0;
		int result = 0;
		for(Node node : list) {
			if(endTime <= node.startT) {
				result++;
				endTime = node.endT;
			}
		}
		System.out.println(result);

	}
}
