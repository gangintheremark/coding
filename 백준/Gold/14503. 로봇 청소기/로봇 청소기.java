import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 파티에 진실을 아는 사람이 없으면 카운트
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int n, m;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] board;

    public static boolean isValid(int r, int c) {
        if (r != 0 && board[r - 1][c] == 0) {
            return true;
        } else if (r != n && board[r + 1][c] == 0) {
            return true;
        } else if (c != 0 && board[r][c - 1] == 0) {
            return true;
        } else if (c != m && board[r][c + 1] == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        while (true) {

            if (board[r][c] == 0) {
                board[r][c] = 2;
                result++;
            }

            // 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는 경우
            if (isValid(r, c)) {
                while (true) {
                    d = d - 1 == -1 ? 3 : d - 1;

                    // 앞 방향이 청소되었는지 체크
                    int nx = r + dx[d];
                    int ny = c + dy[d];

                    // 청소해야 하면
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == 0) {
                        r = nx;
                        c = ny;
                        break;
                    }
                }
            } else {
                // 후진 할 수 있는가
                int tmpd = d + 2 >= 4 ? d - 2 : d + 2;

                int nx = r + dx[tmpd];
                int ny = c + dy[tmpd];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] != 1) {
                    r = nx;
                    c = ny;
                    continue;
                } else {
                    break;
                }
            }

        }

        System.out.println(result);
    }
}