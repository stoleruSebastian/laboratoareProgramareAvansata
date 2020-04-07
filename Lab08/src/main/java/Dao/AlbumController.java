package Dao;

import java.sql.*;

public class AlbumController {
    Connection conn;

    public AlbumController(Connection conn) {
        this.conn = conn;
    }

    public void create(String name, int artistId, int releaseYear) throws SQLException {
        String query = "insert into albums(name,release_year,artist_id) values(?,?,?)";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, name);
        preparedStmt.setInt(2, releaseYear);
        preparedStmt.setInt(3, artistId);
        preparedStmt.execute();

    }

    public void findByArtist(int artistId) throws SQLException {
        String query = "select * from albums where artist_id=" + artistId;
        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery(query);
        while (res.next()) {
            System.out.println(res.getString("name"));
        }
    }
}


