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
		List<Integer> list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) 
			list.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(list);
		
		int result = 0;
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			result += sum;
		}
		System.out.println(result);

	}
}
