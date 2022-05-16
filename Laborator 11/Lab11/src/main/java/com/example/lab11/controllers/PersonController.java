package com.example.lab11.controllers;

import com.example.lab11.entity.Person;
import com.example.lab11.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * class PersonController
 * @authors: Petrea Daniela & Stoica Dragos
 */
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * creating a get mapping for the testing
     */

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }

    /**
     * creating a get mapping that retrieves all the persons detail from the database
     * @return a list with persons
     */

    @GetMapping("person/list")
    public List<Person> getUsers() {
        return personService.getUsers();
    }

    /**
     * creating post mapping that post the person detail in the database
     * @param name - name of the person
     * @return a message
     */
    @PostMapping("person/add")
    public String addUser(@RequestParam String name) {
        System.out.println(name);
        Person person = personService.getPersonByName(name);
        if (person != null) {
            return "Person already exists";
        }
        person = new Person();
        person.setName(name);
        personService.addPerson(person);
        return "Person added successfully";
    }

    /**
     * creating put mapping that updates the person name
     * @param name - actual name
     * @param name1 - updated name
     * @return a message
     */
    @PutMapping("person/update")
    public String updateUser(@RequestParam String name,@RequestParam String name1) {
        Person person = personService.getPersonByName(name);
        if (person != null) {
            personService.deletePerson(person);
            Person person1 = personService.getPersonByName(name);
            if (person1 == null) {
                person = new Person();
                person.setName(name1);
                personService.updatePerson(person);
                return "Person updated successfully";
            } else
                return "Person already exists";
        }
        return "Person does not exist";
    }

    /**
     * @param name - name of the person
     * @return a message
     */

    @DeleteMapping("person/delete")
    public String deleteUser(@RequestParam String name) {
        Person person = personService.getPersonByName(name);
        if (person != null) {
            personService.deletePerson(person);
            return "Person deleted successfully";
        }
        return "Person does not exist";
    }

}

