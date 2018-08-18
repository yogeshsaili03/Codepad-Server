package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:///codepad";
            con = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception in connect()" + e);
        }
        return con;
    }
}
