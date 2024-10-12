import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m, r;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상 
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int point = (n > m ? m : n) / 2; // 회전시켜야 하는 그룹의 갯수

		for (int i = 0; i < r; i++) {
			rotate(point);
		}
		
		for(int i=0; i< n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void rotate(int point) {
		for (int t = 0; t < point; t++) {
			int x = t;
			int y = t;
			
			int tmp = map[x][y]; // 마지막에 넣을 값 빼놓기
			
			int d = 0; 
			while(d < 4) {
				// 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는 연산 수행
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				// 범위 안이라면
				if(nx < n - t && ny < m - t && nx >= t && ny >= t) {
					map[x][y] = map[nx][ny];
					x = nx;
					y = ny;
				} else {
					d++;
				}
			}
			map[t+1][t] = tmp;
		}
	}
}
