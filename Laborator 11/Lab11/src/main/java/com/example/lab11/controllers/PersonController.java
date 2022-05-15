package com.example.lab11.controllers;

import com.example.lab11.entity.Person;
import com.example.lab11.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }

    @GetMapping("person/list")
    public List<Person> getUsers() {
        return personService.getUsers();
    }

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

    @PutMapping("person/update")
    public String updateUser(@RequestParam String name) {
        Person person = personService.getPersonByName(name);
        if (person != null) {
            person.setName(name);
            personService.updatePerson(person);
            return "Person updated successfully";
        }
        return "Person does not exist";
    }

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

