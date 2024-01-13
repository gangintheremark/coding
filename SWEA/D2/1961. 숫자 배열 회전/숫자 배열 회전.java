import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int t = 1;t <= T; t++) {
            int n = s.nextInt();
            int[][] a = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    a[i][j] = s.nextInt();
                }
            }
            System.out.println("#" + t + " ");
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(a[n-j-1][i]);
                }
                System.out.print(" ");
                for(int j = 0; j < n; j++) {
                    System.out.print(a[n-i-1][n-j-1]);
                }
                System.out.print(" ");
                for(int j = 0; j < n; j++) {
                    System.out.print(a[j][n-1-i]);
                }
                System.out.println();
            }
        }
    }
}