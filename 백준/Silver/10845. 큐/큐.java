import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		Deque<Integer> q = new ArrayDeque<Integer>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			if (str.split(" ")[0].equals("push")) {
				q.offer(Integer.parseInt(str.split(" ")[1]));
				continue;
			} else if (str.split(" ")[0].equals("front")) {
				if (q.isEmpty())
					sb.append(-1);
				else
					sb.append(q.peekFirst());
			} else if (str.split(" ")[0].equals("back")) {
				if (q.isEmpty())
					sb.append(-1);
				else
					sb.append(q.peekLast());
			} else if (str.split(" ")[0].equals("pop")) {
				if (q.isEmpty())
					sb.append(-1);
				else
					sb.append(q.pollFirst());
			} else if (str.split(" ")[0].equals("empty")) {
				if (q.isEmpty())
					sb.append(1);
				else
					sb.append(0);
			} else if (str.split(" ")[0].equals("size")) {
				sb.append(q.size());
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}