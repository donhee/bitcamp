// groovy 실행 원리
package ex01

// 블록 바깥에 그냥 작성하는 코드는 Exam01의 run() 메서드 안에 들어간다.
// => Exam01의 main() 메서드에서 run()을 호출한다.
println "Hello"

// Exam01 클래스에 메서드로 정의된다.
def plus(x, y) {
    x + y
}

sum = plus(10,20)

println sum