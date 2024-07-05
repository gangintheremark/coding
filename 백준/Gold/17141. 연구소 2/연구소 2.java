import java.awt.*;
import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int n, m, empty, wall, count, result;
    private static int INF = Integer.MAX_VALUE;
    private static int[][] board;
    private static int[][] boardCopy;
    private static ArrayList<Point> birus = new ArrayList<>();
    private static ArrayList<Point> noBirus = new ArrayList<>();
    private static ArrayList<Point> birusCopy = new ArrayList();

    static class Node {
        Point p;
        int time;

        public Node(Point p, int time) {
            this.p = p;
            this.time = time;
        }
    }

    public static int bfs() {
        int total = 0;
        Queue<Node> q = new LinkedList<>();
        for (Point p : birusCopy) {
            q.add(new Node(p, 0));
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            total = node.time;
            for (int i = 0; i < 4; i++) {
                int nx = node.p.x + dx[i];
                int ny = node.p.y + dy[i];

                if (isValid(nx, ny) && boardCopy[nx][ny] == 0) {
                    boardCopy[nx][ny] = 2;
                    q.add(new Node(new Point(nx, ny), node.time + 1));

                    count++;
                }
            }
        }
        return total;
    }

    public static boolean isValid(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < n && ny < n) return true;
        return false;
    }

    public static void copy() {
        for (int i = 0; i < n; i++) {
            boardCopy[i] = board[i].clone();
        }
        birusCopy.clear();
        for (int i = 0; i < birus.size(); i++) {
            birusCopy.add(birus.get(i));
        }
    }

    public static void combi(int index) {

        if (noBirus.size() == birus.size() - m) {
            copy();
            // 바이러스로 선택되지 못한 칸은 0으로
            for (Point p : noBirus) {
                birusCopy.remove(p);
                boardCopy[p.x][p.y] = 0;
            }

            // 바이러스 감염
            int time = bfs();
            if (count == empty && result > time) result = time;
            count = 0;
            return;
        }
        if (index >= birus.size()) return;

        noBirus.add(birus.get(index));
        combi(index + 1);
        noBirus.remove(noBirus.size()-1);
        combi(index + 1);



    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = INF;
        board = new int[n][n];
        boardCopy = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    birus.add(new Point(i, j));
                } else if (board[i][j] == 1) {
                    wall++;
                }
            }
        }
        empty = n * n - wall - m; // 빈 공간
        combi(0);
        System.out.println(result == INF ? -1 : result);

    }
}