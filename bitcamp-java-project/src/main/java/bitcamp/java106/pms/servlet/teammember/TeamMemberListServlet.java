package bitcamp.java106.pms.servlet.teammember;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/team/member/list")
// 이 서블릿을 실행하고 싶으면 url에서 /team/member/list로 요청하라!
public class TeamMemberListServlet extends HttpServlet {

    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(
                this.getServletContext());
        teamMemberDao = iocContainer.getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        // include 하기 전의 이전 서블릿에서 문자셋을 지정할 것이고
        // 이미 getParameter()를 호출했을 것이기 때문에 다음 코드는 의미가 없다.
        // => request.setCharacterEncoding("UTF-8");
        
        
        // including 하기 전의 이전 서블릿에서 콘텐트 타입을 설정했을 것이기 때문에 다음 코드는 의미가 없다.
        // => response.setContentType("text/html;charset=UTF-8");
        
        
        try {
            String name = request.getParameter("name");
            List<Member> members = teamMemberDao.selectListWithEmail(name);
            
            request.setAttribute("list", members);
            response.setContentType("text/html;charset=UTF-8");
            request.getRequestDispatcher("/teammember/list.jsp").include(request, response);
            
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 멤버 조회 실패!");
            rd.forward(request, response);
        }
    }
}
// ver 39 - forword, include 적용
//ver 37 - selectListWithEmail() 추가 
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TeamController에서 view() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TeamDao를 사용한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - TeamDao를 생성자에서 주입 받도록 변경.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.