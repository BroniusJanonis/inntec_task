package lt.inntecTask.repository;

import lt.inntecTask.models.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonDao implements IPersonDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> personList() {
        String sqlListPerson = "SELECT * FROM inntec_person";
        List<Person> resultList = entityManager.createNativeQuery(sqlListPerson, Person.class).getResultList();
        return resultList;
    }

    @Override
    public Person updatePerson(Person person) {
        String sqlUpdatePageModel = "UPDATE inntec_person SET name='"+person.getName()+"'" +
                ", surname='"+person.getSurname()+"', date='"+person.getDate()+"' WHERE id="+person.getId();
        Person updated = entityManager.merge(person);
        return updated;
    }
}
