import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int count = 0;
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		for (int i = n - 1; i > 0; i--) {
			count += k / arr[i];
			k %= arr[i];
		}
		
		System.out.println(count + k);

	}
}
