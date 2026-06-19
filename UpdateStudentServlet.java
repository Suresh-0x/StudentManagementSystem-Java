import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateStudentServlet
extends HttpServlet {

    protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response)

    throws ServletException, IOException {

        int id = Integer.parseInt(
        request.getParameter("student_id"));

        String field =
        request.getParameter("field");

        String value = "";

        if(field.equals("student_name")) {

            value =
            request.getParameter("student_name");
        }

        else if(field.equals(
        "student_email")) {

            value =
            request.getParameter("student_email");
        }

        else if(field.equals(
        "student_course")) {

            value =
            request.getParameter("student_course");
        }

        else if(field.equals(
        "student_phone")) {

            value =
            request.getParameter("student_phone");
        }

        response.setContentType(
        "text/html");

        PrintWriter out =
        response.getWriter();

        try {

            Connection con =
            DBConnection.getConnection();

            String query =
            "UPDATE students SET "
            + field +
            "=? WHERE student_id=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setString(1, value);

            ps.setInt(2, id);

            int rows =
            ps.executeUpdate();

            if(rows > 0) {

                out.println(
                "<h2>Student Updated Successfully</h2>");

            } else {

                out.println(
                "<h2>Student ID Not Found</h2>");
            }

            con.close();

        } catch(Exception e) {

            out.println(e);
        }
    }
}