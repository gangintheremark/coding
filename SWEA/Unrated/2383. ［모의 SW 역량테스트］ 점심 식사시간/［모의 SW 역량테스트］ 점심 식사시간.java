import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	/*
	 * 어떤 사람이 몇 번 계단 갈지 결정 이동 계단 내려가기 최소시간 구하기 계단은 무조건 2개.
	 */
	static int result = Integer.MAX_VALUE;
	static int n;
	static List<Node> stairs = new ArrayList<>();
	static List<Person> people = new ArrayList<>();
	static int[][] moveT;
	static LinkedList<Person> cur = new LinkedList<>();

	static class Person {
		int x;
		int y;
		int stair;
		int floor;

		public Person(int x, int y, int stair, int floor) {
			this.x = x;
			this.y = y;
			this.stair = stair;
			this.floor = floor;
		}
	}

	static class Node {
		int x;
		int y;
		int floors; // 층 수

		public Node(int x, int y, int floors) {
			this.x = x;
			this.y = y;
			this.floors = floors;
		}
	}

	public static int cal_time(int start, int stairsNum, int total) {
		int time = start + 1;
		int cnt = 0;
		cur.clear();

		while (true) {
			for (int i = 0; i < people.size(); i++) {
				// 계단 입구 도착 시간이 되면 계단 큐에 추가
				if (people.get(i).stair != stairsNum)
					continue;

				if (moveT[stairsNum][i] == time - 1)
					cur.add(people.get(i));
			}

			// 계단 내려가기
			if (!cur.isEmpty())
				for (int j = 0; j < 3 && j < cur.size(); j++) {
					cur.get(j).floor++;
				}
			
			// 계단 다 내려간 경우
			for (int i = 0; i < cur.size(); i++) {
				if (cur.get(i).floor == stairs.get(stairsNum).floors) {
					cur.removeFirst();
					cnt++;
					i--;
				} else
					break;
			}

			time++;
			// 모든 계단을 다 내려간 경우
			if (cur.isEmpty() && cnt == total)
				return time;


			if (time > result)
				return time;
		}
	}

	public static int down_stairs(int total0, int total1) {
		int time = 0;
		int min0 = Integer.MAX_VALUE;
		int min1 = Integer.MAX_VALUE;

		for (int i = 0; i < people.size(); i++) {
			if (people.get(i).stair == 0)
				min0 = Math.min(min0, moveT[0][i]);
			else
				min1 = Math.min(min1, moveT[1][i]);
		}

		if (min0 == Integer.MAX_VALUE)
			return cal_time(min1, 1, total1);
		else if (min1 == Integer.MAX_VALUE)
			return cal_time(min0, 0, total0);
		else
			return Math.max(cal_time(min0, 0, total0), cal_time(min1, 1, total1));
	}

	public static void combi(int index, int total0, int total1) {
		if (index == people.size()) {
			// 모든 사람이 계단을 내려가 이동 완료하는 시간 구하기
			int down = down_stairs(total0, total1);
			for (int i = 0; i < people.size(); i++) {
//				System.out.print(people.get(i).floor + " ");
				people.get(i).floor = 0;
			}
//			System.out.println();
			result = Math.min(down, result);

			return;
		}

		// index 번 사람이 0번 계단 선택
		people.get(index).stair = 0;
		combi(index + 1, total0 + 1, total1);
		// index 번 사람이 1번 계단 선택
		people.get(index).stair = 1;
		combi(index + 1, total0, total1 + 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if (tmp == 1)
						people.add(new Person(i, j, 0, 0));
					else if (tmp >= 2 && tmp <= 10)
						stairs.add(new Node(i, j, tmp));
				}
			}

			// 사람마다 계단입구까지 이동시간 구하기
			moveT = new int[2][people.size()];

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < people.size(); j++)
					// j번 사람이 i번째 계단으로 가는 이동시간
					moveT[i][j] = Math.abs(stairs.get(i).x - people.get(j).x)
							+ Math.abs(stairs.get(i).y - people.get(j).y);
			}

			combi(0, 0, 0);

			sb.append('#').append(t).append(' ').append(result).append('\n');
			people.clear();
			stairs.clear();
			result = Integer.MAX_VALUE;
		}
		System.out.println(sb);
	}
}