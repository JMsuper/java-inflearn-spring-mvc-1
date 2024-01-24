package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.ResponseFacade;

import java.io.IOException;

// name 은 아무거나 등록해도 됨. name 의 용도는? 서블릿 이름 <- 다만 다른 서블릿과 겹치면 안됨
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // service 는 서블릿이 실행될 때 호출되는 메서드
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("request = " + response);

        String name = request.getParameter("username");
        System.out.println("name = " + name);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + name);



    }
}

// 톰캣이나 제티는 서블릿 표준(servlet interface)을 구현한다.
// 따라서, 위 service 메서드에서 인자로 받은, request, response 객체는 구현체의 객체를 넘겨받은 것이다.
// Facade 란 고수준 클래스에서 저수준 클래스들을 다루기 위한 디자인 패턴이다.

