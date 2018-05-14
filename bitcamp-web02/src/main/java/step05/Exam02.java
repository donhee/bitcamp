// 파일 업로드 - 멀티 파트 파라미터 값 추출하기
package step05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/step05/exam02")
public class Exam02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 멀티파트로 전송된 POST 요청 데이터를 추출하려면 일반적인 방법으로는 안된다.
        
        
        // 1) 클라이언트가 보낸 데이터
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            System.out.println("멀티파트 형식이 아닙니다!");
            return;
        }
        
        // 2) 멀티파트 데이터를 추출하여 HDD에 저장할 공장 준비
        DiskFileItemFactory factory = new DiskFileItemFactory();
        
        // 3) 멀티파트 데이터 분석기에 공장 객체를 장착한다.
        // => 멀티파트 데이터 분석기가 멀티파트 데이터를 추출하면
        //    공장 객체가 파일로 만들어 HDD에 저장한다.
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        // 4) 멀티파트로 전송된 요청 데이터 분석하기
        Map<String,String> paramMap = new HashMap<>();
        try {
            List<FileItem> items = upload.parseRequest(request);
            
            for (FileItem item : items) {
                if (item.isFormField()) { //일반적인 테스트 항목
                    // 파라미터의 한글이 깨질 경우,
                    // => request.setCharacterEncoding("UTF-8") 은 소용없다.
                    //    이 코드는 멀티 파트가 아닌 application/x-www-form-urlencoding
                    out.printf("%s=%s\n", 
                            item.getFieldName(), // 파라미터 명
                            item.getString("UTF-8")); //파라미터 값
                } else { //파일일 경우,
                    out.printf("%s=%s\n", 
                            item.getFieldName(), // 파라미터 명
                            item.getName()); // 파일명
                    // 클라이언트가 보낸 파일을 저장하자!
                    // - 임의의 폴더에 ㅈ장하면 웹 브라우저에서 업로드한 파일을 다시 다운로드 받기 어렵다.
                    //   임의의 폴더란? 웹브라우저에서 접근할 수 없는 폴더를 말한다.
                    // - 임의의 폴더에 저장할 경우, 다운로드를 처리해주는 서블릿을 별도로 만들어야 한다.
                    // 좀더 쉬운 방법은?
                    // - 웹 브라우저가 접근 할 수 있는 폴더에 저장하자!
                    // - 단 이 방법은 웹브라우저에서 너무 쉽게 특정 파일을 접근할 수 있기 때문에 
                    //   보안이 취약하다.
                    // 실무는 어떤 방식으로 취하나?
                    // - 웹브라우저가 접근 할수 없는 곳에 저장한다.
                    // - 오직 다운로드 서블릿을 통해서 만 허가된 사용자가 다운로드 받을 수 있도록 한다.
                    //
                    // 여기서 파일 업로드 다운로드를 테스트 하는데 집중하기 위해서
                    // 임의의 폴더가 아닌 웹브라우저에서 접근 할 수 있는 폴더에 저장하겠다.
                    // 즉 배치 폴더에서 저장하겠다.
                    // 배치 폴터에 저장하기 위해서는 배치 폴더의 전체 경로를 알아야한다.
                    // => 웹 애플리케이션 환경 정보를 다루는 객체를 얻는다.
                    ServletContext appEnvInfo = request.getServletContext();
                    // => ServletContext 객체를 통해 웹 애플리케이션의 루트 디렉토리의 
                    //    실제 경로를 알아낸다.
                    String savedPath = appEnvInfo.getRealPath("/");
                    out.println(savedPath);
                    
                    // => FileItem.write() 호출하여 클라이언트
                    item.write(new File(savedPath + "/" + item.getName()));
                }
            }
        } catch (Exception e) {
            System.out.println("멀티파트 데이터 분석중 오류발생!");
        }
        
        // 출력할 때 UTF-16 ===> UTF-8로 제대로 바꾸기 위해
        // 출력 스트림을 얻기 전에 알려줘야한다.
//        out.printf("이름=%s\n",name);
//        out.printf("나이=%s\n",age);
//        out.printf("사진=%s\n",photo);
        
        
    }
}


