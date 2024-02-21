import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
	//	System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		List<int[]> cores = new ArrayList<int[]>();

		for (int t = 1; t <= T; t++) {
			cores.clear();
			int n = Integer.parseInt(br.readLine());
			boolean[][] visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {

					if (Integer.parseInt(st.nextToken()) == 1) {
						if (i != 0 && i != n - 1 && j != 0 && j != n - 1)
							cores.add(new int[] { i, j });

						visited[i][j] = true;
					}
				}
			}

			boolean flag = true;
			int minLength = Integer.MAX_VALUE;
			int d = -1;
			int sum = 0;
			int max = 0;
			int min = Integer.MAX_VALUE;
			int count = 0;
			boolean[][] copy = new boolean[n][n];
			for (int i = 0; i < cores.size(); i++) {

				for (int c = 0; c < n; c++) {
					copy[c] = Arrays.copyOf(visited[c], visited[c].length);
				}

				sum = 0;

				count = 0;
				for (int j = 0; j < cores.size(); j++) {
					d = -1;
					minLength = Integer.MAX_VALUE;
					int[] tmp = cores.get((j + i) % cores.size());
					int x = tmp[0];
					int y = tmp[1];
					// 코어하나 씩 짧은 경로로 코드 연결해보기
					// 상
					flag = true;
					for (int k = x - 1; k >= 0; k--) {
						if (copy[k][y]) {
							flag = false;
							break;
						}
					}
					if (flag && minLength > x) {
						d = 1;
						minLength = x;
					}
					flag = true;
					// 하
					for (int k = x + 1; k < n; k++) {
						if (copy[k][y]) {
							flag = false;
							break;
						}
					}
					if (flag && minLength > n - x - 1) {
						d = 2;
						minLength = n - x - 1;
					}
					flag = true;
					// 좌
					for (int k = y - 1; k >= 0; k--) {
						if (copy[x][k]) {
							flag = false;
							break;
						}
					}
					if (flag && minLength > y) {
						d = 3;
						minLength = y;
					}
					flag = true;
					// 우
					for (int k = y + 1; k < n; k++) {
						if (copy[x][k]) {
							flag = false;
							break;
						}
					}
					if (flag && minLength > n - y - 1) {
						d = 4;
						minLength = n - y - 1;
					}

					if (d == 1) {
						for (int k = x; k >= 0; k--) {
							copy[k][y] = true;
						}
						sum += x;
					} else if (d == 2) {
						for (int k = x; k < n; k++) {
							copy[k][y] = true;
						}
						sum += n - x - 1;
					} else if (d == 3) {
						for (int k = y; k >= 0; k--) {
							copy[x][k] = true;
						}
						sum += y;
					} else if (d == 4) {
						for (int k = y; k < n; k++) {
							copy[x][k] = true;
						}
						sum += n - y - 1;
					} else if (d == -1) {

						continue;
					}

					count++;

				}
				if (max < count) {
					max = count;
					min = sum;
				} else if (max == count) {
					min = Math.min(min, sum);
				}

			}
			sb.append('#').append(t).append(' ').append(min).append('\n');
		}
		System.out.println(sb);
	}
}