// 내가 만든 소스 및 내부 클래스 사용
package step03.assignment;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {

        Scanner keyScan = new Scanner(System.in);

        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;
        }
        
        Score[] arr = new Score[3];
        
        for ( int i = 0; i < arr.length; i++){

            arr[i] = new Score();

            System.out.print("입력: ");
            arr[i].name = keyScan.next();
            arr[i].kor = keyScan.nextInt();
            arr[i].eng = keyScan.nextInt();
            arr[i].math = keyScan.nextInt();

            arr[i].sum = arr[i].kor + arr[i].eng + arr[i].math;
            arr[i].aver = arr[i].sum / 3;
        }

        System.out.println("-----------------------------");

        for ( int i = 0; i < arr.length; i++) {
            System.out.printf("%s %d %d %d %d %f\n", 
                arr[i].name, arr[i].kor, arr[i].eng, arr[i].math, arr[i].sum, arr[i].aver);
        }
        
    }
}
