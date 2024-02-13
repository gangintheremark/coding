import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;
	private static int[] arr;
	private static int answer = Integer.MAX_VALUE;

	// 학생이 보석을 num개 씩 가진다고 가정할 떄, 몇 명에게 나눠줄 수 있는지?
	// N 보다 많으면 lt = mid + 1 , answer 할 필요 없
	// N 보다 적으면 rt = mid - 1
	// 보석을 2개(num)씩 3명(return)
	public static int solution(int num) {
		int index = 0;
		int count = 0;
		int rest = 0;
		int min = 0;
		while (index < M) {
			count += arr[index] / num;
			rest = arr[index] % num;

			// 보석이 남는 경우
			if (rest != 0) {
				count++;
				min = Math.min(rest, min);
			}

			index++;
		}

		if (count < N) {
			answer = Math.min(answer, num - 0);

		} else if (count == N) {
			answer = Math.min(answer, num - min);
		}

		return count;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		for (int i = 0; i < M; i++)
			arr[i] = Integer.parseInt(br.readLine());


		int lt = 1;
		int rt = Arrays.stream(arr).max().getAsInt();

		while (lt <= rt) {
			int mid = (lt + rt) / 2;

			if (solution(mid) > N) {
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
		}
		System.out.println(answer);

	}
}