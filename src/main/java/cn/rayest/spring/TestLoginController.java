package cn.rayest.spring;

import cn.rayest.servlet.login.FakeAuthenticationService;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import static org.junit.Assert.assertEquals;

/**
 * Created by lirui on 2017/3/25.
 */
public class TestLoginController {
    public static final String CORRECT_PASSWORD = "correctPassword";
    public static final String VALID_USERNAME = "validUser";

    @Test
    public void wrongPasswordShouldRedirectToErrorPage() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("GET");
        request.addParameter("j_username", "noSuchUsername");
        request.addParameter("j_password", "noSuchPassword");
        MockHttpServletResponse response = new MockHttpServletResponse();
        FakeAuthenticationService mock = new FakeAuthenticationService();
        mock.addUser(VALID_USERNAME, CORRECT_PASSWORD);
        LoginController c = new LoginController();
        c.setFakeAuthenticationService(mock);
        ModelAndView v = c.handleRequest(request, response);
        assertEquals("wrongPassword", v.getViewName());
    }

    @Test
    public void validLoginForwardsToFrontPage() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("GET");
        request.addParameter("j_username", VALID_USERNAME);
        request.addParameter("j_password", CORRECT_PASSWORD);
        MockHttpServletResponse response = new MockHttpServletResponse();
        FakeAuthenticationService mock = new FakeAuthenticationService();
        mock.addUser(VALID_USERNAME, CORRECT_PASSWORD);
        LoginController c = new LoginController();
        c.setFakeAuthenticationService(mock);
        ModelAndView v = c.handleRequest(request, response);
        assertEquals("frontPage", v.getViewName());
    }
}
