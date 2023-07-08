import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        int count = 0;
        Boolean pass = false;

        for (int i = 0; i < t; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            String str = s.next();
            int pointer = 0;
            pass = true;

            while (pointer != str.length()) {
                map.put(str.charAt(pointer), map.getOrDefault(str.charAt(pointer), 0) + 1); // 일단 map에 추가
                if (map.get(str.charAt(pointer)) == 1) { // map에 처음 추가 한 것이라면
                    pointer++;
                    if (pointer == str.length()) {
                        break;
                    }
                    while (str.charAt(pointer) == str.charAt(pointer - 1)) { // 연속된 키 값들 value값 ++
                        // 이 반복문이 돌아가는 이유 ? 연속된 값들을 이 반복문에서 추가. 그 후 똑같은 키 값이 나오면 false로 구분하기 위해서
                        map.put(str.charAt(pointer), map.get(str.charAt(pointer)) + 1);
                        pointer++;
                        if (pointer == str.length()) {
                            break;
                        }
                    }

                } else { // map에 처음 추가 한 것이 아니라면
                    pass = false;
                    break; // 끝내기
                }
            }
            if (pass) {
                count++;
            }
        }

        System.out.println(count);
    }
}

