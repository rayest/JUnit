package cn.rayest.servlet.echo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Enumeration;

/**
 * Created by lirui on 2017/3/25.
 */
public class EchoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "text/plain");
        PrintWriter writer = response.getWriter();
        Enumeration e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String parameter = String.valueOf(e.nextElement());
            String[] values = request.getParameterValues(parameter);
            for (int i = 0; i < values.length; i++) {
                writer.write(parameter + " = " + values[i]);
                writer.write("\n");
            }
        }
        writer.close();
    }

}
