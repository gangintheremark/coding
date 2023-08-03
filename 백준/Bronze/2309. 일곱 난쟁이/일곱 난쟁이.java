import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int[] arr = new int[9]; // 아홉 난쟁이
        for (int i = 0; i < 9; i++) {
            arr[i] = s.nextInt();
        }

        // brute force
        Arrays.sort(arr); // 오름차순 배열

        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                for (int k = j+1; k < 9; k++) {
                    for (int l = k+1; l < 9; l++) {
                        for (int m = l+1; m < 9; m++) {
                            for (int n = m+1; n < 9; n++) {
                                for (int o = n+1; o < 9; o++) {
                                    if(arr[o] + arr[n] + arr[m] + arr[l] + arr[k] + arr[j] + arr[i] == 100){
                                        System.out.println(arr[i]);
                                        System.out.println(arr[j]);
                                        System.out.println(arr[k]);
                                        System.out.println(arr[l]);
                                        System.out.println(arr[m]);
                                        System.out.println(arr[n]);
                                        System.out.println(arr[o]);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

