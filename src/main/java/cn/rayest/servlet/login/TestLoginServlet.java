package cn.rayest.servlet.login;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by lirui on 2017/3/25.
 */
public class TestLoginServlet {
    public static final String CORRECT_PASSWORD = "correctPassword";
    public static final String VALID_USERNAME = "validUser";

    private LoginServlet servlet;
    private FakeAuthenticationService authenticationService;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        authenticationService = new FakeAuthenticationService();
        authenticationService.addUser(VALID_USERNAME, CORRECT_PASSWORD);
        servlet = new LoginServlet() {
            @Override
            protected AuthenticationService getAuthenticationService() {
                return authenticationService;
            }
        };
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void wrongPasswordShouldRedirectToErrorPage() throws ServletException, IOException {
        request.addParameter("j_username", VALID_USERNAME);
        request.addParameter("j_password", "wrongPassword");
        MockHttpServletResponse response = new MockHttpServletResponse();
        servlet.service(request, response);
        assertEquals("/invalidLogin", response.getRedirectedUrl());
    }

    @Test
    public void validLoginForwardsToFrontPageAndStoresUsername() throws Exception {
        request.addParameter("j_username", VALID_USERNAME);
        request.addParameter("j_password", CORRECT_PASSWORD);
        MockHttpServletResponse response = new MockHttpServletResponse();
        servlet.service(request, response);
        assertEquals("/frontPage", response.getRedirectedUrl());
        assertEquals(VALID_USERNAME, request.getSession().getAttribute("username"));

    }
}
