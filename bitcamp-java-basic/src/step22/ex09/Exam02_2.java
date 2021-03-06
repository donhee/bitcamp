// java I/O API 사용하기 - ObjectOutputStream과 java.io.Serializable 인터페이스
package step22.ex09;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Exam02_2 {

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOut = new FileOutputStream("temp/test9_3.data");
        BufferedOutputStream bufOut = new BufferedOutputStream(fileOut);
        ObjectOutputStream out = new ObjectOutputStream(bufOut);
        // ObjectOutputStream을 사용하면 객체를 저장할 수 있지만 파일에 직접 연결할 수는 없다.
        // 그래서 보조 객체가 필요한 것이다.
        
        Member2 member = new Member2();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;
        
        out.writeObject(member);
        // Member2 클래스는 java.io.Serializable을 구현했기 때문에
        // 바이트 배열로 자동 변환하는 것이 가능하다.
        // 그래서 writeObject()를 호출하여 인스턴스의 값을 출력할 수 있다.
        //
        // writeObject()는 인스턴스의 값만 출력하는 것이 아니라,
        // 인스턴스의 클래스 이름과 인스턴스 변수의 타입 정보도 함께 출력한다.
        // 즉 출력데이터는 클래스이름 + 인스턴스 변수 정보 + 인스턴스 변수 값
        
        out.close();
        
        System.out.println("데이터 출력 완료!");

    }

}
//
// 용어 정리
// Serialize   : 객체        ===> 바이트 배열로 바꾸는것 (marshalling 이라고도 부른다)
// Deserialize : 바이트 배열 ===> 객체                   (unmarshalling 이라고도 부른다.)