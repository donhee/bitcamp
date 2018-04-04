// non-static nested class = inner class 객체 생성
package step17.ex03;

import step17.ex03.ArrayList.MyIterator;

public class Exam04 {
    
    public static void main(String[] args) {
    
        ArrayList list = new ArrayList();
        list.add("홍길동");
        list.add("홍길동2");
        list.add("홍길동3");
        
        // ArrayList가 보유한 inner 클래스의 객체를 얻는다.
        // list 객체가 MyIterator를 낳는다
        // 그래서 MyIterator는 list 객체를 알고 있다.
        
        // MyIterator를 통해 list에 저장된 값을 꺼내보자!
        MyIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
    }
}