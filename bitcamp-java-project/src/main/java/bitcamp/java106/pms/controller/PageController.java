package bitcamp.java106.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PageController {
    // viewUrl 리턴 해주기 위해 String으로 선언
    String service(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
