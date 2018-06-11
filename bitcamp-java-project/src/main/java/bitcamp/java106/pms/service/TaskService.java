// 서비스 컴포넌트 - 작업관리 업무를 처리할 객체
package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Task;

public interface TaskService {
    List<Task> list(String teamName, int pageNo, int pageSize);
    Task get(int no);
    int add(Task task);
    int update(Task task);
    int delete(int no);
}
