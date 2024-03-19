import java.io.*;
import java.util.*;

public class Main {
	static int n, m, result;
	static int[] arr;
	static boolean[] checked;
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			checked = new boolean[n + 1];
			result = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());

			}

			for (int i = 1; i <= n; i++) {
//				System.out.println(result);
				if (checked[i])
					continue;

				int count = 1;
				int start, index;
				start = index = i;
				checked[start] = true;
				if(index == arr[index]) continue;
				list.add(start);
				
				while (true) {

					int next = arr[index];

					if (next == arr[next] && !checked[next]) {
						result += list.size();
						checked[next] = true;
						break;
					}
					if (checked[next] && list.contains(next)) {
						result += list.indexOf(next);
						break;
					}

					if (checked[next]) {
						result += list.size();
						break;
					}
					checked[next] = true;

					if (next == start) {
						break;
					}

					list.add(next);
					index = next;
				}

				list.clear();
			}

			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}
}
