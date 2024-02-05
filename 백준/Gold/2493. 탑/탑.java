import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
	int index;
	int height;
	
	public Top(int index, int height) {
		this.index = index;
		this.height = height;
	}
	
}
public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Top> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Top top = new Top(i + 1, Integer.parseInt(st.nextToken()));

			while (!stack.isEmpty()) {
				if(stack.peek().height < top.height) {
					stack.pop();
				} else {
					sb.append(stack.peek().index + " ");
					break;
				}
			}

			if (stack.isEmpty())
				sb.append(0 + " ");
			
			stack.push(top);
		

		}
		System.out.println(sb);
	}
}