import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if(Q.isEmpty()) System.out.println(0);
				else 
					System.out.println(Q.poll());
			} else {
				Q.add(x);
			}
		}
	}

}