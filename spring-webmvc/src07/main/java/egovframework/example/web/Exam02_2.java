package egovframework.example.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.dao.BoardDao;

@Controller
@RequestMapping("/exam02_2")
public class Exam02_2 {
    
    BoardDao boardDao;
    ServletContext servletContext;
    
    @Autowired
    public void setBoardDao(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @Autowired
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    
    
    @RequestMapping("m1")
    @ResponseBody 
    public String m1() {
        return this.servletContext.getContextPath();
    }
    
}
