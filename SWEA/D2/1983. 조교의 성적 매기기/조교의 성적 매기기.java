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
            double[] scores = new double[n];
            double k_score = 0;
            int max = n / 10;
            for (int j = 0; j < n; j++) {
                int a = s.nextInt();
                int b = s.nextInt();
                int c = s.nextInt();

                scores[j] = a * 0.35 + b * 0.45 + c * 0.2;

                if (j+1 == k) {
                    k_score = scores[j];
                }
            }

            Arrays.sort(scores);

            int c;
            for (int j = 0; j < n; j++) {
                if (k_score == scores[j]) {
                    c = j / max;

                    if (c == 9) {
                        System.out.println("#" + (i + 1) + " " + "A+");
                        break;
                    } else if (c == 8) {
                        System.out.println("#" + (i + 1) + " " + "A0");
                        break;
                    } else if (c == 7) {
                        System.out.println("#" + (i + 1) + " " + "A-");
                        break;
                    } else if (c == 6) {
                        System.out.println("#" + (i + 1) + " " + "B+");
                        break;
                    } else if (c == 5) {
                        System.out.println("#" + (i + 1) + " " + "B0");
                        break;
                    } else if (c == 4) {
                        System.out.println("#" + (i + 1) + " " + "B-");
                        break;
                    } else if (c == 3) {
                        System.out.println("#" + (i + 1) + " " + "C+");
                        break;
                    } else if (c == 2) {
                        System.out.println("#" + (i + 1) + " " + "C0");
                        break;
                    } else if (c == 1) {
                        System.out.println("#" + (i + 1) + " " + "C-");
                        break;
                    } else if (c == 0) {
                        System.out.println("#" + (i + 1) + " " + "D0");
                        break;
                    }
                }
            }


        }
    }
}


