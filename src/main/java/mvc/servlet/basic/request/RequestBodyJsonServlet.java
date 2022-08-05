package mvc.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import mvc.servlet.basic.BasicData;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);


        BasicData basicData = objectMapper.readValue(messageBody, BasicData.class);

        System.out.println("basicData.getUsername() = " + basicData.getUsername());
        System.out.println("basicData.getAge() = " + basicData.getAge());
    }
}
