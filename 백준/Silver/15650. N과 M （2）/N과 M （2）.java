import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[] numbers;
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void permutation(int start, int count) {
		if (count == m) {
			for (int num : numbers)
				sb.append(num).append(' ');
			sb.append('\n');
			return;
		}

		for (int i = start; i <= n; i++) {
				numbers[count] = i;
				permutation(i + 1, count + 1);
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		numbers = new int[m];
		selected = new boolean[n + 1];

		permutation(1, 0);
		System.out.println(sb);
	}

}
