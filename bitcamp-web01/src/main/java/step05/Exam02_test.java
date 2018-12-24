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

@WebServlet("/step05/exam02/test")
public class Exam02_test extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // 1) 클라이언트가 보낸 데이터
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            System.out.println("멀티파트 형식이 아닙니다.");
            return;
        }
        
        // 2) 멀티파트 데이터를 추출하여 HDD에 저장할 공장 준비
        DiskFileItemFactory factory = new DiskFileItemFactory();
        
        // 3) 멀티파트 데이터 분석기에 공장 객체를 장착한다.
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        // 4) 멀티파트로 전송된 요청 데이터 분석하기
        Map<String,String> paramMap = new HashMap<>();
        try {
            List<FileItem> items = upload.parseRequest(request);
            
            for (FileItem item : items) {
                if (item.isFormField()) {
                    out.printf("%s=%s\n", 
                            item.getFieldName(),
                            item.getString("UTF-8"));
                } else {
                    out.printf("%s=%s\n", 
                            item.getFieldName(),
                            item.getName());
                    
                    ServletContext appEnvInfo = request.getServletContext();
                    // 실제 경로를 알아낸다.
                    String savedPath = appEnvInfo.getRealPath("/");
                    out.println(savedPath);
                    
                    item.write(new File(savedPath + "/" + item.getName()));
                }
            }
            
        } catch (Exception e) {
            System.out.println("멀티파트 데이터 분석중 오류발생!");
        }
        
        
    }
    
    
}
