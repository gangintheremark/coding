import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = 0;

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp >= N) {
				System.out.println(0);
				return;
			}
			arr[tmp]++;
			if (arr[tmp] > 2) {
				System.out.println(0);
				return;
			}
			max = Math.max(max, tmp);
		}

		int answer = 1;
		boolean flag = false;

		if (max == 0 && N > 2) {
			System.out.println(0);
			return;
		}

		if (max == 0 && N <= 2) {
			System.out.println(2);
			return;
		}
		
		int count = 0;

		for (int i = max; i >= 0; i--) {
			if(arr[i] == 2) {
				count++;
			}
		}
		if(count == max + 1) {
			System.out.println((int)Math.pow(2, N/2));
			return;
		}

		while (max >= 0) {
			if (arr[max] > 0) {
				if (flag && arr[max] < 2) {
					System.out.println(0);
					return;
				} else if (arr[max] == 2) {
					answer *= 2;
					flag = true;
				}
			} else {
				System.out.println(0);
				return;
			}
			max--;
		}

		System.out.println(answer * 2);

	}
}