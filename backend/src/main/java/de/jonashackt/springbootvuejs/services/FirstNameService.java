package de.jonashackt.springbootvuejs.services;

import de.jonashackt.springbootvuejs.model.Person.FirstName;

import java.util.List;

public interface FirstNameService {
    FirstName addOrGetFirstname(String firstName);
}
