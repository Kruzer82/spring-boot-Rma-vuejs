package de.jonashackt.springbootvuejs.model;

import de.jonashackt.springbootvuejs.model.Person.FirstName;
import de.jonashackt.springbootvuejs.model.Person.LastName;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
public class Seller implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE)
    private FirstName firstName;
    @OneToOne(cascade = CascadeType.MERGE)
    private LastName lastName;
    private String initials;

    public Seller() {
    }

    public Seller(FirstName firstName, LastName lastName, String initials) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.initials = initials;
    }

}

