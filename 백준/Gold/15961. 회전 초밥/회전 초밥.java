import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1 부터 9 까지 순열구하기
 */

public class Main {
	static int n, d, k, c, result;
	static int[] sushi;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sushi = new int[n + k - 1];
		for (int i = 0; i < n; i++)
			sushi[i] = Integer.parseInt(br.readLine());

		for (int i = 0; i < k - 1; i++) {
			sushi[n++] = sushi[i];
		}

		// 윈도우 초기화
		// 다양한 초밥을 먹을라한다.
		int[] eat = new int[d + 1];
		int count = 1; // 쿠폰사용
		eat[c]++;

		int start = 0;
		int end = k;
		for (int i = start; i < end; i++) {
			if (eat[sushi[i]] == 0)
				count++;
			eat[sushi[i]]++;
		}
		
		int max = count;
		for (int i = end; i < sushi.length; i++) {
			eat[sushi[start]] -= 1;
			
			if(eat[sushi[start]] == 0) max--;
			
			if(eat[sushi[i]] == 0) max++;
			eat[sushi[i]]++;
			
			result = Math.max(max, result);
			start++;
		}

		System.out.println(result);
	}
}