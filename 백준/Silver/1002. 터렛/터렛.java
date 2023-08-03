import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);

        int T= s.nextInt();
        for (int i = 0; i < T; i++) {

            int x = s.nextInt();
            int y = s.nextInt();
            int r = s.nextInt();
            int x2 = s.nextInt();
            int y2 = s.nextInt();
            int r2 = s.nextInt();
            double dist = Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y2, 2)); // 두 점의 거리
            double diff = Math.abs(r - r2); // 반지름 차
            double sum = r + r2;

            int ans = 0;

            if (dist == 0 && diff == 0) {
                ans = -1;

            } else if (dist == diff || dist == sum) {
                ans = 1;

            } else if (dist > diff  && dist < sum) {
                ans = 2;

            }

            System.out.println(ans);
        }
    }
}

