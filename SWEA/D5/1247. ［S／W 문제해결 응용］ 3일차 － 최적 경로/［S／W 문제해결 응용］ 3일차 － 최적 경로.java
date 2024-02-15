import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

	static int n, result = Integer.MAX_VALUE;
	static int[][] mat;
	static boolean[] visited;
	static List<int[]> list = new ArrayList<int[]>();

	public static void dfs(int count, int sum, int prev) {
		if (count == n) {
			// 모든 집을 방문했을 때,
			sum += mat[prev+2][1];
			result = Math.min(result, sum);
			return;
		}

		for (int i = 0; i < n; i++) {
			// 방문하지 않은 집이라면
			if (!visited[i]) {
				visited[i] = true;
				dfs(count + 1, sum + mat[prev+2][i+2], i);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine()); // 고객의 수
			st = new StringTokenizer(br.readLine());

			/* 0은 회사, 1은 집, 2 ~ n+2 고객 */
			mat = new int[n + 2][n + 2];
			visited = new boolean[n];

			// 회사좌표
			int wx = Integer.parseInt(st.nextToken());
			int wy = Integer.parseInt(st.nextToken());

			// 집 좌표
			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			
			list.clear();
			for (int i = 0; i < n; i++) {
				list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}

			// 각각의 거리 계산
			for (int i = 0; i < n; i++) {
				int x = list.get(i)[0];
				int y = list.get(i)[1];

				mat[0][i + 2] = mat[i + 2][0] = Math.abs(wx - x) + Math.abs(wy - y);
				mat[1][i + 2] = mat[i + 2][1] = Math.abs(hx - x) + Math.abs(hy - y);

				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;

					int x2 = list.get(j)[0];
					int y2 = list.get(j)[1];

					mat[i + 2][j + 2] = mat[j + 2][i + 2] = Math.abs(x - x2) + Math.abs(y - y2);
				}
			}

			for (int i = 0; i < n; i++) {
				Arrays.fill(visited, false);
				visited[i] = true;
				dfs(1, mat[0][i+2], i);
				visited[i] = false;
			}
			
			sb.append('#').append(t).append(' ').append(result).append('\n');
			result = Integer.MAX_VALUE;
		}
		System.out.println(sb);

	}

}