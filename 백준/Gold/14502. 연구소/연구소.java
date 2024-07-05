import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    /*
    n,m의 최대크기가 8 이므로 완전탐색 가능
    벽을 세우고 안전 영역 count 후 maxCount 찾기
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int n, m, result, safeZone, safeZoneCopy;
    private static int[][] board;
    private static int[][] boardCopy;
    private static ArrayList<Point> birus = new ArrayList<>();
    private static ArrayList<Point> empty = new ArrayList<>();
    private static ArrayList<Point> walls = new ArrayList<>();

    public static boolean isValid(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < n && ny < m) return true;
        return false;
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        for (Point p : birus) {
            q.offer(p);
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (isValid(nx, ny) && boardCopy[nx][ny] == 0) {
                    boardCopy[nx][ny] = 2;
                    safeZoneCopy--;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void copy() {
        for (int i = 0; i < n; i++) {
            boardCopy[i] = board[i].clone();
        }

        safeZoneCopy = safeZone - 3;
    }

    // empty 중 3개 뽑기
    public static void combi(int count) {
        if (count == 3) {
            copy();

            // 벽 세우기
            for (Point p : walls) {
                boardCopy[p.x][p.y] = 1;
            }

            // 바이러스
            bfs();

            if(result < safeZoneCopy) result = safeZoneCopy;
            return;
        }
        for (int i = 0; i < empty.size(); i++) {
            walls.add(new Point(empty.get(i).x, empty.get(i).y));
            combi(count + 1);
            walls.remove(walls.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        boardCopy = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    birus.add(new Point(i, j));
                } else if (board[i][j] == 0) {
                    empty.add(new Point(i, j));
                    safeZone++;
                }
            }
        }

        combi(0);

        System.out.println(result);
    }
}