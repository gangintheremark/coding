import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int lastNBit = (1 << (n)) - 1; /// 111...1 (길이 n)
            if (lastNBit == (m & lastNBit))
                sb.append('#').append(tc).append(' ').append("ON").append('\n');
            else
                sb.append('#').append(tc).append(' ').append("OFF").append('\n');
        }

        System.out.println(sb);
    }
}