package cn.northWind.controller;

import com.meterware.httpunit.WebConversation;
import org.junit.Test;

/**
 * Created by Rayest on 2016/10/5 0005.
 */
public class HttpControllerTest {

    @Test
    public void testGetBook() throws Exception {
        WebConversation webConversation = new WebConversation();
        webConversation.getResponse("http://localhost:8080/book");
    }

    @Test
    public void testGetMusic() throws Exception {
        WebConversation webConversation = new WebConversation();
        webConversation.getResponse("http://localhost:8080/music");
    }
}
