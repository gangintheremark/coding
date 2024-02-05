import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new ArrayDeque<Integer>();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		sb.append("<");
		int count = 0;
		int index = 1;
		while (count < N) {

			if (index++ % K == 0) {
				sb.append(q.poll());
				count++;
				if (count == N) {
					sb.append(">");
					break;
				}
				sb.append(", ");
				continue;
			}

			q.offerLast(q.poll());
		}
		System.out.println(sb);
	}
}