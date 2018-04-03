package bitcamp.java106.pms.dao;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class AbstractDao<E> {
    // 서브 클래스에서 상속 받는 의미로 접근 범위를 protected로 하였다.
    protected LinkedList<E> collection = new LinkedList<>();
    
    public void insert(E value) {
        collection.add(value);
    }
    
    public Iterator<E> list() {
        return collection.iterator();
    }
    
    public E get(Object key) {
        int index = this.indexOf(key);
        if (index == -1)
            return null;
        return collection.get(index);
    }

    // 규칙을 바꿈. index도 받게 했다.
    public void update(int index, E value) {
        collection.set(index, value);
    }
    
    public void delete(Object key) {
        int index = this.indexOf(key);
        if (index == -1)
            return;
        collection.remove(index);
    }

    // 서브 클래스를 만들 때 반드시 다음 메서드를 정의할 것을 강제한다.
    // 왜냐하면 다음 메서드는 get(), update(), delete()에서 사용하기 때문에
    // 반드시 정의되어 있어야 한다.
    public abstract int indexOf(Object key);
    // 정리하자면 
    // 이 메서드는 board 같은 경우는 해당 index 번호로 찾지만,
    // team이나 member같은 경우는 String 값으로 찾기 때문에 
    // 각 서브 클래스에서 재정의 할 것을 강제하는 것을 의미한다

}
