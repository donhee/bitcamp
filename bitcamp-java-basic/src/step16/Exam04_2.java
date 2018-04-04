// 파일 삭제
package step16;

import java.io.File;

public class Exam04_2 {
    public static void main(String[] args) throws Exception {

        // 1) 삭제할 파일의 경로 설정
        File file = new File("temp2/a/test.txt");
        if (file.delete()) { // 디렉토리 생성
            System.out.println("test.txt 파일을 삭제하였습니다.");
        } else {
            // 존재하지 않는 파일은 다시 삭제할 수 없다.
            // 경로가 존재하지 않으면 파일을삭제할 수 없다. 
            System.out.println("test.txt 파일을 삭제할 수 없습니다.");
        }
    }
}