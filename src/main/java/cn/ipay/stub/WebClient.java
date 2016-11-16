package cn.ipay.stub;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Rayest on 2016/8/16 0016.
 */
public class WebClient {
    public String getContent(URL url) throws IOException {
        StringBuffer content = new StringBuffer();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        InputStream is = connection.getInputStream();
        byte[] buffer = new byte[2048];
        int count;
        while (-1 != (count = is.read(buffer))) {
            content.append(new String(buffer, 0, count));
        }
        return content.toString();
    }
}
