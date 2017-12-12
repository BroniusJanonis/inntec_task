package lt.inntecTask.service;

import lt.inntecTask.models.Person;

import java.util.List;

public interface IPersonService {

    List<Person> personList();
    Person updatePerson(Person person);

}
