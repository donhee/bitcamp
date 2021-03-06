// Wrapper 클래스 - wrapper 객체의 값 비교
package step10;

public class Exam02_3 {
    public static void main(String[] args) {
        Integer obj1 = new Integer(100);
        Integer obj2 = new Integer(200);
        if (obj1 == obj2) // 인스턴스 주소 비교
            System.out.println("obj1 == obj2");
        else
            System.out.println("obj1 != obj2");
        
        Integer obj3 = 100;
        Integer obj4 = 100;
        if (obj3 == obj4) // 인스턴스의 주소가 같다!
            System.out.println("obj3 == obj4");
        else
            System.out.println(obj3 != obj4);
        
        int i = 100;
        Integer obj5 = new Integer(100);
        if (i == obj5) // obj5의 auto-unboxing을 수행하여 int와 int를 비교한다.
            System.out.println("i == obj5");
        else
            System.out.println(i != obj5);
        
    }
}
