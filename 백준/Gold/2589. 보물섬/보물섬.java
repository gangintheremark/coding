import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        Point p;
        int count;

        public Node(Point p, int count) {
            this.p = p;
            this.count = count;
        }
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int n, m, result;
    private static char[][] board;
    private static boolean[][] visited;

    public static boolean isValid(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < n && ny < m) return true;
        return false;
    }

    public static int bfs(int x, int y) {
        int maxCount = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(new Point(x, y), 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.p.x + dx[i];
                int ny = node.p.y + dy[i];

                if (isValid(nx, ny) && board[nx][ny] == 'L' && !visited[nx][ny]) {
                    q.offer(new Node(new Point(nx, ny), node.count + 1));
                    visited[nx][ny] = true;
                    if (maxCount < node.count + 1) maxCount = node.count + 1;
                }
            }
        }

        return maxCount;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'L') {
                    int count = bfs(i, j);
                    if (result < count) result = count;
                    for (int k = 0; k < n; k++) {
                        Arrays.fill(visited[k], false);
                    }
                }
            }
        }
        System.out.println(result);
    }
}