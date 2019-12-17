package servlets;

import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int number = 0;
        boolean noError = true;
        try {
            number = Integer.parseInt(req.getParameter("value")) * 2;
        } catch (Exception e) {
            noError = false;
        }
        Map<String, Object> pageVariables = new HashMap<>();
        resp.setContentType("text/html;charset=utf-8");
        pageVariables.put("value", number);
        resp.setStatus(noError ? HttpServletResponse.SC_OK : HttpServletResponse.SC_BAD_REQUEST);
        resp.getWriter().println(new PageGenerator().getPage("number.html", pageVariables));
    }

}
