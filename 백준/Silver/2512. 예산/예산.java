import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public int count(int[] arr, int mid) {
        // mid(예산)을 각 지방마다 나눴을 때, 총액계산
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (mid < arr[i]) {
                sum += mid;
            } else sum += arr[i];
        }
        return sum;
    }

    public int solution(int[] arr, int total) {
        int answer = 0;
        int sumArr = Arrays.stream(arr).sum();

        if(sumArr <= total) {
            answer = Arrays.stream(arr).max().getAsInt();
            return answer;
        }
        int lt = 1;
        int rt = total;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int tmp = count(arr,mid);
            if (tmp <= total) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); // 지방 수

        int[] arr = new int[n]; // 각 지방의 예산요청
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int total = s.nextInt(); // 국가예산의 총 액

        System.out.println(T.solution(arr, total));
    }
}

