import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        int id = Integer.parseInt(
                    request.getParameter("student_id"));

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            Connection con = DBConnection.getConnection();

            String query =
                "DELETE FROM students WHERE student_id=?";

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0){

                out.println("<h1>Student Deleted Successfully</h1>");

            } else {

                out.println("<h1>Student Not Found</h1>");
            }

            con.close();

        } catch(Exception e){

            out.println(e);
        }
    }
}