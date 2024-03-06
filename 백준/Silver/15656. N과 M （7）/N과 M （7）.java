import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[] numbers, arr;
	static StringBuilder sb = new StringBuilder();

	public static void permutation(int count) {
		if (count == m) {
			for (int num : numbers)
				sb.append(num).append(' ');
			sb.append('\n');
			return;
		}

		for (int i = 0; i < n; i++) {
			numbers[count] = arr[i];
			permutation(count + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		numbers = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);
		permutation(0);
		System.out.println(sb);
	}

}
