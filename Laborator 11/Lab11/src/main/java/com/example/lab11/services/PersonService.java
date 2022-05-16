package com.example.lab11.services;
import com.example.lab11.entity.Person;
import com.example.lab11.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * class PersonService
 * authors: Petrea Daniela & Stoica Dragos
 */
@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * find a person by name implementing the method findPersonByName
     * @param name - name of the person
     * @return the person with the given name, else null
     */
    public Person getPersonByName(String name) {
        return personRepository.findPersonByName(name);
    }

    /**
     * getting all users record by using the method findaAll() of CrudRepository
     */

    public List<Person> getUsers() {
        return personRepository.findAll();
    }

    /**
     * saving a specific record by using the method save() of CrudRepository
     * @param person
     */

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    /**
     * updating a record
     * @param person
     */

    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    /**
     * deleting a specific record by using the method delete() of CrudRepository
     * @param person
     */

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

}
