// Queue : FIFO
package step12.ex04;

import step12.ex02.LinkedList;

// Queue 사용의 예 : 먼저 들어온거 먼저 처리
// => 인터넷 예약 처리할 때
// => single-thread 기반 node 서버의 요청처리
// => 마우스 또는 키보드 이벤트 처리(이벤트가 발생된 순서대로 처리)
public class Queue extends LinkedList {
    // 맨 뒤에 값을 붙인다.
    public void offer(Object value) {
        this.add(value);
    } 
    // 맨 앞의 값을 꺼낸다
    public Object poll() {
        return this.remove(0);
    }
}
