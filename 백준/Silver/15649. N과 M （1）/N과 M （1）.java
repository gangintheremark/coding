import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static boolean[] isSelected;
	static int[] numbers;
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isSelected = new boolean[N + 1];
		numbers = new int[M];
		permutation(0);
		System.out.println(sb);

	}

	public static void permutation(int count) {
		if (count == M) {
			for (int num : numbers)
				sb.append(num).append(' ');

			sb.append('\n');
			return;
		}

		for (int i = 1; i <= N; ++i) {
			if (isSelected[i])
				continue;
			numbers[count] = i;
			isSelected[i] = true;
			permutation(count + 1);
			isSelected[i] = false;

		}
	}
}