// 메서드 : call by reference
package step06;

public class Exam03_2 {
    
    static void swap(int[] arr) {
        System.out.printf("swap(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
        System.out.printf("swap(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {100, 200};
        System.out.printf("main(2): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
        swap(arr); // 배열 인스턴스(메모리)를 넘기는 것이 아니다.
                   // 주소를 넘기는 것이다.
                   // 그래서 "call by reference" 라 부른다
        System.out.printf("main(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
    }
}
//
// call by value 
// => 자바에서는 primitive data type인 경우 메서드를 호출할 때
//    값을 넘긴다.
// => 자바에서는 primitive data type에 대해서 
//    메모리 주소를 넘기는 방법이 없다.
