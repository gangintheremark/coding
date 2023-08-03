import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int[] arr = new int[9]; // 아홉 난쟁이
        int sum  = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = s.nextInt();
            sum += arr[i];
        }

        // brute force
        Arrays.sort(arr); // 오름차순 배열
        int x =0, y=0;
        for(int a = 0; a<arr.length-1;a++){
            for(int b = a+1; b<arr.length;b++){
                if(sum - arr[a] - arr[b] == 100){
                    x = arr[a];
                    y = arr[b];
                    break;
                }
            }
        }
        for(int i : arr) {
            if(i == x || i == y)
                continue;
            System.out.println(i);
        }

    }
}

