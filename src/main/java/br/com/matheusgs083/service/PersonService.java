package br.com.matheusgs083.service;

import br.com.matheusgs083.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());


    public Person fingById(String Id){
        logger.info("finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setName("Matheus");
        person.setGender("Male");

        return person;
    }

    public List<Person> findALl(){
        logger.info("finding all people!");
        List<Person> persons = new ArrayList<Person>();
        for(int i = 0; i < 10; i++){
            Person person = new Person();
            person.setId(counter.incrementAndGet());
            person.setName("Matheus");
            person.setGender("Male");
            persons.add(person);
        }
        return persons;
    }

    public Person create(Person person){
        logger.info("Creating one person");

        return person;
    }

    public Person update(Person person){
        logger.info("Updating one person");

        return person;
    }

    public void delete(String id){
        logger.info("deleting one person");
    }

}
