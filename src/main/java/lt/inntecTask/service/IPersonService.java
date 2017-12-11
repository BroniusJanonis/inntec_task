package lt.inntecTask.service;

import lt.inntecTask.models.Person;

import java.util.List;

public interface IPersonService {

    List<Person> personList();
    int updatePerson(Person person);

}
