package de.jonashackt.springbootvuejs.repository;


import de.jonashackt.springbootvuejs.model.Person.FirstName;
import de.jonashackt.springbootvuejs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FirstNameRepository extends JpaRepository<FirstName, Long> {

    FirstName findByFirstName (@Param("firstName") String firstName);

    List<FirstName> findAll();
}
