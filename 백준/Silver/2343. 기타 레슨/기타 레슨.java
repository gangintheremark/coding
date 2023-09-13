import java.util.Arrays;
import java.util.Scanner;

class Main {

    public long count(int[] arr, long length) {
        // 블루레이 크기가 length 일 때, 찍어낼 수 있는 블루레이 수
        int c = 1;
        long sum = 0;
        for (int x : arr) {
            if (sum + x > length) {
                c++;
                sum = x;
            } else sum += x;
        }
        return c;
    }

    public long solution(int m, int[] arr) {
        long answer = 0;
        long lt = Arrays.stream(arr).max().getAsInt();
        long rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); // 강의 수
        int m = s.nextInt(); // 블루레이 수

        int[] arr = new int[n]; // 각 강의 길이
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println(T.solution(m, arr));
    }
}

