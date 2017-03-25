package cn.rayest.servlet.login;

/**
 * Created by lirui on 2017/3/25.
 */
public interface AuthenticationService {
    boolean isValidLogin(String username, String password);
}
