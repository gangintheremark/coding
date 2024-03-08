import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[] numbers, arr;
	static boolean[] selected;
	static LinkedHashSet<String> list = new LinkedHashSet<>();


	public static void permutation(int start, int count) {
		if (count == m) {
			StringBuilder sb = new StringBuilder();
			for (int num : numbers)
				sb.append(num).append(' ');
			list.add(sb.toString());
			return;
		}

		for (int i = start; i < n; i++) {
			if (!selected[i]) {
				selected[i] = true;
				numbers[count] = arr[i];
				permutation(i + 1, count + 1);
				selected[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		numbers = new int[m];
		selected = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);
		permutation(0, 0);
		list.forEach(System.out::println);
	}

}
