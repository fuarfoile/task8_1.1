import model.TextEditor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

public class RequestOutput {
    public static void generate(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("text/html; charset=utf-8");
            PrintWriter out = resp.getWriter();

            String name;
            ArrayList<String> value = new ArrayList<>();

            Enumeration names = req.getParameterNames();
            while (names.hasMoreElements()) {
                name = (String) names.nextElement();
                value.add(req.getParameterValues(name)[0]);
            }

            String resultText = TextEditor.getText(Integer.parseInt(value.get(1)));

            out.print("<HTML><HEAD>");
            out.print("<TITLE>Result</TITLE>");
            out.print("</HEAD><BODY>");

            out.print("<pre style=\"font-size:" + value.get(0) + "px\">" + resultText + "</pre>");

            out.print("</BODY></HTML>");
            out.close();
        } catch (IOException | IndexOutOfBoundsException e) { e.printStackTrace(); }
    }
}