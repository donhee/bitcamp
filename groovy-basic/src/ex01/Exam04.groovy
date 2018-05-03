// 맵
package ex01

scoreMap = ["국어":100,"영어":90,"수학":80]
println scoreMap["국어"]
println scoreMap.국어

// scoreMap1의 클래스를 알아내기
println scoreMap.getClass()

// 맵의 값 바꾸기
scoreMap.국어 = 1000
println scoreMap.국어

// 빈 맵 만들기
emptyMap = [:]
println emptyMap.getClass()


