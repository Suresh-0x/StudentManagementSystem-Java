import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewStudentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            Connection con =
            DBConnection.getConnection();

            Statement st =
            con.createStatement();

            ResultSet rs =
            st.executeQuery("SELECT * FROM students");

            out.println("<html>");

            out.println("<head>");

            out.println("<title>View Students</title>");

            out.println(

            "<style>" +

            "body{" +
            "font-family:Arial;" +
            "background:#f4f4f4;" +
            "}" +

            "table{" +
            "width:85%;" +
            "margin:auto;" +
            "border-collapse:collapse;" +
            "background:white;" +
            "box-shadow:0 5px 15px rgba(0,0,0,0.2);" +
            "}" +

            "th,td{" +
            "padding:14px;" +
            "border:1px solid #ddd;" +
            "text-align:center;" +
            "}" +

            "th{" +
            "background:#4facfe;" +
            "color:white;" +
            "font-size:18px;" +
            "}" +

            "tr:nth-child(even){" +
            "background:#f9f9f9;" +
            "}" +

            "h1{" +
            "text-align:center;" +
            "margin:30px;" +
            "color:#333;" +
            "}" +

            "</style>"

            );

            out.println("</head>");

            out.println("<body>");

            out.println("<h1>Student Records</h1>");

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

            while(rs.next()) {

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
            }

            out.println("</table>");

            out.println("</body>");

            out.println("</html>");

            con.close();

        } catch(Exception e) {

            out.println(e);
        }
    }
}