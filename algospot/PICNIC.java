import java.util.*;

public class PICNIC {

    static int n, m, count = 0;
    static boolean[][] friends; // 친구관계
    static boolean[] check; // 짝 유무

    public static void solution(int L) {
        int student = -1;

        if (L == n) {
            count++;
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (!check[i]) {
                    student = i;
                    break;
                }
            }

            for (int i = student + 1; i < n; i++) {
                if (!check[i] && friends[student][i]) {
                    check[student] = check[i] = true; // 짝 매치 성공~!
                    solution(L + 2);
                    check[student] = check[i] = false; // 짝 매치 X
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int C = s.nextInt();

        for (int i = 0; i < C; i++) {
            n = s.nextInt();
            m = s.nextInt();

            friends = new boolean[n][n];
            check = new boolean[n];
            count = 0;

            for (int j = 0; j < m; j++) {
                int a = s.nextInt(); // 학생 A
                int b = s.nextInt(); // 학생 B

                friends[a][b] = friends[b][a] = true;
            }

            solution(0);
            System.out.println(count);
        }
    }
}