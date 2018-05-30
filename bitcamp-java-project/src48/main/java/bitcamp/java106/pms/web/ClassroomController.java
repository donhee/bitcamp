package bitcamp.java106.pms.web;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/classroom")
public class ClassroomController{
    ClassroomDao classroomDao;
    
    public ClassroomController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Classroom classroom = new Classroom();
        classroom.setTitle(request.getParameter("title"));
        classroom.setStartDate(Date.valueOf(request.getParameter("startDate")));
        classroom.setEndDate(Date.valueOf(request.getParameter("endDate")));
        classroom.setRoom(request.getParameter("room"));
        classroomDao.insert(classroom);
        
        return "redirect:list.do";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        int no = Integer.parseInt(request.getParameter("no"));
        int count = classroomDao.delete(no);
        
        if (count == 0) {
            throw new Exception("해당 강의가 없습니다.");
        } 
        
        return "redirect:list.do";
    }
    
    @RequestMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        List<Classroom> list = classroomDao.selectList();
        request.setAttribute("list", list);

        return "/classroom/list.jsp";
    }
    
    @RequestMapping("/update")
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Classroom classroom = new Classroom();
        classroom.setNo(Integer.parseInt(request.getParameter("no")));
        classroom.setTitle(request.getParameter("title"));
        classroom.setStartDate(Date.valueOf(request.getParameter("startDate")));
        classroom.setEndDate(Date.valueOf(request.getParameter("endDate")));
        classroom.setRoom(request.getParameter("room"));

        int count = classroomDao.update(classroom);
        if (count == 0) {
            throw new Exception("해당 강의가 존재하지 않습니다.");
        } 

        return "redirect:list.do";
    }
    
    @RequestMapping("/view")
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int no = Integer.parseInt(request.getParameter("no"));
        Classroom classroom = classroomDao.selectOne(no);

        if (classroom == null) {
            throw new Exception("유효하지 않은 팀입니다.");
        }
        request.setAttribute("classroom", classroom);

        return "/classroom/view.jsp";
    }
    
}
//ver 40 - 필터 적용  request.setCharacterEncoding("UTF-8"); 제거
// ver 37 - 컨트롤러를 서블릿으로 변경