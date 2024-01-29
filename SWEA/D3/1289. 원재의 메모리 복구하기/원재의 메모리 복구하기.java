import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String line = br.readLine();
			int count = (line.charAt(0) == '1') ? 1 : 0;

			for (int i = 1; i < line.length(); i++) {
				if(line.charAt(i-1) != line.charAt(i)) 
					count++;
			}

			System.out.printf("#%d %d\n", t, count);

		}
	}

}
