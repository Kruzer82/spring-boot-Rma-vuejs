package de.jonashackt.springbootvuejs.services;


import de.jonashackt.springbootvuejs.model.Seller;
import de.jonashackt.springbootvuejs.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Seller addOrGetSeller(Seller seller) {
        Seller fromDbSeller = (Seller) sellerRepository.findByFirstNameAndLastNameAndInitials(seller.getFirstName().getFirstName(),seller.getLastName().getLastName(),seller.getInitials());
        System.out.println("xx  " + fromDbSeller);
        if (fromDbSeller == null){
            return sellerRepository.save(seller);
        }
        return fromDbSeller;
    }

    @Override
    public List<Seller> findById(long id) {
        return (List<Seller>) sellerRepository.findById(id).orElse(new Seller());
    }

    @Override
    public List<Seller> findByInitials(String initials) {
        return sellerRepository.findByInitials(initials);
    }

    @Override
    public List<Seller> findAllSeller() {
        return sellerRepository.findAll();
    }

    @Override
    public List<Seller> addNewSellerEnt(Seller seller) {
        return (List<Seller>) sellerRepository.save(seller);
    }

    @Override
    public List<Seller> updateSellerById(long id, Seller seller) {
        Seller fromDbSeller = sellerRepository.findById(id).orElse(null);
        if(fromDbSeller != null){
            fromDbSeller.setFirstName(seller.getFirstName());
            fromDbSeller.setLastName(seller.getLastName());
            fromDbSeller.setInitials(seller.getInitials());
            return (List<Seller>) sellerRepository.save(fromDbSeller);
        }
        return null;
    }

    @Override
    public void deleteSellerById(long id) {
        sellerRepository.deleteById(id);
    }
}
