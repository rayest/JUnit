package cn.ipay.mock;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rayest on 2016/8/18 0018.
 */
public class MockAccountManagerImpl implements AccountManager {
    private Map<String, Account> accounts = new HashMap<String, Account>();
    public void addAccount(String userId, Account account){
        this.accounts.put(userId, account);
    }
    public Account findAccountForUser(String userId) {
         return this.accounts.get(userId);
    }
    public void updateAccount(Account account) {
    }
}
