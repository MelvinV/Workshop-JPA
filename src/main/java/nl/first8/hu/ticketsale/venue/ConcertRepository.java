package nl.first8.hu.ticketsale.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by melvin on 27-5-2017.
 */

@Repository
public class ConcertRepository {

    private final EntityManager entityManager;

    @Autowired
    public ConcertRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Concert> findByArtistName(String artistName) {
        try {
            return entityManager.createQuery("SELECT c FROM Concert c WHERE c.artist.name = :artistName", Concert.class)
                    .setParameter("artistName", artistName)
                    .getResultList();
        } catch (NoResultException ex) {
            return Arrays.asList();
        }
    }

    public List<Concert> findByArtistGenre(String artistGenre) {
        try {
            int genreOrdinal = Genre.valueOf(artistGenre.toUpperCase()).ordinal();
            return entityManager.createQuery("SELECT c FROM Concert c WHERE c.artist.genre = " + genreOrdinal, Concert.class)
                    .getResultList();
        } catch (NoResultException ex) {
            return Arrays.asList();
        }
    }

    public List<Concert> findByLocationName(String locationName) {
        try {
            return entityManager.createQuery("SELECT c FROM Concert c WHERE c.location.name = :locationName", Concert.class)
                    .setParameter("locationName", locationName)
                    .getResultList();
        } catch (NoResultException ex) {
            return Arrays.asList();
        }
    }
}
