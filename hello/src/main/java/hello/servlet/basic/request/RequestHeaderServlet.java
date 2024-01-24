package hello.servlet.basic.request;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet" , urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        printAll(request);
//        printHeader(request);
//        printHeaderUtils(request);
        printEtc(request);
    }

    private void printAll(HttpServletRequest request) {
        System.out.println("--- REQUEST LINE - start ---");
        System.out.println("request.getProtocol() = " + request.getProtocol());
        System.out.println("request.getMethod() = " + request.getMethod());
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure()); // HTTP 사용 유무
        System.out.println("--- REQUEST LINE - end ---");
    }

    private void printHeader(HttpServletRequest request){
        System.out.println("--- HEADER LINE - start ---");

//        옛날 방식
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()){
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + " : " + headerName);
//        }

        request.getHeaderNames().asIterator().forEachRemaining(headerName -> System.out.println(headerName + " : " + request.getHeader(headerName)));


        System.out.println("--- HEADER LINE - end ---");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest request){
        System.out.println("--- HEADER 편의 조회 start ---");
        System.out.println("[HOST 편의 조회]");
        System.out.println("request.getServerName() + "+request.getServerName());
        System.out.println("request.getServerPort() + "+request.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if(request.getCookies() != null){
            for(Cookie cookie : request.getCookies()){
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 ---");
        System.out.println();
    }

    private void printEtc(HttpServletRequest request){
        // 이 부분은 HTTP 가 아닌, TCP 와 같은 프로토콜을 통해 가져온 정보를 알려준다.
        System.out.println("--- 기타 조회 ---");
        System.out.println("[Remote 정보]"); // 클라이언트 정보
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + request.getRemotePort());
    }
}
