import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int index;
		int score;
		int time;

		public Node(int index, int score, int time) {
			super();
			this.index = index;
			this.score = score;
			this.time = time;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 1. 업무는 가장 최근에 주어진 순서대로. 업무를 받으면 바로 시작 2. 업무를 하던 도중 새로운 업무가 추가된다면, 하던 업무 중단 및
		 * 새로운 업무 진행 3. 새로운 업무가 끝나면, 이전에 하던 업무 이어서
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Deque<Node> q = new ArrayDeque<>();
		Node now = null; // 현재 진행중인 업무

		int n = Integer.parseInt(br.readLine()); // 총 몇 분인지
		int result = 0;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			int task = Integer.parseInt(st.nextToken());
			if (task == 0) {
				// 지금 하고 있는 업무의 time--
				if (now != null) {
					now.time--;

					if (now.time == 0) {
						result += now.score;
						q.remove(now);
						if (q.isEmpty())
							continue;
						now = q.peekLast();
					}
				}
			} else {
				Node tmp = new Node(task, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1);
				if (tmp.time == 0) {
					result += tmp.score;
					continue;
				}
				q.add(tmp);
				now = tmp;
			}

		}

		System.out.println(result);

	}
}
