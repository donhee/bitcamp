package bitcamp.java106.pms.web.json;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.service.ClassroomService;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    
    ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @RequestMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(Classroom classroom) throws Exception {
        classroomService.add(classroom);
    }

    @RequestMapping("delete")
    //@ResponseStatus(HttpStatus.OK) // 응답 상태 코드 값의 default는 "200(OK)" 이다.
    public void delete(@RequestParam("no") int no) throws Exception {
        classroomService.delete(no);
    }
    
    @RequestMapping("list{page}")
    public Object list(
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="3") int pageSize) {

        return classroomService.list(pageNo, pageSize);
    }
    
    @RequestMapping("update")
    @ResponseStatus(HttpStatus.OK) // default값은 OK 이다.
    public void update(Classroom classroom) throws Exception {
        classroomService.update(classroom);
    }
    
    @RequestMapping("{no}")
    public Classroom view(@PathVariable("no") int no) throws Exception {
        return classroomService.get(no);
    }
    
}

// ver 55 - JSON 데이터를 출력하는 페이지 컨트롤러 추가


