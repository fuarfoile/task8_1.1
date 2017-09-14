import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        RequestOutput.generate(request, response);
    }
}
