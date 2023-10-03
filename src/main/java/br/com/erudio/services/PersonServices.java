package br.com.erudio.services;

import br.com.erudio.model.Person;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {

        logger.info("finding one Perdson!");

        Person person = new Person();
        person.setId((counter.incrementAndGet()));
        person.setFirstName("Gabriel");
        person.setLastName("Porto");
        person.setAddress("Guarulhos - São Paulo - Brasil");
        person.setGender("Male");
        return person;
    }
}
