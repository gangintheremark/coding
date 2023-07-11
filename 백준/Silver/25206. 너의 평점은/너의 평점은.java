import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int sum = 0; // 학점의 총합 계산
        float myscore = 0; // 나의 총 학점 계산
        double score = 0; // 전공과목의 학점

        for (int i = 0; i < 20; i++) {
            String str = s.nextLine();
            String[] arr = str.split(" ");
            score = 0;
            if (arr[2].equals("P")) {
                continue; // P가 나오면 패스
            }

            sum += Double.valueOf(arr[1]);

            switch (arr[2]) {
                case "A+":
                    score = 4.5;
                    break;
                case "A0":
                    score = 4.0;
                    break;
                case "B+":
                    score = 3.5;
                    break;
                case "B0":
                    score = 3.0;
                    break;
                case "C+":
                    score = 2.5;
                    break;
                case "C0":
                    score = 2.0;
                    break;
                case "D+":
                    score = 1.5;
                    break;
                case "D0":
                    score = 1.0;
                    break;
                case "F":
                    score = 0.0;
                    break;
            }

            myscore += (score * Double.valueOf(arr[1]));
        }
        System.out.println(myscore / sum);
    }
}

