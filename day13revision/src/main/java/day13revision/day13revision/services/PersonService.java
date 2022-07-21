package day13revision.day13revision.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import day13revision.day13revision.models.Person;

@Service
public class PersonService {
    public List<Person> persons = new ArrayList<>();

    public PersonService() {
        persons.add(new Person("Kai Kein", "Woo"));
        persons.add(new Person("Joey", "Low"));
        persons.add(new Person("Mark", "Musk"));
    }

    public void setPersons(Person p) {
        persons.add(new Person(p.getFirstName(), p.getLastName()));
    }

    public List<Person> getPersons() {
        return persons;
    }

}
