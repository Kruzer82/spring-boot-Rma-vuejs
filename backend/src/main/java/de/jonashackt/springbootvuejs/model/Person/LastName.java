package de.jonashackt.springbootvuejs.model.Person;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity

public class LastName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String lastName;

    public LastName() {
    }

    public LastName(String lastName) {
        this.lastName = lastName;
    }
}
