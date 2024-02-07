import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
	int abs;
	int num;

	public Pair(int abs, int num) {
		super();
		this.abs = abs;
		this.num = num;
	}

	@Override
	public int compareTo(Pair o) {
		if (o.abs == this.abs) {
			return this.num - o.num;
		}
		return this.abs - o.abs;
	}

}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Pair> q = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());

			if (tmp != 0) {
				q.add(new Pair(Math.abs(tmp), tmp));
			} else {
				if (q.isEmpty()) {
					System.out.println(0);
				} else
					System.out.println(q.poll().num);
			}
		}
	}
}