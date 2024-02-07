import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, max = 0;
	static int[] s;
	static int[] w;

	// a와 b 인덱스의 계란을 깰 때,
	public static void hit(int a, int b) {
		s[a] -= w[b];
		s[b] -= w[a];
	}

	public static void back(int a, int b) {
		s[a] += w[b];
		s[b] += w[a];
	}

	public static void recur(int index, int count) { // 손에 든 계란 index와 깬 계란 개수 count
		// 기저사례) 마지막 index의 계란이거나 모든 계란이 깨졌거나
		if (index >= N || (count == N - 1 && index == N - 1) || count == N) {
//			System.out.println(count);
			max = Math.max(max, count);
			return;
		}

		if (s[index] <= 0)
			recur(index + 1, count);

		for (int i = 0; i < N; i++) {
			if (i == N - 1 && count == N - 1)
				recur(i, count);
			if (index == i)
				continue; // 손에 든 계란과 같은 계란이면 패쓰
			if (s[i] <= 0 || s[index] <= 0)
				continue; // 이미 깨진 계란이면 패쓰

			hit(i, index);

			if (s[i] <= 0 && s[index] <= 0) {
				recur(index + 1, count + 2);
			} else if ((s[i] <= 0 && s[index] > 0) || (s[i] > 0 && s[index] <= 0)) {
				recur(index + 1, count + 1);

			} else {
				recur(index + 1, count);
			}
			back(i, index);
		}

		if (index == N || count == N) {
			System.out.println(count);
			max = Math.max(max, count);
			return;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		s = new int[N];
		w = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			w[i] = Integer.parseInt(st.nextToken());
		}

		recur(0, 0);

		System.out.println(max);

	}
}