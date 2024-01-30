import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[][] ladder = new int[100][100];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result = 0;
		int x = 0, y = 0;
		for (int t = 1; t <= 10; t++) {
			int tmp = Integer.parseInt(br.readLine());

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());

					if (ladder[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}

			// [i][j] : i가 행 j가 열
			while (true) {
				x--;
				if (x == 0) {
					result = y;
					break;
				}
				if (y-1>=0 && ladder[x][y - 1] == 1) {
					while (y - 1 >= 0 && ladder[x][y - 1] == 1) {
						y--;
					}
				} else if (y+1 < 100 && ladder[x][y + 1] == 1) {
					while (y + 1 < 100 && ladder[x][y + 1] == 1) {
						y++;
					}
				}

			}

			System.out.printf("#%d %d\n", t, result);
		}
	}
}
