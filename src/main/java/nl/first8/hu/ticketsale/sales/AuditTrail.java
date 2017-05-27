package nl.first8.hu.ticketsale.sales;

import lombok.Data;
import lombok.NoArgsConstructor;
import nl.first8.hu.ticketsale.registration.Account;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by melvin on 27-5-2017.
 */
@Entity
@Data
@NoArgsConstructor
public class AuditTrail implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private Sale sale;
}
