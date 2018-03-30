package step12.ex05;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

public class Exam02_4 {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("bbb");
        String s3 = new String("ccc");
        String s4 = new String("ddd");
        String s5 = new String("eee");
         
        ArrayBlockingQueue queue = new ArrayBlockingQueue(100);
        queue.add(s1);
        queue.add(s2);
        queue.add(s3);
        queue.add(s4);
        queue.add(s5);
       
        Iterator 컬렉션에서값을꺼내주는객체 = queue.iterator();
        
        // => 값을 꺼내주는 객체를 통해 값을 꺼낸다.
        while (컬렉션에서값을꺼내주는객체.hasNext()) {
            // => 꺼낼 데이터가 있다면 값을 꺼내 달라고 명령한다.
            System.out.print(컬렉션에서값을꺼내주는객체.next() + ", ");
        }
        System.out.println();
    }
}
    


