// IoC 컨테이너 만들기 - 의존 객체의 사용
package step19.ex08;

// 의존 객체(dependancy object)
// => 작업을 수행하기 위해 사용해야만 하는 객체
// => Car 클래스의 경우 Engine 클래스가 Car의 의존 객체이다.
// => Car의 move()를 실행하려면 Engine 객체가 있어야 한다.
//
// 의존 객체 준비
// => 일반적으로 의존 객체는 그 객체를 사용하는 측에서 생성한다.
// => 즉 Car 클래스에서 Engine 클래스를 사용하니까,
//    Car의 생성자에서 Engine 객체를 생성하였다.

public class Exam11 {
    public Exam11() {
        System.out.println("===> Exam11()");
    }
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        car.move();
    }
}

// 빈(bean)?
// => 인스턴스(instance), 객체(Object)와 같은 의미로 사용한다.
// => 다만 자바 문법에서 정한 나름의 규칙에 따라 만든 클래스의 인스턴스슬 얘기한다.
// => 그러나 현업에서는 인스턴스 또는 객체와 같은 의미로 사용한다.
// => bean = instance = Object
//
// 빈 컨테이너(bean container)?
// => 위의 ApplicationContext8 과 같이 인스턴스를 생성하고 보관하고 
//    필요할 때 리턴해주는 그런 역할을 하는 객체를 말한다.
// => 컨테이너는 객체의 '생성-실행-소멸' 즉 객체의 생명주기(Lifecycle)를 관리한다.
// => 대표적인 라이브러리가 "스프링 IoC 컨테이너" 이다.
//
// IoC 컨테이너(Inversion of Control 컨테이너)?
// => IoC 컨테이너 = 빈 컨테이너 + 의존 객체 자동 주입
// 
