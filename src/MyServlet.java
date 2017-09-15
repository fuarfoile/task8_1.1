import model.TextEditor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet(name = "ServletName", urlPatterns = {"/result"})
public class MyServlet extends HttpServlet {

    public MyServlet() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        performTask(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        performTask(request, response);
    }

    public void performTask(HttpServletRequest request, HttpServletResponse response) {

        try {
            String name;
            ArrayList<String> value = new ArrayList<>();

            Enumeration names = request.getParameterNames();
            while (names.hasMoreElements()) {
                name = (String) names.nextElement();
                value.add(request.getParameterValues(name)[0]);
            }

            String resultText = TextEditor.getText(Integer.parseInt(value.get(1)));

            request.setAttribute ("fontSize", value.get(0));
            request.setAttribute ("resultText", resultText);
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/jsp/result.jsp").forward(request, response);
        } catch (IOException | IndexOutOfBoundsException | ServletException e) {
            e.printStackTrace();
        }
    }
}
