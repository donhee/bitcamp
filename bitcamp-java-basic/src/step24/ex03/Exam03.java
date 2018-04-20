// Thread를 상속 받기 - 익명 클래스로 구현하기
package step24.ex03;

public class Exam03 {
    public static void main(String[] args) {
        new Thread() {
            // 기존의 스레드에서 분리해서 새 스레드에서 실행하고픈 코드가 있다면,
            // run()메서드를 제정의하여 그 메서드에 해당 코드를 두어라
            @Override
            public void run() {
                // 별도로 분리해서 병행으로 실행할 코드를 두는 곳!
                for (int i = 0; i < 1000; i++) {
                    System.out.println("==> " + i);
                }
                
            }
        }.start();
        
        // "main" 스레드는 MyThread와 상관없이 병행하여 실행한다.
        for (int i = 0; i < 1000; i++) {
            System.out.println(">>> " + i);
        }
        
        
        
        
        
    }
}
