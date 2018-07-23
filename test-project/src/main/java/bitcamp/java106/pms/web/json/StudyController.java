package bitcamp.java106.pms.web.json;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.domain.Study;
import bitcamp.java106.pms.service.StudyService;

@RestController
@RequestMapping("/study")
public class StudyController {
    
    StudyService studyService;

    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    @RequestMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(Study study) throws Exception {
        studyService.add(study);
    }

    @RequestMapping("delete")
    //@ResponseStatus(HttpStatus.OK) // 응답 상태 코드 값의 default는 "200(OK)" 이다.
    public void delete(@RequestParam("no") int no) throws Exception {
        studyService.delete(no);
    }
    
    @RequestMapping("list{page}")
    public Object list(
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="4") int pageSize) {

        return studyService.list(pageNo, pageSize);
    }
    
    @RequestMapping("update")
    @ResponseStatus(HttpStatus.OK) // default값은 OK 이다.
    public void update(Study study) throws Exception {
        studyService.update(study);
    }
    
    @RequestMapping("{no}")
    public Study view(@PathVariable("no") int no) throws Exception {
        return studyService.get(no);
    }
    
    @RequestMapping("one")
    public int one() throws Exception {
        return studyService.getLimitOne();
    }
}

// ver 55 - JSON 데이터를 출력하는 페이지 컨트롤러 추가


