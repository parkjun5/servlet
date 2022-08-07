package mvc.servlet.web.servlet;

import mvc.servlet.domain.member.Member;
import mvc.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();


    @Override

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        List<Member> members = memberRepository.findAll();
        PrintWriter writer = response.getWriter();
        writer.write("<html>\n" +
                "<head>\n" +
                "   <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n");
        for (Member member : members) {
            writer.write(
                    "   <li> id = " + member.getId() + "</li>\n" +
                    "   <li> username = " + member.getUsername() + "</li>\n" +
                    "   <li> age = " + member.getAge() + "</li>\n");
        }

        writer.write(
                "</ul>\n" +
                "<a href =\"/index.html\"> 메인 </a> \n" +
                "</body>\n" +
                "");
        writer.write("</html>");
    }
}
