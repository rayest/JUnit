package cn.rayest.spring;

import cn.rayest.servlet.login.AuthenticationService;
import cn.rayest.servlet.login.FakeAuthenticationService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lirui on 2017/3/25.
 */
public class LoginController implements Controller {

    private FakeAuthenticationService fakeAuthenticationService;
    private AuthenticationService authenticator;

    public FakeAuthenticationService getFakeAuthenticationService() {
        return fakeAuthenticationService;
    }

    public void setFakeAuthenticationService(AuthenticationService authenticationService) {
        this.authenticator = authenticationService;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("j_username");
        String password = request.getParameter("j_password");
        if (authenticator.isValidLogin(username, password)) {
            return new ModelAndView("frontPage");
        }
        return new ModelAndView("wrongPassword");

    }

}
