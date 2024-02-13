import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int num = N;
		for (int x = 0; 3 * x <= N; x++) {
			for (int y = 0; 3 * x + 5 * y <= N; y++) {
				if (3 * x + 5 * y == N) {
					if (x + y < num)
						num = x + y;
				}
			}
		}
		
		if(num == N)
			System.out.println(-1);
		else
			System.out.println(num);
	}
}