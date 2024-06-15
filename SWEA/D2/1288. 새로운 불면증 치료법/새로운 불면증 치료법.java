import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int total = (1 << 10) - 1; // 0부터 9까지 모든 숫자가 등장했을 때의 값
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());

            int visited = 0;
            int count = 0;

            for (count = 1; ; count++) {
                char[] arr = String.valueOf(n * count).toCharArray();

                for (char c : arr) {
                    int num = c - '0';
                    visited = visited | (1 << num); // 각 숫자에 대해 등장했음을 표시한다.
                }

                if (visited == total) break;
            }

            sb.append('#').append(tc).append(' ').append(n*count).append('\n');
        }

        System.out.println(sb);
    }
}