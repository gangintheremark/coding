import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int M = Integer.parseInt(br.readLine());
		boolean[] flag = new boolean[21];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("all")) {
				Arrays.fill(flag, true);
			} else if (cmd.equals("empty")) {
				Arrays.fill(flag, false);
			} else {
				int x = Integer.parseInt(st.nextToken());

				if (cmd.equals("add")) {
					flag[x] = true;
				} else if (cmd.equals("check")) {
					if (flag[x])
						sb.append(1).append('\n');
					else
						sb.append(0).append('\n');
				} else if (cmd.equals("remove")) {
					flag[x] = false;
				} else if (cmd.equals("toggle")) {
					if (flag[x]) {
						flag[x] = false;
					} else {
						flag[x] = true;
					}
				}
			}
		}
		System.out.println(sb);
	}

}
