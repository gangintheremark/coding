import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int lastNBit = ( 1 << n ) - 1;

            sb.append('#').append(tc).append(' ').append(lastNBit == (m & lastNBit) ? "ON" : "OFF").append('\n');

        }
        System.out.println(sb);
    }
}
