import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int n, m, k;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken()); // n명의 손님
			m = Integer.parseInt(st.nextToken()); // m초의 시간마다 k개의 붕어빵 생성
			k = Integer.parseInt(st.nextToken());

			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);
			boolean flag = true;

			int dessert = k;
			int time = m;
			int start = 0;
			while (time <= 11111 && flag) {
				for (int i = start; i < n && arr[i] <= time; i++) {
					start = i + 1;
					if (arr[i] < time || dessert == 0) {
						flag = false;
						break;
					}
					dessert--;
				}

				if (start == n && flag)
					break;

				time++;

				if (time % m == 0)
					dessert += k;

			}

			sb.append('#').append(t).append(' ').append(flag ? "Possible" : "Impossible").append('\n');
		}
		System.out.println(sb);
	}
}
