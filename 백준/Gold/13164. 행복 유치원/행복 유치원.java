import java.io.*;
import java.util.*;

public class Main {

	// N명의 원생들을 키 순서대로 줄 세우고 K개의 조로
	// 티셔츠 비용은 키 큰 원생 - 작은 원생
	// 티셔츠 만드는 비용을 최소로
	static int n, k;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 인접한 원생들끼리의 차이 구하기

		int tmp = arr[0];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i < n; i++) {
			pq.offer(arr[i] - tmp);
			tmp = arr[i];
		}

		int result = 0;
		// k-n 만큼 작은값 가져오기
		for (int i = 0; i < n - k; i++) {
			result += pq.poll();
		}

		System.out.println(result);
	}
}