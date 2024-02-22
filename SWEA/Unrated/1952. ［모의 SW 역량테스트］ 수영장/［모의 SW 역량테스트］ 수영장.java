import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] year;
    static int result;
    static int[] price = new int[4];
    static int[] rest;

    public static void dfs(int m, int sum) {
        if (m == 13) {
            result = Math.min(result, sum);
            return;
        }

        if (rest[m] == 0) {
            dfs(m + 1, sum);
        } else {
            rest[m] = 0;
            dfs(m + 1, sum + price[0] * year[m]);
            rest[m] = year[m];

            rest[m] = 0;
            dfs(m + 1, sum + price[1]);
            rest[m] = year[m];

            for (int i = m; i < m + 3 && i <= 12; i++) {
                rest[i] = 0;
            }
            if (m+3>12) m=10;
            dfs(m + 3, sum + price[2]);
            for (int i = m; i < m + 3; i++) {
                rest[i] = year[i];
            }
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
       //  System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            year = new int[13];
            rest = new int[13];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++)
                price[i] = Integer.parseInt(st.nextToken());

            result = price[3];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                year[i] = Integer.parseInt(st.nextToken());
                rest[i] = year[i];
            }
            for (int i = 1; i <= 12; i++) {
                if (year[i] == 0) continue;

            }

            for (int i = 1; i <= 12; i++) {
                int sum  =0;
                if (year[i] == 0) continue;


            }

            dfs(1,0);

            sb.append('#').append(t).append(' ').append(result).append('\n');
        }
        System.out.println(sb);
    }
}