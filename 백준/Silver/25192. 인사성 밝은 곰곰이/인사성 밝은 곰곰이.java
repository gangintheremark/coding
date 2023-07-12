import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        HashMap<String, Integer> map = new HashMap<>();

        int T = Integer.parseInt((br.readLine()));
        int count = 0;

        for (int i = 0; i < T; i++) {
            String str = br.readLine();

            if(str.equals("ENTER")) {
                // 맵 초기화
                map.clear();
                continue;
            }

            map.put(str, map.getOrDefault(str, 0) + 1); // map에 입력

            // 첫 채팅인가?
            if(map.get(str) == 1) { // 첫 채팅일 때
                count++;
            }
        }
        System.out.println(count);
    }
}

