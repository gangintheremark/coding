import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		HashMap<String, String> map = new HashMap<>();
		int N = Integer.parseInt(st.nextToken()); // 주소의 수
		int M = Integer.parseInt(st.nextToken()); // 찾으려는 주소의 수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			String key = br.readLine();
			sb.append(map.get(key)).append('\n');
		}
		System.out.println(sb);
	}

}
