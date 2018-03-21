// 인스턴스 메서드 클래스 메서드의 활용 - Math 클래스
package step09;

public class Exam02_3 {
    public static void main(String[] args) throws Exception{
        // Math 클래스는 수학 관련 메서드를 모아둔 클래스이다.
        // 전체 메서드가 "클래스 메서드=스태틱 메서드"이다.
        
        // abs() : 절대값 계산
        System.out.println(Math.abs(-200));
        
        // ceil() : 파라미터로 주어진 부동소수점이 바로 위 큰 정수 값을 리턴
        // floor() : 파라미터로 주어진 부동소수점의 바로 밑 작은 정수 값을 리턴
        System.out.println(Math.ceil(3.28)); // 4
        System.out.println(Math.floor(3.28)); // 3
        System.out.println(Math.ceil(-3.28)); // -3
        System.out.println(Math.floor(-3.28)); // -4
        
        // pow() : 2의 7승
        System.out.println(Math.pow(2, 7));

        // round() : 반올림
        System.out.println(Math.round(3.14));
        System.out.println(Math.round(3.54));
    }
}
