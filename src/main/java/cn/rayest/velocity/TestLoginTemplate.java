package cn.rayest.velocity;

import org.junit.Test;

/**
 * Created by lirui on 2017/3/25.
 */
public class TestLoginTemplate extends VelocityTestCase {

    @Override
    protected String getWebRoot(){
        return "./websrc/velocity";
    }

    @Test
    public void previousUsernameIsRetained() throws Exception{
        String previousUsername = "Bob";
        setAttribute("username", previousUsername);
         // render("/login.vtl");
        // assertFormFieldValue("j_username", previousUsername);
    }
}
