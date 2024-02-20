import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M, min = Integer.MAX_VALUE;
	static boolean[] checked;

	static List<int[]> house = new ArrayList<int[]>();
	static List<int[]> chicken = new ArrayList<int[]>();

	/*
	 * 치킨가게 중 M개를 선택할 때, 도시의 치킨 거리의 최소값
	 */

	public static void dfs(int index, int count) {
		if (count == M) {
			// 치킨거리 구하기
			int sum = 0;
			for (int i = 0; i < house.size(); i++) {
				int minDist = Integer.MAX_VALUE;

				for (int j = 0; j < chicken.size(); j++) {
					if (checked[j]) {
						int dist = Math.abs(chicken.get(j)[0] - house.get(i)[0])
								+ Math.abs(chicken.get(j)[1] - house.get(i)[1]);
						minDist = Math.min(dist, minDist);
					}
				}
				sum += minDist;
			}

			min = Math.min(sum, min);
			return;
		}

		if (index >= chicken.size())
			return;

		// index 번째 치킨 집 포함
		checked[index] = true;
		dfs(index + 1, count + 1);

		// index 번째 치킨 집 미포함
		checked[index] = false;
		dfs(index + 1, count);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());

				if (tmp == 1)
					house.add(new int[] { i, j });
				else if (tmp == 2)
					chicken.add(new int[] { i, j });
			}
		}

		checked = new boolean[chicken.size()];

		dfs(0, 0);

		System.out.println(min);
	}
}
