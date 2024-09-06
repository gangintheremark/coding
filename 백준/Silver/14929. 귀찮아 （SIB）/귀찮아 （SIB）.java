import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        long squareSum = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            sum += tmp;
            squareSum += tmp * tmp;
        }

        long result = (sum * sum - squareSum) / 2;
        System.out.println(result);

    }
}