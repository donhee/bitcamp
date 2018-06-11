package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Classroom;

public interface ClassroomService {
    List<Classroom> list(int pageNo, int pageSize);
    Classroom get(int no);
    int add(Classroom classroom);
    int update(Classroom classroom);
    int delete(int no);
}
