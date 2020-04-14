package repo;

import entity.Album;
import entity.Artist;

import javax.persistence.EntityManager;
import java.util.List;

public class ArtistRepository {
    EntityManager em;
    public ArtistRepository(EntityManager em){
        this.em=em;
    }

    public void create(Artist newArtist){

        em.getTransaction().begin();
        em.persist(newArtist);
        em.getTransaction().commit();
        em.close();
        System.out.println("Artist salvat.");
    }
    public Artist findById(int id){
        return em.find(Artist.class,id);
    }
    public List<Artist> findByName(String name){
        List artisti = em.createNamedQuery("findArtistByName")
                .setParameter("artistName", name)
                .getResultList();
        return artisti;
    }
}
