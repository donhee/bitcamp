package bitcamp.java106.pms.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;

@Controller
@RequestMapping("/classroom")
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
    
    // GlobalBindingInitializer 클래스에 등록했기 때문에 따로 설정할 필요가 없다.
    /*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                java.sql.Date.class, 
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        this.setValue(java.sql.Date.valueOf(text));
                    }
                });
    }
    */
    
}
// ver 51 - Spring WebMVC 
//ver 40 - 필터 적용  request.setCharacterEncoding("UTF-8"); 제거
// ver 37 - 컨트롤러를 서블릿으로 변경