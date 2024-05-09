import java.util.*;
import java.io.*;

public class Main {
    static int n, m, t, result = Integer.MAX_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] board;
    static boolean[][][] visited;

    static class Node {
        int x, y, time;
        boolean hasSword;

        public Node(int x, int y, int time, boolean hasSword) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.hasSword = hasSword;
        }
    }

    public static boolean isValid(int nx, int ny) {
        if (nx > 0 && ny > 0 && nx <= n && ny <= m) return true;
        return false;
    }

    public static void bfs() {
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(1, 1, 0, false));
        visited[1][1][0] = true;
        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now.time > t) continue;

            if (now.x == n && now.y == m) {
                result = Math.min(result, now.time);
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(isValid(nx, ny) && !visited[nx][ny][now.hasSword?1:0]) {
                    if(now.hasSword) {
                        visited[nx][ny][1] = true;
                        dq.offer(new Node(nx, ny, now.time + 1, now.hasSword));
                    } else {
                        if (board[nx][ny] == 2) {
                            dq.offer(new Node(nx, ny, now.time + 1, true));
                            visited[nx][ny][1] = true;
                        } else if(board[nx][ny] == 0) {
                            visited[nx][ny][0] = true;
                            dq.offer(new Node(nx, ny, now.time + 1, now.hasSword));
                        }
                    }
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        board = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // (0,0) 부터 (n,m) 까지
        bfs();
        System.out.println(result == Integer.MAX_VALUE ? "Fail" :  result);
    }

}