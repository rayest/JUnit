package cn.ipay.stub;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Rayest on 2016/8/16 0016.
 */
public class StubHttpURLConnection extends HttpURLConnection {

    private boolean isInput = true;

    protected StubHttpURLConnection(URL url) {
        super(url);
    }

    public InputStream getInputStream() throws ProtocolException {
        if (! isInput){
            throw new ProtocolException("Cannot read from URLConnection");
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(new String("It works").getBytes());
        return bais;
    }

    public void disconnect(){}

    public void connect(){
    }

    public boolean usingProxy(){
        return false;
    }
}
