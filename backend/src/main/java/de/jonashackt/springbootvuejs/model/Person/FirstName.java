package de.jonashackt.springbootvuejs.model.Person;

import de.jonashackt.springbootvuejs.services.FirstNameServiceImp;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity

public class FirstName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String firstName;

    @Autowired
    private FirstNameServiceImp firstNameServiceImp;

    public FirstName() {
    }

    public FirstName(String firstName) {
        this.firstName = firstName;
    }


}
