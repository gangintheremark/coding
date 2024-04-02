import java.io.*;
import java.util.*;

public class Solution {
	static long n, r;
	static long p = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			long a = 1;
			long b = 1;

			long tmp = Math.min(r, n - r);

			for (int i = 0; i < tmp; i++) {
				a = a * (n - i) % p;
				b = b * (tmp - i) % p;
			}
			long ans = (a % p * div(b, p - 2) % p) % p;
			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}

	static long div(long a, long b) {
		if (b == 1)
			return a;
		long tmp = div(a, b / 2);
		if (b % 2 == 1)
			return tmp * tmp % p * a % p;
		else
			return tmp * tmp % p;
	}
}