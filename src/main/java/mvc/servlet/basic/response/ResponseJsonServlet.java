package mvc.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import mvc.servlet.basic.BasicData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        BasicData basicData = new BasicData();
        basicData.setUsername("testBasic");
        basicData.setAge(99);

        PrintWriter writer = response.getWriter();
        writer.println(objectMapper.writeValueAsString(basicData));

    }
}
