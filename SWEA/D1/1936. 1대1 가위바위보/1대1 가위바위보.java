import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        byte a = Byte.parseByte(st.nextToken());
        byte b = Byte.parseByte(st.nextToken());

        if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2))
            System.out.println("A");
        else
            System.out.println("B");
    }
}
