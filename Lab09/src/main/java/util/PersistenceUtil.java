package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {


    private static final PersistenceUtil instance = new PersistenceUtil();

    protected EntityManagerFactory emf;

    public static PersistenceUtil getInstance() {

        return instance;
    }

    private PersistenceUtil() {
    }

    public EntityManagerFactory getEntityManagerFactory() {

        if (emf == null)
            createEntityManagerFactory();
        return emf;
    }

    public void closeEntityManagerFactory() {

        if (emf != null) {
            emf.close();
            emf = null;
        }
    }

    protected void createEntityManagerFactory() {

        this.emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    }
}