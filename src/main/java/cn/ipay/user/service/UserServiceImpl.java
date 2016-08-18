package cn.ipay.user.service;

import cn.ipay.user.model.User;
import cn.ipay.user.model.UserException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rayest on 2016/8/18 0018.
 */
public class UserServiceImpl implements UserService {
    private Map<String, User> users = new HashMap<String, User>();

    public void add(User user) {
        if (user.getUsername() != null) {
            throw new UserException("�û����Ѿ�����!");
        }
        users.put(user.getUsername(), user);
    }

    public void delete(String username) {
        users.remove(username);
    }

    public User load(String username) {
        return users.get(username);
    }

    public User login(String username, String password) {
        User user = load(username);
        if (user == null){
            throw new UserException("�û��������ڣ�");
        }
        if (user.getPassword() != password){
            throw new UserException("�û������벻���ڣ�");
        }
        return user;
    }
}
