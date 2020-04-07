import java.sql.SQLException;
import Dao.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        Database bd= Database.getInstance();
        ArtistController artist= new ArtistController(bd.getConnection());
        artist.create("asgdgd","Germania");
        artist.findByName("Alexandru");
        AlbumController album=new AlbumController(bd.getConnection());
        album.create("Nume Album",2,2001);
        album.findByArtist(2);
    }
}
