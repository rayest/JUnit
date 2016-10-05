package cn.ipay.mock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rayest on 2016/8/18 0018.
 */
public class AccountServiceTest {
    @Test
    public void testTransferOk(){
        MockAccountManagerImpl accountManager = new MockAccountManagerImpl();
        Account senderAccount = new Account("1", 100);
        Account beneficiaryAccount = new Account("2", 200);
        accountManager.addAccount("1", senderAccount);
        accountManager.addAccount("2", beneficiaryAccount);
        AccountService accountService = new AccountService();
        accountService.setAccountManager(accountManager);
        accountService.transfer("1", "2", 50);
        assertEquals(50, senderAccount.getBalance());
        assertEquals(250, beneficiaryAccount.getBalance());
    }
}
