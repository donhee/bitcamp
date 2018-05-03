// 메서드 - closure 클로저
package ex03

plus = {int a, int b -> 
    return a + b;
}

plus2 = {a, b ->
    a + b // return을 생략하면 마지막 문장의 실행 값이 리턴된다.
}

println plus(100, 200)
println plus2(100, 200)