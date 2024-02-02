import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	static char[] open = { '(', '{', '[', '<' };
	static char[] close = { ')', '}', ']', '>' };

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		for (int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine());

			String str = br.readLine();

			int answer = 1;

			for (char c : str.toCharArray()) {
				for (int i = 0; i < 4; i++) {
					if (open[i] == c) {
						stack.push(i);
						break;
					}
					
					if(close[i] == c) {
						if(stack.peek() == i) {
							stack.pop();
							break;
						} else {
							answer = 0;
							break;
						}
					}
				}
				
				
			}

			sb.append("#" + t + " " + answer + "\n");

		}
		System.out.println(sb);
	}
}