import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            int n = s.nextInt();
            int k = s.nextInt();
            int result = 0;
            int[][] arr = new int[n][n];
            int count = 0;
            int count2 = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    arr[j][l] = s.nextInt();
                }
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (arr[j][l] == 1) {
                        count++;
                        if (count == k) {
                            if (l + 1 < n && arr[j][l + 1] == 0) {
                                result++;
                                count = 0;
                            } else if (l + 1 == n) {
                                result++;
                                count = 0;
                            }

                        }
                    } else {
                        count = 0;
                    }

                    if (arr[l][j] == 1) {
                        count2++;
                        if (count2 == k) {
                            if (l + 1 < n && arr[l + 1][j] == 0) {
                                result++;
                                count2 = 0;
                            } else if (l + 1 == n) {
                                result++;
                                count2 = 0;
                            }
                        }
                    } else {
                        count2 = 0;
                    }
                }
                count = 0;
                count2 = 0;
            }

            System.out.println("#" + (i + 1) + " " + result);

        }
    }
}


