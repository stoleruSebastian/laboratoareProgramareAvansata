package app;

import entity.Album;
import entity.Artist;
import repo.AlbumRepository;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AlbumManager {
    public static void main(String[] args) {
        EntityManagerFactory emf = PersistenceUtil.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Artist x=new Artist();
        x.setId(2);
        x.setName("sgdgdfgd");
        x.setCountry("Romania");
        Album a= new Album();
        a.setArtist_id(x);
        a.setId(2);
        a.setName("Album");
        a.setReleaseYear(1990);
        AlbumRepository ar= new AlbumRepository(em);
        ar.create(a);
        ar.findById(1);
        ar.findByName("Album");




    }

}

