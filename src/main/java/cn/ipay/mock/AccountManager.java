package cn.ipay.mock;

/**
 * Created by Rayest on 2016/8/18 0018.
 */
public interface AccountManager {
    Account findAccountForUser(String userId);
    void updateAccount(Account account);
}
