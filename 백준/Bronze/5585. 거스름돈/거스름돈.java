import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = { 500, 100, 50, 10, 5, 1 };
		
		n = 1000 - n;
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += n/arr[i];
			n %= arr[i];
		}
		System.out.println(result);
	}

}
