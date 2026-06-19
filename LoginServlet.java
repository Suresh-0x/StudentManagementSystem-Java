import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        if (username.equals("admin")
                && password.equals("admin@1234")) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "username",
                    username);

            response.sendRedirect(
                    "dashboard.html?login=success");

        } else {

            response.sendRedirect(
                    "login.html?error=1");
        }
    }
}