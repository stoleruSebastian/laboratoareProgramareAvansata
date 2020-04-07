package Dao;

import java.sql.*;

public class ArtistController {
    Connection conn;

    public ArtistController(Connection conn) {
        this.conn = conn;
    }

    public void create(String name, String country) throws SQLException {
        String query = "insert into artists(name,country) values(?,?)";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, name);
        preparedStmt.setString(2, country);
        preparedStmt.execute();
    }

    public void findByName(String name) throws SQLException {
        String query = "select * from artists where name=\"" + name + "\"";
        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery(query);
        while (res.next()) {
            System.out.println(res.getString("name"));
        }
    }
}

