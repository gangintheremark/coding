import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int N, diff = Integer.MAX_VALUE;
	static int[] S, B;

	public static void mix(int cnt, int s, int b) {
		if (cnt > N)
			return;
		if (cnt == N) {
			if (s == 1)
				return;
			diff = Math.min(diff, Math.abs(s - b));
			return;
		}
		if (s != 1 && diff > Math.abs(s - b)) {
			diff = Math.abs(s - b);

		}
		mix(cnt + 1, s * S[cnt], b + B[cnt]);
		mix(cnt + 1, s, b);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		S = new int[N];
		B = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}

		mix(0, 1, 0);

		System.out.println(diff);
	}
}