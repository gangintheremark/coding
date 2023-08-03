import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int k = s.nextInt(); // k 번째 지우는 수
        int count = 0; // 몇 번째로 지우는 지 count
        int[] arr = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (arr[j] == 0) continue;

                arr[j] = 0; // 지운다.
                count++;

                if (count == k) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}

