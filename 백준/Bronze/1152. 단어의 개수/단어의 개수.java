import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str = s.nextLine();
        str = str.trim();
        if (str.length() == 0)
            System.out.println(0);
        else {
            String[] tmp = str.split(" ");
            System.out.println(tmp.length);
        }
    }
}