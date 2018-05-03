// 메서드 - 클로저 파라미터 III
package ex03

compute = { m -> // 파라미터 값으로 메서드를 받아 m에 저장
    m() // m에 저장된 메서드 호출
}

// compute를 호출할 때 파라미터로 메서드(클로저)를 넘긴다.
compute({println "안녕"})
println "------------------1"

compute({ // 파라미터가 없는 클로저이다.
    println "오호라"
    println "반가워!"})
println "------------------2"

// 메서드를 호출할 때 괄호() 생략할 수 있다.
compute {
    println "오호라"
    println "반가워!"
}