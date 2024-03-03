import java.io.*;
import java.util.*;

public class Main {

	static int N, result = Integer.MAX_VALUE;
	static int peoples[]; // 구역별 인구수
	static List<ArrayList<Integer>> graph  = new ArrayList<>();
	static boolean selected[];
	static boolean visited[];
	static List<Integer> a = new ArrayList<Integer>();
	static List<Integer> b = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 지역 개수
		peoples = new int[N]; // 지역별 인구 수
		selected = new boolean[N]; // 부분집합 만들 때 사용
		visited = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) // 지역별 인구 수 입력
			peoples[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) 
			graph.add(new ArrayList<Integer>());
		

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken()); // 인접 구역 수
			for (int j = 0; j < cnt; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()) - 1);
			}
		}

		divide(0);

		System.out.println(result == Integer.MAX_VALUE ? -1 : result);

	}

	private static void divide(int idx) { // 1. 선거구 나누기
		if (idx == N) {
			a.clear();
			b.clear();
			for (int i = 0; i < N; i++) {
				if (selected[i])
					a.add(i);
				else
					b.add(i);
			}
			if (a.size() == 0 || b.size() == 0) 
				return;
			
			if (check(a) && check(b)) { // 두 구역이 각각 연결되었는지 확인
				getPeopleDiff(); // 인구차 구하기
			}
			return;
		}

		selected[idx] = true;
		divide(idx + 1);
		selected[idx] = false;
		divide(idx + 1);

	}

	private static boolean check(List<Integer> list) {

		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[N];
		visited[list.get(0)] = true;
		q.offer(list.get(0));
		
		int count = 1; // 방문한 지역 개수
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < graph.get(cur).size(); i++) {
				int y = graph.get(cur).get(i);
				if(list.contains(y) && !visited[y]) { // 선거구에 해당하고, 아직 미방문
					q.offer(y);
					visited[y] = true;
					count ++;
				}
			}
		}
		if(count==list.size()) // 선거구에 해당하는 지역수와 방문한 지역수가 같은 경우
			return true;
		else
			return false;
	}


	private static void getPeopleDiff() { // 3. 선거구의 인구 차 구하기
		// a구역 사람수
		int pA = 0, pB = 0;
		for (int i = 0; i < N; i++) {
			if (selected[i])
				pA += peoples[i];
			else
				pB += peoples[i];
		}
		int diff = Math.abs(pA - pB);
		result = Math.min(result, diff);
	}

}