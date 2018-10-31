package step13.ex02;

public class LinkedList {
    
    protected class Bucket {
        public Object value; 
        public Bucket next;  
        public Bucket prev;  
    }

    protected Bucket head; 
    protected Bucket tail; 
    
    public LinkedList() {
        head = new Bucket();
        tail = head;
    }

    public void add(Object value) {
        // 맨 끝 객차에 짐을 싣는다.
        tail.value = value;
        
        // 새 객차를 만들어  맨 뒤에 붙인다
        Bucket bucket = new Bucket();
        tail.next = bucket;
        
        // 새 객차에 이전 객차의 주소를 저장한다.
        bucket.prev = tail;
        
        // 새로 붙인 객차를 맨 끝 객차로 처리한다
        tail = bucket;
        //this.size++;
    }

    public Object get(int i) {
        Bucket cursor = head;
        int count = 0;
        while (cursor != tail) { //cursor tail가 같으면 while문을 빠져나온다
            if (count == i)    // 0번째 객차면
                return cursor.value; // 그 value값 리턴
            count++; // count 증가
            cursor = cursor.next;  // cursor.next의 주소를 cursor로  // 2번째 객차로
        }
        return null;
    }
    
    public int size() { 
        Bucket cursor = head;
        int count = 0;
        while (cursor != tail) { //cursor tail가 같으면 while문을 빠져나온다
            count++; // count 증가
            cursor = cursor.next;  // cursor.next의 주소를 cursor로  // 2번째 객차로
        }
        return count;
    }
    
    public Object remove(int i) {
        Bucket cursor = head;

        if (i == 0) {
            if (head == tail)
                return null;
            else 
                head = head.next;
                head.prev = null;
                return cursor.value;
        }
        
        int count = 0;
        while (cursor != tail) { //cursor tail가 같으면 while문을 빠져나온다
            if (count == i) {   // 0번째 객차면
                cursor.prev.next = cursor.next;
                cursor.next.prev = cursor.prev;
                return cursor.value; // 그 value값 리턴
            
            }
            count++; // count 증가
            cursor = cursor.next;  // cursor.next의 주소를 cursor로  // 2번째 객차로
        }
        return null;
    }
    
    public void add(int i, Object value) {
        Bucket cursor = head;
        int count = 0;
        while (cursor != tail) { //cursor tail가 같으면 while문을 빠져나온다
            if (count == i) {  
                Bucket bucket = new Bucket();
                bucket.value = value;
                bucket.prev = cursor.prev;
                cursor.prev = bucket;
                bucket.next = cursor;
                if ( bucket.prev != null) {  
                    bucket.prev.next = bucket;
                } else { // 이전에 다른 객차가 없다면 이 객차를 head로 만든다.
                    head = bucket;
                }
                return;
            }
            count++; // count 증가
            cursor = cursor.next;  // cursor.next의 주소를 cursor로  // 2번째 객차로
        }
        // cursor가 맨 마지막 객차와 같으면    cursor == tail
        // 맨 뒤에 객차를 추가하려면!!
        if (count == i) { // 맨 끝에 값을 추가하는 것이다.
            add(value);
        }
       
    }
    
    
}
