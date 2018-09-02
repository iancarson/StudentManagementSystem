package dbConnection;
import school.management.system.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LogIn {
    Connection connection;
    private static final String DBUSER="dbuser";
    private static final String DBPASSOWRD="dbpassword";
    private static final String CONN="jdbc:sqlite://localhost/login";
    private static final String  SQCONN="jdbc:sqlite:Carson.school.management.system.sqlite";
    private static Connection getConnection() throws Exception {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQCONN);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
