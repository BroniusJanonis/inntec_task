package lt.inntecTask.repository;

import lt.inntecTask.models.Person;

import java.util.List;

public interface IPersonDao {
    List<Person> personList();
    int updatePerson(Person person);
}
