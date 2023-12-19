import java.util.*;


public class CLOCKSYNC {

    static int[] clocks = new int[16];
    static int count;
    static int max_count = 30;
    static int[][] connect = {
            {0, 1, 2},
            {3, 7, 9, 11},
            {4, 10, 14, 15},
            {0, 4, 5, 6, 7},
            {6, 7, 8, 10, 12},
            {0, 2, 14, 15},
            {3, 14, 15},
            {4, 5, 7, 14, 15},
            {1, 2, 3, 4, 5},
            {3, 4, 5, 9, 13}
    };

    // 모든 시계가 12시를 가리키는지 체크
    public static boolean check() {
        for (int clock : clocks) {
            if (clock != 12) {
                return false;
            }
        }
        return true;
    }

    // 특정 스위치를 클릭하였을 때, 시계들의 시간
    public static void click(int s) { // s: switch
        for (int i : connect[s]) {
            if (clocks[i] == 12) {
                clocks[i] = 3;
            } else {
                clocks[i] += 3;
            }
        }
    }

    public static int solution(int s) {
        if (s == 10) {
            return check() ? 0 : max_count + 1;
        } else {
            for (int i = 0; i < 4; i++) { // 스위치를 누르는 횟수
                count = Math.min(count, i + solution(s + 1));
                click(s); // 스위치 클릭
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int C = s.nextInt();

        for (int t = 0; t < C; t++) {
            count = max_count;
            for (int i = 0; i < 16; i++) {
                clocks[i] = s.nextInt();
            }

            int answer = solution(0);

            if (answer >= max_count ) {
                System.out.println(-1);
            } else {
                System.out.println(answer);
            }
        }
    }
}