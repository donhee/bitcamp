// 상속 - 상속하지 않고 기능 추가 II
package step11.ex3;

public class Exam01 {
    public static void main(String[] args) {
        // 방법 2) 기존 코드를 복사하여 새 클래스를 만든다.
        //        => 같은 일을 하는 여러 클래스가 존재하게 되면 관리하기가 힘들다
        //        => 만약 원본 코드에 버그가 있으면 버그도 복사하게 된다.
        //        => 따라서 버그를 고칠 때는 복사한 모든 소스파일을 찾아 고쳐야한다
        
        Car2 c = new Car2("비트자동차", "티코", 5, true, true);
        
    }
}
