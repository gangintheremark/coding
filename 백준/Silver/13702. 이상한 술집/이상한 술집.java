

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int count(long ml, int[] arr) {
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			long tmp = arr[i] / ml;
			if (tmp != 0)
				sum += tmp;
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		long answer = 0;

		long lt = 1;
		long rt = Arrays.stream(arr).max().getAsInt();

		while (lt <= rt) {
			long mid = (lt + rt) / 2; // 막걸리 용량

			if (count(mid, arr) >= K) {
				answer = mid;
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}

		}

		System.out.println(answer);

	}
}