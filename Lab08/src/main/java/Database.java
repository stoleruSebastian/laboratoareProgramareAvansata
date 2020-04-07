import javax.xml.crypto.Data;
import java.sql.*;


public class Database {
    private static Database instance = null;
    private Connection conexiune;
    private String url = "jdbc:mysql://localhost:3306/musicalbums";
    private String user = "dba";
    private String password = "sql";

    private Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conexiune = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Datbase connection failed: " + e.getMessage());

        }
    }

    public void closeConnection() throws SQLException {
        conexiune.close();
    }

    public Connection getConnection() {
        return conexiune;
    }

    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        } else if (instance.getConnection().isClosed()) {
            instance = new Database();
        }
        return instance;
    }

}