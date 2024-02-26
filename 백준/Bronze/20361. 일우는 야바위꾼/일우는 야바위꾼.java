import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			// a 종이컵과 b 종이컵을 바꾼다.
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// SWAP
			int tmp = arr[a];
			arr[a] = arr[b];
			arr[b] = tmp;
		}

		for (int i = 1; i <= n; i++) {
			if (arr[i] == x) {
				System.out.println(i);
				return;
			}

		}

	}

}
