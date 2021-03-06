// java.util.ArrayList와 비교
package step12.ex01;

import java.util.ArrayList;

// 배열을 이용하여 컬렉션 클래스 만들기 : ArrayList
// => 단점: 배열의 크기가 고정되기 때문에 배열을 초과하여 값을 넣으려면 
//         더 큰 새 배열을 만들고, 기존 값을 복사해야 한다.
//         배열의 크기가 늘 때마다 가비지(garbage)가 생기는 문제가 있다.
//         기존 배열의 값을 복사하기 때문에 속도가 느린 문제도 있다.
public class Exam01_2 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("aaa"); // aaa
        list.add("bbb"); // aaa, bbb,
        list.add("ccc"); // aaa, bbb, ccc,
        list.add("ddd"); // aaa, bbb, ccc, ddd
        
        print(list); // aaa, bbb, ccc, ddd,
        
        list.remove(2);
        print(list); // aaa, bbb, ddd,
        
        list.remove(0);
        print(list); // bbb, ddd,
        
        // 유효한 인덱스가 아니면 예외 발생시킨다!
        //list.remove(4); // 실행 오류!
        print(list); // bbb, ddd,
        
        list.add(1, "xxx"); // bbb, xxx, ddd,
        list.add(1, "yyy"); // bbb, yyy, xxx, ddd,
        list.add(0, "zzz"); // zzz, bbb, yyy, xxx, ddd,
        list.add(5, "ttt"); // zzz, bbb, yyy, xxx, ddd,  5 index는 존재하지 않는 방이기 때문에 add메소드 실행x
        print(list);
        
        list.set(1, "aaa"); // zzz, aaa, yyy, xxx, ddd,
        print(list);
        
        list.add("ccc"); // zzz, aaa, yyy, xxx, ddd, ccc,
        list.add("eee"); // zzz, aaa, yyy, xxx, ddd, ccc, eee,
        print(list);
    }
    
    static void print(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}
