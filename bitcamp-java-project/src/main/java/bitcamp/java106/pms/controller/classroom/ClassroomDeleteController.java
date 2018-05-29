package bitcamp.java106.pms.controller.classroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.ClassroomDao;

@Component("/classroom/delete")
public class ClassroomDeleteController implements PageController {
    ClassroomDao classroomDao;
    
    public ClassroomDeleteController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        int no = Integer.parseInt(request.getParameter("no"));
        int count = classroomDao.delete(no);
        
        if (count == 0) {
            throw new Exception("해당 강의가 없습니다.");
        } 
        
        return "redirect:list.do";
            
    }
    
}
// ver 45 - 프론트 컨트롤러 적용

//ver 23 - @Component 애노테이션을 붙인다. ClassroomDao를 받도록 생성자 변경.
//ver 22 - ClassroomDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 20 - 클래스 추가
