import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int T, N;
	static Point[] points;
	static int[][] distance;
	static final int INF = (int) 1e9;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			points = new Point[N + 2];
			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			distance = new int[N + 2][N + 2];
			for (int i = 0; i < N + 1; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					distance[i][j] = distance[j][i] = INF;
					int dis = Math.abs(points[i].y - points[j].y) + Math.abs(points[i].x - points[j].x);
					if (dis <= 50 * 20)
						distance[i][j] = distance[j][i] = 1; // i에서 j까지 맥주마시면서 갈 수 있다면 1로 업데이트
				}
			}

			for (int k = 0; k < N + 2; k++) {
				for (int i = 0; i < N + 2; i++) {
					for (int j = 0; j < N + 2; j++) {
						distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]); // i->j 까지 직항 경로와 k를
																									// 거치는 경유 경로의 길이를 비
					}
				}
			}

			sb.append(distance[0][N + 1] != INF ? "happy" : "sad").append('\n');
		}
		System.out.println(sb);
	}

}