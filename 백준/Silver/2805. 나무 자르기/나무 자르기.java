import java.util.Arrays;
import java.util.Scanner;

/*
    5  3  (5개의 마구간에 3마리 배치)
    1 2 8 4 9  (마구간의 좌표)

    구하고자 하는 것 : 두 말 사이의 최대거리
    최소 : lt = 1
    최대 : rt = arr[n-1]  (너무 세세하게 생각X. 그냥 가장 멀리 있는 좌표 선택)
    -> 답은 lt~rt 사이에 확실하게 있다.

    mid = (1+9)/2 = 5
    가장 가까운 두 말의 거리를 5라고 했을때 답이 가능한지 검증 -> 말의 배치 수를 count하는 함수 생성
    cnt  m 두 마리의 말만 배치할 수 있으므로 mid보다 더 작은 값이 되어야함 rt = mid -1
 */

class Main {

    public long count(int[] arr, int h) {
        long sum = 0; // 얻어갈 수 있는 나무 길이

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i] - h;
            if(x>0)
                sum += x;
        }
        return sum;
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 1;
        int rt = Arrays.stream(arr).max().getAsInt();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) == m) {
                answer = mid;
                break;
            }
            if (count(arr, mid) > m) { // 필요한 나무길이 m보다 길거나 같은 나무를 구했다면
                answer = mid;
                lt = mid + 1; // 높이의 최대값을 구하기 위해 절단기 높이를 더 높여보기
            } else rt = mid - 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); // 나무의 수
        int m = s.nextInt();  // 필요한 나무 길이

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) { // 각 나무의 길이
            arr[i] = s.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}

