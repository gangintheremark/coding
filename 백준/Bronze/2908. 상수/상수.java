import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        StringBuilder n1 = new StringBuilder(s.next());
        StringBuilder n2 = new StringBuilder(s.next());

        int a = Integer.valueOf(n1.reverse().toString());
        int b = Integer.valueOf(n2.reverse().toString());

        if (a > b)
            System.out.println(a);
        else
            System.out.println(b);
    }
}