import java.io.IOException;
import java.net.URISyntaxException;

public class documentManagementSystem {
    public class InvalidCatalogException extends Exception {
        public InvalidCatalogException(Exception ex) {
            super("Invalid catalog file.", ex);
        }
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Java Resources", "d:/java/catalog.ser");
        Document doc = new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);
        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException, URISyntaxException, ClassNotFoundException {
        Catalog catalog = CatalogUtil.load("d:/java/catalog.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }

    public static void main(String[] args) throws IOException, InvalidCatalogException, URISyntaxException, ClassNotFoundException {
        documentManagementSystem app = new documentManagementSystem();
        app.testCreateSave();
        app.testLoadView();

    }
}
