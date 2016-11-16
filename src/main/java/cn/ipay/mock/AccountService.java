package cn.ipay.mock;

/**
 * Created by Rayest on 2016/8/18 0018.
 */
public class AccountService {
    private AccountManager accountManager;
    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void transfer(String senderId, String beneficiaryId, long amount){
        Account sender = this.accountManager.findAccountForUser(senderId);
        Account beneficiary = this.accountManager.findAccountForUser(beneficiaryId);
        sender.debit(amount);
        beneficiary.credit(amount);
        this.accountManager.updateAccount(sender);
        this.accountManager.updateAccount(beneficiary);
    }
}
