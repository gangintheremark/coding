import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 4 - 2, 5, 1, 7
 * [N][0~4] = 좋아하는친구 
 * 
 * 
 * 1. 주변에 좋아하는 학생이 가장 많은 칸
 * 2. 비어있는 칸이 가장 많은 칸
 * 3. 행 가장 작은 칸 , 열 가장 작은 칸
 * 
 * 
 * N 이 홀수면 첫 시작은 (N/2 + 1, N/2 + 1)
 * N 이 짝수면 (2,2)
 * 
 * 이중 for문을 통해  1. 비어있는칸이 가장 많은 칸 저장 2. 친구가 많이 있는칸 저장
 * 
 */
public class Main {
	static int N;
	static int[][] board;
	static int[][] friend;
	static int[] distX = { 0, -1, 1, 0 };
	static int[] distY = { -1, 0, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();

		board = new int[N + 1][N + 1];
		friend = new int[N * N + 1][4];

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int who = Integer.parseInt(st.nextToken());
			q.add(who);
			friend[who][0] = Integer.parseInt(st.nextToken());
			friend[who][1] = Integer.parseInt(st.nextToken());
			friend[who][2] = Integer.parseInt(st.nextToken());
			friend[who][3] = Integer.parseInt(st.nextToken());
		}

		board[2][2] = q.poll();

		boolean finalflag = false;

		while (!q.isEmpty()) {

			int who = q.poll(); // 자리에 앉힐 사람
			boolean flag = false; // 친구를 못찾음
			int dx = 0, dy = 0;
			int maxSpace = -1;
			int spaceCount = 0;
			int friendCount = 0;
			int maxFriend = -1;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// 이중 for문을 통해 1. 비어있는칸이 가장 많은 칸 저장 2. 친구가 많이 있는칸 저장
					// 좋아하는 친구를 발견할 때 까지는 인접한 공백이 많은 좌표 찾기
					if (board[i][j] != 0)
						continue;
					friendCount = 0;
					spaceCount = 0;
					for (int k = 0; k < 4; k++) {
						int nx = i + distX[k];
						int ny = j + distY[k];

						if (nx > 0 && ny > 0 && nx <= N && ny <= N) {
							if (board[nx][ny] == 0) {
								spaceCount++;
								continue;
							}
							if (board[nx][ny] == friend[who][0] || board[nx][ny] == friend[who][1]
									|| board[nx][ny] == friend[who][2] || board[nx][ny] == friend[who][3]) {
								friendCount++;
							}
						}
					}

					if (friendCount > maxFriend) {
						maxFriend = friendCount;
						maxSpace = spaceCount;
						dx = i;
						dy = j;

					} else if (friendCount == maxFriend && spaceCount > maxSpace) {
						maxSpace = spaceCount;
						dx = i;
						dy = j;
					}
				}
			}

			board[dx][dy] = who;

		}

		int sum = 0;
		// 만족도 구하기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int who = board[i][j];
				int count = 0;
				int temp = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + distX[k];
					int ny = j + distY[k];

					if (nx > 0 && ny > 0 && nx <= N && ny <= N) {

						if (board[nx][ny] == friend[who][0] || board[nx][ny] == friend[who][1]
								|| board[nx][ny] == friend[who][2] || board[nx][ny] == friend[who][3]) {
							count++;
						}
					}
				}

				if (count == 1) {
					temp = 1;
				} else if (count == 2) {
					temp = 10;
				} else if (count == 3) {
					temp = 100;
				} else if (count == 4) {
					temp = 1000;
				}

				sum += temp;
			}

		}
		System.out.println(sum);
	}
}