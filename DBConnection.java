import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "24A81A0578",
                "24A81A0578"
            );

            System.out.println("Connection Successful");

        } catch(Exception e) {
            System.out.println(e);
        }

        return con;
    }
}