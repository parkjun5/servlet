package mvc.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        printBasicMethod(request);
        printGetHeaders(request);
        printHeaderUtils(request);
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("============ 헤더 편의 조회 프린트 시작 ============");

        System.out.println("request.getServerName() = " + request.getServerName());
        System.out.println("request.getServerPort() = " + request.getServerPort());
        System.out.println();

        request.getLocales()
                .asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));

        System.out.println("request.getLocale() = " + request.getLocale());

        System.out.println(" 쿠키 조회");

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println("cookie.getValue() = " + cookie.getValue());
            }
        }
        
        System.out.println("============ 헤더 편의 조회 프린트 끝  ============");
    }

    private static void printGetHeaders(HttpServletRequest request) {
        System.out.println("============ 헤더 시작 ============");

        request.getHeaderNames()
                .asIterator()
                .forEachRemaining( headerName -> System.out.println(headerName + ": " + headerName));

        System.out.println("============ 헤더 끝  ============");
    }

    private static void printBasicMethod(HttpServletRequest request) {
        System.out.println("request.getMethod() = " + request.getMethod());
        System.out.println("request.getProtocol() = " + request.getProtocol());
        System.out.println("request.getScheme() = " + request.getScheme());
        System.out.println();

        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequestURI() = " + request.getRequestURI());

        System.out.println();

        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure());
    }
}
