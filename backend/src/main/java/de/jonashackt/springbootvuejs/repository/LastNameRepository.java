package de.jonashackt.springbootvuejs.repository;


import de.jonashackt.springbootvuejs.model.Person.LastName;
import de.jonashackt.springbootvuejs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LastNameRepository extends JpaRepository<LastName, Long> {

    LastName findByLastName(@Param("lastName") String lastName);

    List<LastName> findAll();
}
