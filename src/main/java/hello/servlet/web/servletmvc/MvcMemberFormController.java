package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormController", urlPatterns = "/sevlet-mvc/members/new-form")
public class MvcMemberFormController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // dispatcher.forward : 다른 서블릿이나 jsp로 이동할 수 있는 기능으로 서버 내부에서 다시 호출이 발생한다.
        // WEB-INF : 해당 디렉토리 내에 파일이 존재할 경우 외부에서 호출되도 호출되지 않으며,
        // 컨트롤러를 거쳐 내부에서 forward 등을 거쳐야 view가 내보여진다.
        dispatcher.forward(request, response);

    }

}
