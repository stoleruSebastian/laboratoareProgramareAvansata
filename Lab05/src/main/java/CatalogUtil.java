import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws documentManagementSystem.InvalidCatalogException {//...
    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();//... browse or open, depending of the location type    }
    }
}
