import java.util.*;
import java.io.*;

public class Main {

	public static int fibo(int n) {
		if (n < 2)
			return n;
		return fibo(n - 1) + fibo(n - 2);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(n));
	}
}