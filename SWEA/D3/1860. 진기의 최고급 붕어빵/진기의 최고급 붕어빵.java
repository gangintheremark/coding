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

			for (int i = 0; i < n && flag; i++) {
				int dessert = (arr[i] / m) * k;
				if (dessert - i <= 0) flag = false;
				
			}

			sb.append('#').append(t).append(' ').append(flag ? "Possible" : "Impossible").append('\n');
		}
		System.out.println(sb);
	}
}