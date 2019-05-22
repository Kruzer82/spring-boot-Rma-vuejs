package de.jonashackt.springbootvuejs.repository;


import de.jonashackt.springbootvuejs.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    Optional<Seller> findById(@Param("id") Long id);

    List<Seller> findByLastName(@Param("lastName") String lastName);

    List<Seller> findByFirstName(@Param("firstName") String firstName);

    List<Seller> findByInitials(@Param("initials") String initials);

    boolean existsByFirstNameAndLastName(@Param("firstName") String firstName,@Param("lastName") String lastName);

    boolean existsByInitials(@Param("initials") String initials);

    List<Seller> findByFirstNameAndLastNameAndInitials(@Param("firstName") String firstName,@Param("lastName") String lastName,@Param("initials") String initials);

    List<Seller> findAll();
}
