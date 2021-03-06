// 메서드 - 파라미터 II
package ex03

printMap = { m ->
    for (e in m) {
        println e.key + "=" + e.value
    }
}

myMap = ["홍길동":20, "임꺽정":30, "유관순":16]

printMap(myMap)
println "----------1"

printMap(["홍길동":20, "임꺽정":30, "유관순":16])
println "----------2"

// 메서드를 호출할 때 괄호를 치지 않고 맵 객체를 넘길 때는 
// 맵의 대괄호 []를 제거해야 한다.
printMap "홍길동":20, "임꺽정":30, "유관순":16
println "----------3"

// key를 표현할 때는 따옴표를 붙이지 않아도 된다.
printMap 홍길동:20, 임꺽정:30, 유관순:16
println "----------4"