package de.jonashackt.springbootvuejs.services;


import de.jonashackt.springbootvuejs.model.Seller;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SellerService  {
    Seller addOrGetSeller(@Param("seller") Seller seller);
    List<Seller> findById(@Param("id") long id);
    List<Seller> findByInitials(@Param("initials") String initials);
    List<Seller> findAllSeller();
    List<Seller> addNewSellerEnt(@Param("seller") Seller seller);
    List<Seller> updateSellerById(@Param("id") long id, @Param("seller") Seller seller);
    void deleteSellerById(@Param("id") long id);
}
