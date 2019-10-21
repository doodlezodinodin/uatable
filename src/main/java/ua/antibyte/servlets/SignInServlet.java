package ua.antibyte.servlets;

import ua.antibyte.helpers.PageGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html;charset=UTF-8");
        res.getWriter().println(PageGenerator.getPage("signin.html", null));
        res.setStatus(HttpServletResponse.SC_OK);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if (name.equals("root") && password.equals("root")) {
            res.setContentType("text/html;charset=utf-8");
            res.getWriter().println(PageGenerator.getPage("../public_html/index.html", null));
            res.setStatus(HttpServletResponse.SC_OK);
        } else {
            doGet(req, res);
        }
    }
}
