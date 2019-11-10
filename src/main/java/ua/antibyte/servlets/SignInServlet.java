package ua.antibyte.servlets;

import ua.antibyte.helpers.PageGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SignInServlet extends HttpServlet {

    private Map<String, Object> variables = new HashMap<>();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html;charset=UTF-8");
        res.getWriter().println(PageGenerator.getPage("signIn.html", variables));
        res.setStatus(HttpServletResponse.SC_OK);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String numberPhone = req.getParameter("numberPhone");
        String password = req.getParameter("password");

        String errorMessage = "";

        if (!numberPhone.isEmpty() && !password.isEmpty()) {
            if (numberPhone.equals("1") && password.equals("1")) {
                res.setContentType("text/html;charset=UTF-8");
                res.getWriter().println(PageGenerator.getPage("userPage.html", null));
                res.setStatus(HttpServletResponse.SC_OK);
            } else {
                errorMessage = "Не верный номер или пароль.";
                variables.put("errorMessage", errorMessage);
                doGet(req, res);
            }
        } else {
            errorMessage = "Не все поля заполнены.";
            variables.put("errorMessage", errorMessage);
            doGet(req, res);
        }
    }
}
