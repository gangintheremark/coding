import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static int sum = 0, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sum = 0;
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 10; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                if (tmp % 2 == 1)
                    sum += tmp;
            }

            System.out.println("#" + (i+1) + " " + sum);
        }
    }
}
