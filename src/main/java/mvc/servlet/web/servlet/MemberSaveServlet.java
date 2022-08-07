package mvc.servlet.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import mvc.servlet.basic.BasicData;
import mvc.servlet.domain.member.Member;
import mvc.servlet.domain.member.MemberRepository;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletInputStream inputStream = request.getInputStream();
//        String result = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        Member me2 = new Member(username, age);
//        Member member = objectMapper.readValue(result, Member.class);
        Member savedMember = memberRepository.save(me2);


        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();
        writer.write("<html>\n" +
                "<head>\n" +
                "   <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n" +
                "   <li> id = " + savedMember.getId() + "</li>\n" +
                "   <li> username = " + savedMember.getUsername() + "</li>\n" +
                "   <li> age = " + savedMember.getAge() + "</li>\n" +
                "</ul>\n" +
                "<a href =\"/index.html\"> 메인 </a> \n" +
                "</body>\n" +
                "");
        writer.write("</html>");

    }
}
