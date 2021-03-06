// 예외 처리 문법을 적용하기 전 - 리턴 값을 이용한 오류 알림의 문제
package step21.ex01;

public class Exam01_3 {
    public static void main(String[] args) {
        int result = Calculator2.compute("#", 100, 200);
        
        // 예전에는 작업 실행중에 오류가 발생하면 희귀환 값을 리턴하여 알려줬다.
        if (result == -1212121212) {
            System.out.println("유효하지 않은 연산자입니다!");
        } else {
            System.out.println(result);
        }
        
        // 리턴 값을 검사하는 방식의 문제는 다음과 같이 정상적인 계산 결과도
        // 잘못된 계산으로 취급한다는 점이다.
        result = Calculator2.compute("-", 6, 7);
        
        // 위의 계산 결과는 정상적인 값이다.
        // 그런데도 불구하고 다음과 같이 -1을 리턴하는 경우 오류로 간주하기 때문에
        // 잘못된 결과를 출력하다.
        if (result == -1212121212) {
            System.out.println("유효하지 않은 연산자입니다!");
        } else {
            System.out.println(result);
        }
        
        // 아무리 희귀환 값을 리턴한다 하더라도 결국에는 그 희귀한 값 또한 
        // 정상 값일 수 있다. 이것은 해결할 수 없다.
        // => 다음 예는 계산 결과가 -1212121212 이다.
        // => 그런데도 유효하지 않은 연산이라고 처리한다.
        //    결국 리턴 값을 검사하여 오류 여부를 처리하는 것으로는
        //    이런 문제를 해결할 수 없다.
        result = Calculator2.compute("+", -2078654356, 866533144);
        if (result == -1212121212) {
            System.out.println("유효하지 않은 연산자입니다!");
        } else {
            System.out.println(result);
        }
        
        // 리턴 값으로 작업 오류를 알려줄 때 그 한계를 극복하기 위해 만든 문법이
        // "예외처리" 문법이다.
        // => 예외 상황이 발생했을 때 호출자에게 다른 방식의 예외 정보를 알려주는 문법이다.
    }
}
