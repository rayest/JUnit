package cn.ipay.mock;

import javafx.scene.AmbientLight;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by Rayest on 2016/8/18 0018.
 */
public class DefaultAccountManagerImpl implements AccountManager {

    private static final Log LOGGER = LogFactory.getLog(AmbientLight.class);

    public Account findAccountForUser(String userId) {
        LOGGER.debug("Getting account for user " + userId);
        ResourceBundle bundle = PropertyResourceBundle.getBundle("technical");
        String sql = bundle.getString("FIND_ACCOUNT_FOR_USER");
        return null;
    }

    public void updateAccount(Account account) {

    }
}
