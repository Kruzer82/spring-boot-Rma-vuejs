package de.jonashackt.springbootvuejs.services;

import de.jonashackt.springbootvuejs.model.Person.LastName;

import java.util.List;

public interface LastNameService {
    LastName addOrGetLastname(String lastName);
}
