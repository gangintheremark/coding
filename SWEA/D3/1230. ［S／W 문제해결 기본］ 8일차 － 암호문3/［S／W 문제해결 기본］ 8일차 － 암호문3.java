import java.util.*;
import java.io.*;

public class Solution {

    static ArrayList<Integer> list;
    static StringTokenizer st;

    private static void command(char cmd, int x) {
        int y;
        switch (cmd) {
            case 'I':
                y = Integer.parseInt(st.nextToken());
                for (int i = 0, idx = x; i < y ; i++, idx++)
                    list.add(idx, Integer.parseInt(st.nextToken()));
                break;
            case 'D':
                y = Integer.parseInt(st.nextToken());
                for (int i = 0; i < y; i++)
                    list.remove(x);
                break;
            case 'A':
                for (int i = 0; i < x; i++)
                    list.add(Integer.parseInt(st.nextToken()));
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int cmdCount = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cmdCount; i++) {
                char cmd = st.nextToken().charAt(0);
                int x = Integer.parseInt(st.nextToken());
                command(cmd, x);
            }

            sb.append('#').append(tc);
            for (int i = 0; i < 10; i++) {
                sb.append(' ').append(list.get(i));
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}