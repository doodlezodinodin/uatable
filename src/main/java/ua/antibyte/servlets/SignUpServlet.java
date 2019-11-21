package ua.antibyte.servlets;

import ua.antibyte.helpers.PageGenerator;
import ua.antibyte.obj.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SignUpServlet extends HttpServlet {

    private Map<String, Object> variables = new HashMap<>();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html;charset=utf-8");
        res.getWriter().println(PageGenerator.getPage("signUp.html", variables));
        res.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String userMobileNumber = req.getParameter("numberPhone");
        String userPassword = req.getParameter("password");

        String errorMessage = "";
        User user = null;

        if (!userMobileNumber.isEmpty() && !userPassword.isEmpty()) {

            user = new User(userMobileNumber, userPassword);

            res.setContentType("text/html;charset=UTF-8");
            res.getWriter().println(PageGenerator.getPage("userPage.html", null));
            res.setStatus(HttpServletResponse.SC_OK);
        } else {
            errorMessage = "Не все поля заполнены.";
            variables.put("errorMessage", errorMessage);
            doGet(req, res);
        }
    }
}
