package cn.rayest.servlet.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lirui on 2017/3/25.
 */
public class LoginServlet extends HttpServlet {

    protected AuthenticationService getAuthenticationService() {
        return null;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("j_username");
        String password = request.getParameter("j_password");
        if (getAuthenticationService().isValidLogin(username, password)) {
            response.sendRedirect("/frontPage");
            request.getSession().setAttribute("username", username);
        } else {
            response.sendRedirect("/invalidLogin");
        }
    }
}
