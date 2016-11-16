package cn.ipay.stub;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rayest on 2016/8/16 0016.
 */

public class WebClientTest {

    private class GetContentOkHandlerTest extends AbstractHandler {

        public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
            OutputStream out = response.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It works");
            writer.flush();
            response.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }

    @BeforeClass
    public static void setUp() throws Exception {
        Server server = new Server(8080);
        WebClientTest t = new WebClientTest();
        Context contentOkContext = new Context(server, "/testGetContentOk");
        contentOkContext.setHandler(t.new GetContentOkHandlerTest());
        server.setStopAtShutdown(true);
        server.start();
    }

    @AfterClass
    public static void tearDown() {
    }

    @Test
    public void testGetContentOk() throws IOException {
        WebClient client = new WebClient();
        String result = client.getContent(new URL("http://localhost:8080/testGetContentOk"));
        assertEquals("It works", result);
    }

}
