import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String name =
        request.getParameter("student_name");

        String email =
        request.getParameter("student_email");

        String course =
        request.getParameter("student_course");

        String phone =
        request.getParameter("student_phone");

        try {

            Connection con =
            DBConnection.getConnection();

            String query =
            "INSERT INTO students " +
            "(student_id, student_name, student_email, student_course, student_phone) " +
            "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps =
            con.prepareStatement(query);

            int id =
            (int)(Math.random()*1000);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, course);
            ps.setString(5, phone);

            int rows = ps.executeUpdate();

            response.setContentType("text/html");

            PrintWriter out =
            response.getWriter();

            if(rows > 0) {

                out.println(
                "<h2>Student Added Successfully</h2>");

            } else {

                out.println(
                "<h2>Failed to Add Student</h2>");
            }

            con.close();

        } catch(Exception e) {

            System.out.println(e);

        }
    }
}