// Stack : LIFO.   push()/pop()
                // 값을 넣을때, 값을 빼낼때
package step12.ex03;

import step12.ex02.LinkedList;

// 스택 사용의 예: 
// => 웹 브라우저의 history 다룰 때
// => 웹 사이트 breadcrumb navigaiton 구현할 때 
// => 웹 페이지 UI의 이벤트를 처리할 때
public class Stack extends LinkedList {
    // 값을 넣을때
    public void push(Object value) {
        this.add(value);
    }
    // 값을 빼낼때
    public Object pop() {
//        if (this.size() > 0) {
//        if (this.head != this.tail) {
        if (this.head == this.tail)
            return null;
        
        Bucket removedBucket = this.tail.prev;
        if (this.tail.prev.prev != null) { // 리스트에서 중간 버킷 제거할 때
            this.tail.prev.prev.next = tail;
            this.tail.prev = this.tail.prev.prev;
        } else { // 리스트에서 맨 처음 버킷을 제거할 때
            head = tail;
            head.prev = null;
            
        }
        return removedBucket.value;
        
    }
}
