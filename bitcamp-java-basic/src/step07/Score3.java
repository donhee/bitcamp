//사용자 정의 데이터 타입 - 인스턴스 메서드
package step07;

public class Score3 {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;
   
    // 메서드를 이용하여 이 타입의 데이터를 다룰 수 있는 연산자를 정의한다.
    // => 사용자 정의 데이터 타입 입장에서는 메서드가 연산자 역할을 한다.
    // => 즉 사용자 정의 데이터 타입에 메서드를 정의하는 것은
    //    그 데이터를 다룰 연산자를 정의하는 것이다.
    
    // 다음 연산자는 계산을 수행할 때마다 인스턴스의 주소를 파라미터로 받아야 한다.
    public static void calculate(Score3 score) {
        score.sum = score.kor + score.eng + score.math;
        score.average = score.sum / 3f;
    }
}
