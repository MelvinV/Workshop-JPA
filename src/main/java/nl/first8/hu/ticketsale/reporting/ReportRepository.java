package nl.first8.hu.ticketsale.reporting;

import nl.first8.hu.ticketsale.venue.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReportRepository {

    private final EntityManager entityManager;

    @Autowired
    public ReportRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<LocationReport> findGenreLocations(String genre) {
        int genreOrdinal = Genre.valueOf(genre.toUpperCase()).ordinal();
        String jpql = "SELECT DISTINCT NEW nl.first8.hu.ticketsale.reporting.LocationReport(t.concert.artist, t.concert.location.name, t.account.info.city) " +
                "FROM Ticket t " +
                "WHERE t.concert.artist.genre = " + genreOrdinal; // for some reason setParameter doesnt work with Integers.......
        TypedQuery<LocationReport> query = entityManager.createQuery(jpql, LocationReport.class);
        //query.setParameter(1, genreOrdinal);
        return query.getResultList();
    }
}
