import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] oil = new int[n - 1];
		int[] distance = new int[n - 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++)
			distance[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++)
			oil[i] = Integer.parseInt(st.nextToken());

		int result = 0;
		int dist = distance[0]; // 오일을 사고 이동할 거리
		int now = 0; // 오일을 살 도시
		/* 다음 도시가 나보다 오일값이 크다면 */
		for (int i = 1; i < n - 1; i++) {
			if (oil[i] > oil[i - 1]) {
				dist += distance[i];
			} else {
				result += oil[now] * dist;
				dist = distance[i];
				now = i;
			}
		}

		result += oil[now] * dist;

		System.out.println(result);
	}
}
