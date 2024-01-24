package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

import java.io.IOException;

@WebServlet(name = "responseHeaderServlet" , urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK);

        // [response-headers]
        response.setHeader("Content-Type" , "text/plain");
        response.setHeader("Cache-Control" , "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma" , "no-cache");
        response.setHeader("my-header" , "sample");


        // [Header 편의 메서드]
        content(response);

        // [cookie]
        cookie(response);

        // [redirect]
        redirect(response);

        response.getWriter().write("ok");
    }

    // 헤더를 직접 명시하지 않고 내용을 넣을 수 있다.
    private void content(HttpServletResponse response){
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse response){
        Cookie cookie = new Cookie("myCookie" , "hello");
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException{
//        response.setStatus(HttpServletResponse.SC_FOUND);
//        response.setHeader("Location","/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
