package repo;

import entity.Album;
import util.PersistenceUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class AlbumRepository {
    EntityManager em;
    public AlbumRepository(EntityManager em){
        this.em=em;
    }

    public void create(Album newAlbum){

        em.getTransaction().begin();
        em.persist(newAlbum);
        em.getTransaction().commit();
        em.close();
        System.out.println("Album salvat.");
    }
    public Album findById(int id){
        return em.find(Album.class,id);
    }
    public List<Album> findByName(String name){
        List albume = em.createNamedQuery("findByName")
                .setParameter("albumName", name)
                .getResultList();
        return albume;
    }
    public List<Album> findByArtist(int artist_id){
        List albume = em.createNamedQuery("findByArtist")
                .setParameter("id", artist_id)
                .getResultList();
        return albume;
    }

}
