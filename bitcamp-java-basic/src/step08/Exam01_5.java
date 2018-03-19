// 클래스 변수와 인스턴스 변수 응용
package step08;

public class Exam01_5 {
    static class Student {
        // 모든 인스턴스가 공유하는 값을 저장할 때는 클래스 변수로 선언한다.
        static int count;
        
        // 인스턴스마다 개별적으로 관리해야 할 값은 인스턴스 변수에 저장한다.
        String name;
        int age;
    }

    public static void main(String[] args) {
        Student.count = 0;
    
        Student s1 = new Student();
        s1.name = "홍길동";
        s1.age = 10;
        Student.count++;
        
        Student s2 = new Student();
        s2.name = "임꺽정";
        s2.age = 20;
        Student.count++;
        
        Student s3 = new Student();
        s3.name = "유관순";
        s3.age = 30;
        Student.count++;
        
        System.out.printf("%d, %s, %d\n", Student.count, s1.name, s1.age);
        System.out.printf("%d, %s, %d\n", Student.count, s2.name, s2.age);
        System.out.printf("%d, %s, %d\n", Student.count, s3.name, s3.age);
        
        
    }
}
