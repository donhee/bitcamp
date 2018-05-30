package bitcamp.java106.pms.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;

@Component("/classroom")
public class ClassroomController{
    ClassroomDao classroomDao;
    
    public ClassroomController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @RequestMapping("/add")
    public String add(Classroom classroom) throws Exception {
        
        classroomDao.insert(classroom);
        return "redirect:list.do";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        
        int count = classroomDao.delete(no);
        if (count == 0) {
            throw new Exception("해당 강의가 없습니다.");
        } 
        
        return "redirect:list.do";
    }
    
    @RequestMapping("/list")
    public String list(Map<String,Object> map) throws Exception {
        
        List<Classroom> list = classroomDao.selectList();
        map.put("list", list);

        return "/classroom/list.jsp";
    }
    
    @RequestMapping("/update")
    public String update(Classroom classroom) throws Exception {
        
        int count = classroomDao.update(classroom);
        if (count == 0) {
            throw new Exception("해당 강의가 존재하지 않습니다.");
        } 

        return "redirect:list.do";
    }
    
    @RequestMapping("/view")
    public String view(@RequestParam("no") int no, Map<String,Object> map) throws Exception {

        Classroom classroom = classroomDao.selectOne(no);

        if (classroom == null) {
            throw new Exception("유효하지 않은 팀입니다.");
        }
        map.put("classroom", classroom);

        return "/classroom/view.jsp";
    }
    
}
//ver 40 - 필터 적용  request.setCharacterEncoding("UTF-8"); 제거
// ver 37 - 컨트롤러를 서블릿으로 변경