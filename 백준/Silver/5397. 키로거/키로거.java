import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Character> password = new Stack<>();
		Stack<Character> temp = new Stack<>();
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			password.clear();
			temp.clear();

			for (char c : str.toCharArray()) {

				if (c == '<') {
					if (!password.isEmpty()) {
						temp.push(password.pop());
					}
				} else if (c == '>') {
					if (!temp.isEmpty()) {
						password.push(temp.pop());
					}
				} else if (c == '-') {
					if (!password.isEmpty()) {
						password.pop();
					}
				} else {
					password.push(c);
				}
			}

			while (!temp.isEmpty()) {
				password.push(temp.pop());
			}

			StringBuilder sb = new StringBuilder();

			while (!password.isEmpty()) {
				sb.append(password.pop());
			}

			sb.reverse();
			System.out.println(sb);
		}
	}
}