import java.util.*;
import java.io.*;

public class Main {

    /*
    입국심사대 n개 m명의 사람들
    각 입국심사대마다 심사하는 시간이 다름
    바로 심사를 안받아도 됨
     */
    static long n, m;
    static Long[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        time = new Long[(int)n];
        long max = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            time[i] = Long.parseLong(br.readLine());
            max = Math.max(max, time[i]);
            min = Math.min(min, time[i]);
        }

        long left = min;
        long right = max * m;
        long mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;

            long count = 0;
            for (int i = 0; i < n; i++) {
                count += mid / time[i];
                
                if(count > m ) break;
            }

            if (count >= m) right = mid - 1;
            else left = mid + 1;
        }
        System.out.println(left);
    }

}

/*

7 10
3
8
3
6
9
2
4

8
 */
