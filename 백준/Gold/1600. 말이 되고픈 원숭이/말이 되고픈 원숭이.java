import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 말의 움직임 => 두 칸 앞으로 후, 90도 방향으로 꺾어 L 모양이 되도록
 */
public class Main {
    
    static int k, w, h;
    static int[][] board;
    static int min = Integer.MAX_VALUE;
    static int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2}; //말이 이동할 수 있는 8방향
    static int[] hy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dx = {0, 1, 0 ,-1}; // 원숭이가 이동할 수 있는 4방향
    static int[] dy = {1, 0, -1, 0};
    static boolean[][][] visited;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scan = new Scanner(System.in);	
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st;
    
        
        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        board = new int[h][w];
        for(int i = 0; i < h; i++) {
        	st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) 
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        
        visited = new boolean[h][w][k + 1];
        min = bfs(0, 0);
        
        if(min == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(min);
    }
    
    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0, k)); 
        visited[x][y][k] = true;
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.x == h - 1 && now.y == w - 1) return now.count; 
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny][now.k] && board[nx][ny] == 0) {
                    visited[nx][ny][now.k] = true;
                    q.offer(new Node(nx, ny, now.count + 1, now.k));
                }
            }
            
            if(now.k > 0) {
                for(int i = 0; i < 8; i++) {
                    int nx = now.x + hx[i];
                    int ny = now.y + hy[i];
                    if(nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny][now.k - 1] && board[nx][ny] == 0) {
                        visited[nx][ny][now.k - 1] = true;
                        q.offer(new Node(nx, ny, now.count + 1, now.k - 1));
                    }
                }
            }
        }
        return min;
    }
    
    public static class Node {
        int x;
        int y;
        int count;
        int k;
        
        public Node(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }
}