import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[] numbers, arr;
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void permutation(int count) {
		if (count == m) {
			for (int num : numbers)
				sb.append(num).append(' ');
			sb.append('\n');
			return;
		}

		for (int i = 0; i < n; i++) {
			if(!selected[i]) {
				numbers[count] = arr[i];
				selected[i] = true;
				permutation(count + 1);
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
		permutation(0);
		System.out.println(sb);
	}

}
