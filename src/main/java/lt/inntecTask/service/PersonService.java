package lt.inntecTask.service;

import lt.inntecTask.models.Person;
import lt.inntecTask.repository.IPersonDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonService implements IPersonService {

    @Autowired
    private IPersonDao personDao;

    @Override
    public List<Person> personList() {
        return personDao.personList();
    }

    @Override
    public Person updatePerson(Person person) {
        return personDao.updatePerson(person);
    }
}
