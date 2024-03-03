import java.io.*;
import java.util.*;

/*
 * 사용할 단어들을 미리 저장한 뒤, 해당 알파벳이 있는 숫자를 한 번씩만 누르면 가능한 여러 단어 중 사전에 저장된 단어를 찾아 입력 
 * 
 * 6666 3
 * tomo mono dak
 * 6666으로 만들 수 있는 단어는 mono
 * 
 * 52 2
 * ja la 
 * 5와 2로 만들 수 있는 단어는 ja, la 
 * 
 * phone[1][0] [1][1] [1][2]
 */
public class Solution {

	static int result;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			String number = st.nextToken();
			int n = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				String str = st.nextToken();
				boolean flag = false;
				for (int j = 0; j < str.length(); j++) {
					char c = str.charAt(j);
					char tmp = number.charAt(j);
					if (c == 'a' || c == 'b' || c == 'c' && tmp == '2') {
						flag = true;
					} else if ((c == 'd' || c == 'e' || c == 'f') && tmp == '3') {
						flag = true;
					} else if ((c == 'g' || c == 'h' || c == 'i') && tmp == '4') {
						flag = true;
					} else if ((c == 'j' || c == 'k' || c == 'l') && tmp == '5') {
						flag = true;
					} else if ((c == 'm' || c == 'n' || c == 'o') && tmp == '6') {
						flag = true;
					} else if ((c == 'p' || c == 'q' || c == 'r' || c == 's') && tmp == '7') {
						flag = true;
					} else if ((c == 't' || c == 'u' || c == 'v') && tmp == '8') {
						flag = true;
					} else if ((c == 'w' || c == 'x' || c == 'y' || c == 'z') && tmp == '9') {
						flag = true;
					} else {
						flag = false;
						break;
					}
				}

				if (flag)
					result++;

			}

			sb.append('#').append(t).append(' ').append(result).append('\n');
			result = 0;

		}
		System.out.println(sb);
	}
}