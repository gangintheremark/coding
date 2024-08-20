import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        int total = (1 << 10) - 1;
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());

            int visited = 0;
            int count = 0;
            for (count = 1; ; count++) {
                char[] arr = String.valueOf(n * count).toCharArray();

                for (char c : arr) {
                    int num = c - '0';
                    visited |= (1 << num);
                }

                if (visited == total) break;
            }

            sb.append('#').append(tc).append(' ').append(n * count).append('\n');
        }
        System.out.println(sb);
    }
}
