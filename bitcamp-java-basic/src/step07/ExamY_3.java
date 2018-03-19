// 메서드 분류 - 클래스 변수의 단점
package step07;

public class ExamY_3 {
    public static void main(String[] args) {
        // 클래스 변수는 오직 한 개만 존재하기 때문에
        // 동시에 여러 개의 작업을 분리하여 진행할 수 없다.
        
        // 다음 두 개의 식을 분리하여 계산해보자!
        // 식1) 2 + 3 -1 * 7 / =3 
        
        
        // 2 + 3 - 1 * 7 / 3 = ?
        // => 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
        Calculator2.plus(2);
        Calculator2.minus(3);
        Calculator2.minus(1);
        Calculator2.multiple(7);
        Calculator2.divide(2);
        
        System.out.printf("result = %d", Calculator2.result);
    }
}
// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
//    - 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 관련 메서드를 묶을 때
//    - 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.