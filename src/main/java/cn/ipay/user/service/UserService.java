package cn.ipay.user.service;

import cn.ipay.user.model.User;

/**
 * Created by Rayest on 2016/8/18 0018.
 */
public interface UserService {
    void add(User user);
    void delete(String username);
    User load(String username);
    User login(String username, String password);
}
