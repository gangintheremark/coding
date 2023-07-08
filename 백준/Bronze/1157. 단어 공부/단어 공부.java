import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        Character result = null;
        String str = s.next();
        str = str.toUpperCase();

        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Character key : map.keySet()) {

            if(count < map.get(key)){
                result = key;
                count = map.get(key);
            }
            else if( count == map.get(key)) {
                result = '?';

            }
           // System.out.println("key값: " + key + " value값: " + map.get(key));

        }
        System.out.println(result);
        
        

    }
}

