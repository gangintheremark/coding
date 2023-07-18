import java.util.*;

class Main {
    public String recursion(Integer[] tmp) {
        Integer[] arr = tmp;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            temp.add((arr[i] + arr[i + 1]) % 10);
        }

        Integer[] arr2 = temp.toArray(new Integer[temp.size()]);
        if (arr2.length == 2) {
            String result ="";
            result += arr2[0];
            result += arr2[1];
            return result;
        }

        return recursion(arr2);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int[] alpha = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        String a = s.next();
        String b = s.next();

        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0, n = 0;

        while (a.length() > i || b.length() > i) { // 획수 ArrayList 이용하여 번갈아가며 추가
            if (a.length() > i)
                arr.add(alpha[a.charAt(i) - 'A']);

            if (a.length() > i)
                arr.add(alpha[b.charAt(i) - 'A']);
            i++;
        }
        Integer[] tmp = arr.toArray(new Integer[arr.size()]); // ArrayList -> 배열

        System.out.println(T.recursion(tmp));

    }
}

