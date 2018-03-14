// 흐름 제어문 - if ~ else 문
package step05;


public class Exam01_5 {
    public static void main(String[] args) {
        int age = 27;

        // else는 가장 가까운 if에 소속된다.
        // 들여쓰기에 속지 마라!
        if(age > 19) 
            if(age >= 70)
            System.out.println("지하철 무임 승차가능");
        else 
            System.out.println("미성년입니다.");
        
        System.out.println("---1---");
        // 어? 강사님, if 문에 블록을 사용하지 않으면
        // 오직 한 개의 문장만 온다고 했는데,
        // 위의 코드를 보면 if (age > 19) 안에
        // if 와 else 두 개의 문장이 있잖아요.
        // 그럼 컴파일 오류가 발생해야 되는 거 아닌가요?
        // => else문 if 없이 단독으로 사용할 수 없다.
        //    오직 if가 있어야만 사용할 수 있다.
        //    그래서 if ~ else ~ 는 한 문장으로 취급한다
        // 
        // => 그런 이유로, 위의 if (age >= 70) ~ else ~ 는 한 문장으로 간주한다
        //    굳이 다음과 같이 중괄호를 사용할 필요 없다.
        if(age > 19) {
            if(age >= 70)
                System.out.println("지하철 무임 승차가능");
            else 
                System.out.println("미성년입니다.");
        }
        System.out.println("---2---");
        //
        // 만약 else 문을 첫 번째 if 문에 소속되게 하고 싶다면
        // 다음과 같이 두 번째 if 문을 블록으로 묶어라!
        if (age >= 19) {
            if(age >= 70)
                System.out.println("지하철 무임 승차가능");
        }
            else 
                System.out.println("미성년입니다.");
        
        System.out.println("---3---");
    }
}