package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.model.Person.FirstName;
import de.jonashackt.springbootvuejs.model.Person.LastName;
import de.jonashackt.springbootvuejs.model.Seller;
import de.jonashackt.springbootvuejs.repository.SellerRepository;
import de.jonashackt.springbootvuejs.services.FirstNameServiceImp;
import de.jonashackt.springbootvuejs.services.LastNameServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class SellerController {

    private static final Logger LOG = LoggerFactory.getLogger(SellerController.class);

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private FirstNameServiceImp firstNameServiceImp;

    @Autowired
    private LastNameServiceImp lastNameServiceImp;


    @RequestMapping(path = "/sellers", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody long addNewSeller (@RequestParam FirstName firstName, @RequestParam LastName lastName, @RequestParam String initials) {
        if((!(firstName.equals("") || lastName.equals("") || initials.equals("") || firstName == null || lastName == null || initials == null))){

            if(sellerRepository.existsByFirstNameAndLastName(firstName.getFirstName(),lastName.getLastName()) || sellerRepository.existsByInitials(initials)){
                throw new ExceptionNotFound();
            }

            Seller seller = new Seller(
                    firstNameServiceImp.addOrGetFirstname(firstName.getFirstName()),
                    lastNameServiceImp.addOrGetLastname(lastName.getLastName()),
                    initials
            );
            sellerRepository.save(seller);

            LOG.info(seller.toString() + " successfully saved into DB");

            return seller.getId();
        }
        throw new ExceptionBadGateway();
    }


    @RequestMapping(path = "/sellers", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Seller> GetAllSeller () {
        List<Seller> sellers = sellerRepository.findAll();
        return sellers;
    }

    @GetMapping(path="/sellers/{id}")
    public @ResponseBody Seller getSellerById(@PathVariable("id") long id) {
        LOG.info("Reading user with id " + id + " from database.");
        return sellerRepository.findById(id).get();
    }

}
