package de.jonashackt.springbootvuejs.services;

import de.jonashackt.springbootvuejs.model.Person.LastName;
import de.jonashackt.springbootvuejs.repository.LastNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LastNameServiceImp implements LastNameService {

    @Autowired
    LastNameRepository lastNameRepository;

    @Override
    public LastName addOrGetLastname(String lastName) {
        LastName lastNames = lastNameRepository.findByLastName(lastName);
        if(lastNames == null){
            return lastNameRepository.save(new LastName(lastName));
        }
        return lastNames;
    }
}
