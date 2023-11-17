import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            int n = s.nextInt();
            int m = s.nextInt();
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = s.nextInt();
                }
            }

            int max = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int sum = 0;
                    for (int l = j; l < n && l < m + j; l++) {
                        for (int o = k; o < n && o < m + k; o++) {
                            sum += arr[l][o];
                        }
                    }
                    if (max < sum) {
                        max = sum;
                    }
                }
            }

            System.out.println("#" + (i+1) + " " + max);
        }
    }
}


