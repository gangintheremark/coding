import java.io.*;
import java.util.*;

class Grade implements Comparable<Grade> {
    String name;
    int kor;
    int eng;
    int math;

    public Grade(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Grade o) {
        if (this.kor == o.kor) {
            if (this.eng == o.eng) {
                if (this.math == o.math) {
                     return this.name.compareTo(o.name);
                } else {
                    return o.math - this.math;
                }
            } else {
                return this.eng - o.eng;
            }
        } else {
            return o.kor - this.kor;
        }
    }
}

class Main {
    public static void swap(String[] arr, int a, int b) {
        String tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        List<Grade> list = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            Grade grade = new Grade(name, kor, eng, math);
            list.add(grade);
        }

        Collections.sort(list);
        for (Grade g : list) {
            System.out.println(g.name);
        }
    }
}

