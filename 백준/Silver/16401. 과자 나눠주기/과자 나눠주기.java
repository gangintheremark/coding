import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 같은 길이의 막대과자
 * M 명의 조카 N개 과자, 막대과자의 최대 길이  
 */

public class Main {
	static int N, M;
	static int[] arr;

	public static int solution(int length) {
		int count = 0;
		for (int i : arr) {
			int tmp = i / length;
			if (tmp != 0) {
				count += tmp;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N];

		int answer = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int lt = 1;
		int rt = Arrays.stream(arr).max().getAsInt();

		while (lt <= rt) {
			int mid = (lt + rt) / 2;

			// mid 길이의 막대과자로 몇 명의 조카에게 줄 수 있는지
			if (solution(mid) >= M) {
				answer = mid;
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
		}

		System.out.println(answer);
	}
}