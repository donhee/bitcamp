// 로그아웃 처리 서블릿 - 세션을 무효화 시킨다.
package bitcamp.java106.pms.controller.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.web.RequestMapping;

@Component("/auth/logout")
public class LogoutController {
    
    @RequestMapping
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        request.getSession().invalidate();
        
        return "redirect:" + request.getContextPath(); // ==> "/bitcamp-java-project"
    }
}
    






