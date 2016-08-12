package cn.ipay.controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * Created by Rayest on 2016/8/12 0012.
 */
public class DefaultControllerTest {

    private DefaultController controller;
    private Request request;
    private RequestHandler handler;

    private class SampleRequest implements Request{
        public String getName() {
            return "Test";
        }
    }

    private class SampleHandler implements RequestHandler{
        public Response process(Request request) {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response{
    }

    @Before
    public void initialize(){
        controller = new DefaultController();
        request = new SampleRequest();
        handler = new SampleHandler();
        controller.addHandler(request, handler);

    }

    @Test
    public void testMethod(){
        throw new RuntimeException("implement me");
    }


    @Test
    public void testAddHandler(){

        RequestHandler handler2 = controller.getHandler(request);
        assertSame("Handler we set in controller should be the controller we get", handler2, handler);
    }

    @Test
    public void testProcessRequest(){

        Response response = controller.processRequest(request);
        assertNotNull("Must not return a null response" + response);
        assertEquals("Response should be of type SampleResponse", SampleResponse.class, response.getClass());
    }
}
