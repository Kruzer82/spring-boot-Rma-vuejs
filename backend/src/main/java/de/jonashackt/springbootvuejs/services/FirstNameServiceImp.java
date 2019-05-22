package de.jonashackt.springbootvuejs.services;

import de.jonashackt.springbootvuejs.model.Person.FirstName;
import de.jonashackt.springbootvuejs.repository.FirstNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstNameServiceImp implements FirstNameService {

    @Autowired
    FirstNameRepository firstNameRepository;

    @Override
    public FirstName addOrGetFirstname(String firstName) {
        FirstName firstNames = firstNameRepository.findByFirstName(firstName);
        if(firstNames == null){
            System.out.println("1: add");
            return firstNameRepository.save(new FirstName(firstName));
        }
        System.out.println("2: " + firstNames.getId() );
        return firstNames;
    }
}
