import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[n + 1]; // 그래프
		for (int i = 1; i <= n; i++)
			list[i] = new ArrayList<Integer>(); // 그래프 구현

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken())); // 비교 결과 입력
		}
		
		int[] in_degree = new int[n + 1]; // 진입 차수 배열
		for (int i = 1; i <= n; i++) // 각 정점의 진입 차수 구하기
			for (int j : list[i])
				in_degree[j]++;

		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= n; i++)
			if (in_degree[i] == 0) // 진입 차수가 0인 정점 스택에 삽입
				stack.add(i);

		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			sb.append(vertex).append(' ');

			for (int i : list[vertex]) {
				in_degree[i]--; // 이어진 정점의 진입 차수 줄이기
				if (in_degree[i] == 0) // 만약 진입 차수가 0이 되었다면
					stack.push(i); // 스택에 진입 차수가 0이 된 정점 삽입
			}
		}
		System.out.println(sb);
	}
}
