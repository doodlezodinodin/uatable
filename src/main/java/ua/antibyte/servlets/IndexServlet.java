package ua.antibyte.servlets;

import ua.antibyte.helpers.PageGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IndexServlet extends HttpServlet {

    private String login = "";

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Map<String, Object> pageVariables = new HashMap<>();

        pageVariables.put("lastLogin", login == null ? "" : login);

        res.getWriter().println(PageGenerator.getPage("index.html", pageVariables));
        res.setContentType("text/html;charset=utf-8");
        res.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        login = req.getParameter("login");

        doGet(req, res);
    }
}
