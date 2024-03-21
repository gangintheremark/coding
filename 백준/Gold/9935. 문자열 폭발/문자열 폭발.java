import java.io.*;
import java.util.*;

public class Main {

    //mirkovC4nizCC44
    //C4

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        Stack<Character> tmp = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (!stack.isEmpty() && stack.peek() == bomb.charAt(bomb.length() - 1)) {
                int j;
                for (j = bomb.length() - 1; j >= 0; j--) {
                    if (!stack.isEmpty() && stack.peek() == bomb.charAt(j)) {
                        tmp.push(stack.pop());
                    } else break;
                }
                if (j >= 0) {
                    while (!tmp.isEmpty()) {
                        stack.push(tmp.pop());
                    }
                }
                tmp.clear();
            }


        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb.reverse());
    }
}

