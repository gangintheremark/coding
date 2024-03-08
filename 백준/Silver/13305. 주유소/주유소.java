import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long[] oil = new long[n - 1];
		long[] distance = new long[n - 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++)
			distance[i] = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++)
			oil[i] = Long.parseLong(st.nextToken());

		int result = 0;
		long dist = distance[0]; // 오일을 사고 이동할 거리
		long now = oil[0]; // 오일 가격
		/* 다음 도시가 나보다 오일값이 크다면 */
		for (int i = 1; i < n - 1; i++) {
			if (oil[i] > now) {
				dist += distance[i];
			} else {
				result += now * dist;
				dist = distance[i];
				now = oil[i];
			}
		}

		result += now * dist;

		System.out.println(result);
	}
}
