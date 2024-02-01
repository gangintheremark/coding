import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	static int S, P;
	static int[] myCount = new int[4];
	static int[] checkCount = new int[4];

	/*
	 * 0: A 1: C 2: G 3: T
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		String str = br.readLine();
		st = new StringTokenizer(br.readLine());

		int result = 0;

		for (int i = 0; i < 4; i++) {
			checkCount[i] = Integer.parseInt(st.nextToken());
		}

		// 윈도우 초기값 설정
		for (int i = 0; i < P; i++) {
			char c = str.charAt(i);

			find(c, 1);
		}

		if (check())
			result++;

		int left = 0;
		int right = P;

		while (right < S) {
			char l = str.charAt(left++);
			char r = str.charAt(right++);

			find(l, -1);
			find(r, 1);

			if (check())
				result++;

		}
		System.out.println(result);
	}

	public static void find(char c, int index) {
		if (c == 'A')
			myCount[0] += index;
		else if (c == 'C')
			myCount[1] += index;
		else if (c == 'G')
			myCount[2] += index;
		else if (c == 'T')
			myCount[3] += index;
	}

	public static boolean check() {
		for (int i = 0; i < 4; i++) {
			if (myCount[i] < checkCount[i])
				return false;
		}
		return true;
	}
}
