import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int result, n;
    static int[] chu;
    static boolean[] selected;
    static int[] numbers;

    static void dfs(int rw, int lw, int count) {
        if(rw > lw) return;
        if (count == n) {
            result++;
            return;
        }
        dfs(rw + numbers[count], lw , count+1);
        dfs(rw, lw + numbers[count], count+1);
    }

    static void perm(int count) {

        if(count == n) {
            dfs(0, numbers[0], 1);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!selected[i]) {
                selected[i] = true;
                numbers[count] = chu[i];
                perm(count+1);
                selected[i] = false;
            }

        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            chu = new int[n];
            selected = new boolean[n];
            numbers = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                chu[i] = Integer.parseInt(st.nextToken());

            perm(0);

            sb.append('#').append(t).append(' ').append(result).append('\n');
            result = 0;

        }
        System.out.println(sb);
    }
}