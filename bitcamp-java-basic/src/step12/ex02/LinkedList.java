package step12.ex02;

public class LinkedList {
    
    // 값을 저장할 바구니 클래스를 만든다
    // 그 클래스는 LinkedList에서만 사용할 것이기 때문에
    // 일반적인 클래스인 패키지 멤버 클래스로 정의하지 않고
    // LinkedList 안에 정의한다. 
    // 이렇게 클래스 안에 정의된 클래스를 "중첩 클래스(nested class)" 또는
    // "내부 클래스(inner class)"라고 부른다.
    protected class Bucket {
        // 이 클래스의 역할은 기차에서 사람이나 물건을 싣는 객차의 역할을 수행한다.
        public Object value; // 이 변수에 값을 저장한다.
        public Bucket next;  // 이 변수에는 다음 객차 주소를 저장한다.
        public Bucket prev;  // 이 변수에는 이전 객체 주소를 저장한다.
        
    }


    protected Bucket head; // 리스트에서 맨 앞 객차의 주소를 저장하는 인스턴스 변수
    protected Bucket tail; // 리스트에서 맨 뒤 객차의 주소를 저장할 인스턴스 변수 
    //private int size = 0;
    
    public LinkedList() {
        // LinkedList를 만들면 일단 맨 앞에 있는 빈 객차를 준비한다.
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
