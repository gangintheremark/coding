import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;

	public static boolean valid(int x, int y) {
		if (x >= 1 && x <= N && y >= 1 && y <= M)
			return true;
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<int[]> list = new ArrayList<int[]>();
		/*
		 * 별이 떨어지는 위치는 1
		 */

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		int count = 0;
		int max = 0;
		for (int[] s1 : list) {
			for (int[] s2 : list) {
				int x = s1[0];
				int y = s2[1];

				for (int[] s3 : list) {
					if (s3[0] >= x && s3[0] <= x + L && s3[1] >= y && s3[1] <= y + L) {
						count++;
					}
				}
				max = Math.max(max, count);
				count = 0;
			}
		}
		System.out.println(K - max);
	}
}
