package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "albums", schema = "musicalbums")
@NamedQueries({
        @NamedQuery(name="findByName",
        query = "select a from Album a where a.name like :albumName"),
        @NamedQuery(name="findByArtist",
                query = "select a from Album a where a.artist_id.id = id")
})
public class Album {
    private int id;
    private String name;
    private Artist artist_id;
    private Integer releaseYear;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name="artist_id",referencedColumnName = "id")
    public Artist getArtist_id(){return artist_id;}

    public void setArtist_id(Artist artist_id) {
        this.artist_id = artist_id;
    }

    @Basic
    @Column(name = "release_year")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album that = (Album) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(releaseYear, that.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseYear);
    }
}
