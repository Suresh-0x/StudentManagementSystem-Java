import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SearchStudentServlet
extends HttpServlet {

    protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response)

    throws ServletException, IOException {

        int id = Integer.parseInt(
        request.getParameter("student_id"));

        response.setContentType(
        "text/html");

        PrintWriter out =
        response.getWriter();

        try {

            Connection con =
            DBConnection.getConnection();

            String query =
            "SELECT * FROM students WHERE student_id=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs =
            ps.executeQuery();

            out.println("<html>");
            out.println("<head>");

            out.println("<title>Search Result</title>");

            out.println(

            "<style>" +

            "body{" +
            "font-family:Arial;" +
            "background:#f4f4f4;" +
            "}" +

            "table{" +
            "width:70%;" +
            "margin:auto;" +
            "margin-top:50px;" +
            "border-collapse:collapse;" +
            "background:white;" +
            "}" +

            "th,td{" +
            "padding:15px;" +
            "border:1px solid #ddd;" +
            "text-align:center;" +
            "}" +

            "th{" +
            "background:#4facfe;" +
            "color:white;" +
            "}" +

            "h1{" +
            "text-align:center;" +
            "margin-top:30px;" +
            "}" +

            "</style>"

            );

            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Student Details</h1>");

            if(rs.next()) {

                out.println("<table>");

                out.println(

                "<tr>" +

                "<th>ID</th>" +

                "<th>Name</th>" +

                "<th>Email</th>" +

                "<th>Course</th>" +

                "<th>Phone</th>" +

                "</tr>"
                );

                out.println("<tr>");

                out.println(
                "<td>" +
                rs.getInt("student_id") +
                "</td>");

                out.println(
                "<td>" +
                rs.getString("student_name") +
                "</td>");

                out.println(
                "<td>" +
                rs.getString("student_email") +
                "</td>");

                out.println(
                "<td>" +
                rs.getString("student_course") +
                "</td>");

                out.println(
                "<td>" +
                rs.getString("student_phone") +
                "</td>");

                out.println("</tr>");

                out.println("</table>");

            } else {

                out.println(
                "<h2 style='text-align:center;color:red;'>Student Not Found</h2>");
            }

            out.println("</body>");
            out.println("</html>");

            con.close();

        } catch(Exception e) {

            out.println(e);
        }
    }
}