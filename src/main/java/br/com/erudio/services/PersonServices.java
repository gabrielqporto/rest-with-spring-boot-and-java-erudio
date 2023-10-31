package br.com.erudio.services;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding one person!");
        return repository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return repository.save(person);
    }
    public Person update(Person person) {
        logger.info("Updating one person!");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        
        entity.setFirstName("Gabriel");
        entity.setLastName("Porto");
        entity.setAddress("Guarulhos - São Paulo - Brasil");
        entity.setGender("Male");

        return repository.save(person);
    }
    public void delete(String id) {
        logger.info("Deleting one person!");
    }

    public Person findById(Long id) {

        logger.info("finding one Perdson!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId((counter.incrementAndGet()));
        person.setFirstName("Person name: " + i);
        person.setLastName("Last name: " + i);
        person.setAddress("Some address in Brazil: " + i);
        person.setGender("Male");
        return person;
    }
}
