package nl.first8.hu.ticketsale.reporting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.first8.hu.ticketsale.venue.Artist;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationReport implements Serializable {

    private Artist artist;
    private String concertLocations;
    private String ticketCity;
}
