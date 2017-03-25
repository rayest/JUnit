package cn.rayest.servlet.login;

import com.sun.xml.internal.xsom.impl.UName;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lirui on 2017/3/25.
 */
public class FakeAuthenticationService implements AuthenticationService {

    private Map<String, String> users = new HashMap<String, String>();

    public void addUser(String username, String password) {
        users.put(username, password);
    }

    public boolean isValidLogin(String username, String password) {
        return users.containsKey(username) && password.equals(users.get(username));
    }
}
