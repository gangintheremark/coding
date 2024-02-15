import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public static int solution(int money) {
        int count = 0;
        int have = money;
        for (int i = 0; i < N; i++) {
            if (arr[i] > have) {
                if (money < arr[i]) return -1;
                have = money;
                count++;
                i--;
                continue;
            } else
                have -= arr[i];
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        // N일 동안 M 번만 인출하는데 필요한 최소 금액 K

        int min=Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int answer = Integer.MAX_VALUE;
        int lt = min;
        int rt = max * N;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            // mid 원으로 N일 동안 몇 번 인출해야 하는지

            int tmp = solution(mid);
            if (tmp >= M || tmp == -1) {
                lt = mid + 1;
                if (tmp != -1)
                    answer = Math.min(answer, lt);
            } else
                rt = mid - 1;
        }

        System.out.println(lt);


    }
}