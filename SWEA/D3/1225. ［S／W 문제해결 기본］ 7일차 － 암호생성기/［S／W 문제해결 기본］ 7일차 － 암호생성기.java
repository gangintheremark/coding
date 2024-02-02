import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Deque<Integer> Q = new ArrayDeque<>();
		for (int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				Q.offer(Integer.parseInt(st.nextToken()));
			}

			int count = 0;
			int num = 1;
			while (Q.getLast() != 0) {
				Q.offerLast(Q.poll() - num++);
				count++;
				if (Q.getLast() < 0) {
					Q.pollLast();
					Q.offerLast(0);
				}
				if (count == 5) {
					count = 0;
					num = 1;
				}
			}

			sb.append("#" + tc);
			while (!Q.isEmpty()) {
				sb.append(" " + Q.poll());
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}