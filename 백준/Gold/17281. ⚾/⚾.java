import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 1 부터 9 까지 순열구하기
 */

public class Main {
	static int n, result;
	static boolean[] selected = new boolean[9];
	static int[][] state;
	static int[] order = new int[9];
	static boolean[] lu = new boolean[4];

	public static void permutation(int index) {

		if (index == 9) {
			play();
			return;
		}

		for (int i = 1; i < 9; i++) {
			if (index == 3) { // 이미 0번 선수 순서
				permutation(index + 1);
				return;
			} else if (!selected[i]) {
				order[index] = i;
				selected[i] = true;
				permutation(index + 1);
				selected[i] = false;
			}
		}

	}

	public static void play() {
		int out = 0, score = 0, num = 0;
		for (int i = 0; i < n; i++) {
			while (true) {
				if (out == 3) {
					Arrays.fill(lu, false);
					out = 0;
					break;
				}
				if (num >= 9)
					num %= 9;

				int hitter = order[num];

				if (state[i][hitter] == 0) {
					out++;
				} else if (state[i][hitter] == 1) {
					if (lu[3]) {
						score++;
						lu[3] = false;
					}
					if (lu[2]) {
						lu[3] = true;
						lu[2] = false;
					}
					if (lu[1]) {
						lu[2] = true;
					}
					lu[1] = true;
				} else if (state[i][hitter] == 2) {
					if (lu[3]) {
						score++;
						lu[3] = false;
					}
					if (lu[2]) {
						score++;
					}
					if (lu[1]) {
						lu[3] = true;
						lu[1] = false;
					}
					lu[2] = true;
				} else if (state[i][hitter] == 3) {
					if (lu[3]) {
						score++;
					}
					if (lu[2]) {
						score++;
						lu[2] = false;
					}
					if (lu[1]) {
						score++;
						lu[1] = false;
					}
					lu[3] = true;
				} else if (state[i][hitter] == 4) {
					if (lu[3]) {
						score++;
					}
					if (lu[2]) {
						score++;
					}
					if (lu[1]) {
						score++;
					}
					score++;
					Arrays.fill(lu, false);
				}
				num++;
			}
		}
		result = Math.max(result, score);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine()); // 이닝 수
		state = new int[n][9];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				state[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		selected[0] = true;
		permutation(0);
		System.out.println(result);
	}
}