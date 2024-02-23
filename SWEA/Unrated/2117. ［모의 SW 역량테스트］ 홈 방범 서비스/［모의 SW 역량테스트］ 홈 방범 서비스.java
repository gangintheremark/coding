import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution {
    static int result;
    static boolean[][] board;
    static int n, m;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        List<int[]> list = new ArrayList<>();
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            list.clear();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            board = new boolean[n][n];
 
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    if (Integer.parseInt(st.nextToken()) == 1) list.add(new int[]{i, j});
                }
            }
 
            int count = 0;
            int max = 0;
 
            for (int k = 1; k <= n + 2; k++) {
                // 운영비용 구하기
                int work = k * k + (k - 1) * (k - 1);
 
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        count = 0;
 
                        for (int l = 0; l < list.size(); l++) {
                            int[] house = list.get(l);
 
                                if (Math.abs(house[0] - i) + Math.abs(house[1] - j) < k)
                                    count++;
 
                        }
 
                        int money = count * m - work;
 
                        if (money >= 0 && count > max) {
                            max = count;
                        }
 
                    }
                }
 
            }
            sb.append('#').append(t).append(' ').append(max).append('\n');
        }
        System.out.println(sb);
    }
}