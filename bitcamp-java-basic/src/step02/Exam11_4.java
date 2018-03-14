// 변수의 범위 - 변수와 블록
package step02;

public class Exam11_4 {
    public static void main(String[] args) {
        int a = 100;

        {
            //int a = 200; // 컴파일 오류!
                         // 메서드 안에서는 변수 이름 중복 불가!
            // 안쪽 블록에서는 바깥 블록의 변수를 사용할 수 있다.
            a = 200;

            int b = 300;
            // 이 블록의 실행을 끝내는 순간 
            // 이 블록에서 선언된 모든 변수는 제거된다.
            // 그래서 b 변수는 제거된다.
        }
        System.out.println(a);

        // 바깥 블록에서는 안쪽 블록의 변수를 사용할 수 없다.
        // 왜?
        // 안쪽 블록의 실행이 끝나면, 안쪽 블록에서 선언된 모든 변수들이
        // 자동으로 제거된다.
        //System.out.println(b); // 컴파일 오류!

        {
            // 이전 블록에서 선언된 변수는 그 블록이 종료되는 순간 
            // 제거되기 때문에, 
            // 다음과 같이 같은 이름의 변수를 선언할 수 있다.
            int b = 400;
            System.out.println(b);
        }
        // System.out.println(b); // cannot find symbol 컴파일 오류!
    }
}

