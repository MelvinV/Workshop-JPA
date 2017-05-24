package nl.first8.hu.ticketsale.venue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by melvin on 24-5-2017.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Genre genre;
}
