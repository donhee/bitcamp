package bitcamp.java106.pms.servlet.team;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/team/view")
public class TeamViewServlet extends HttpServlet {

    TeamDao teamDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(
                this.getServletContext());
        teamDao = iocContainer.getBean(TeamDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>팀 보기</title>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("/header").include(request, response); // include
        out.println("<h1>팀 보기</h1>");
        
        try {
            Team team = teamDao.selectOne(name);
    
            if (team == null) {
                throw new Exception("유효하지 않은 팀입니다.");
            }
            
            out.println("<form action='update' method='post'>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.printf("    <th>팀명</th><td><input type=\"text\" name=\"name\" value='%s' readonly></td>\n",
                    team.getName());
            out.println("</tr>");
            out.println("<tr>");
            out.println("    <th>설명</th><td><textarea name=\"description\" ");
            out.printf("        rows=\"6\" cols=\"60\">%s</textarea></td>\n",
                    team.getDescription());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>최대인원</th><td><input type=\"number\" name=\"maxQty\" value='%d'></td>\n",
                    team.getMaxQty());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>시작일</th><td><input type=\"date\" name=\"startDate\" value='%s'></td>\n", 
                    team.getStartDate());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>종료일</th><td><input type=\"date\" name=\"endDate\" value='%s'></td>\n", 
                    team.getEndDate());
            out.println("</tr>");
            out.println("</table>");
            out.println("<p>");
            out.println("<a href='list'>목록</a>");
            out.println("<button>변경</button>");
            out.printf("<a href='delete?name=%s'>삭제</a>\n", name);
            out.printf("<a href='../task/list?teamName=%s'>작업목록</a>\n", name);
            out.println("</p>");
            out.println("</form>");
            
            // 팀 회원의 목록을 출력하는 것은 TeamMemberListServlet에게 맡긴다.
            RequestDispatcher rd = request.getRequestDispatcher("/team/member/list");
            rd.include(request, response); 
            // TeamMemberListServlet이 작업을 수행한 후 이 서블릿으로 되돌아 온다.
            
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 상세조회 실패!");
            // 다른 서블릿으로 실행을 위임할 때,
            // 이전까지 버퍼로 출력한 데이터를 버린다.
            rd.forward(request, response);
        }
        out.println("</body>");
        out.println("</html>");
    }
}
//ver 40 - 필터 적용  request.setCharacterEncoding("UTF-8"); 제거
// ver 39 - forward, include 적용
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