import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[] numbers;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];
		permutation(0,1);

	}

	public static void permutation(int count, int start) {
		if (count == M) {
			for(int num : numbers) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= N; i++) {

			numbers[count] = i;
			permutation(count + 1, i + 1);
		}
	}
}