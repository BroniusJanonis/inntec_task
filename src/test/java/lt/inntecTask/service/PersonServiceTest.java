package lt.inntecTask.service;

import lt.inntecTask.models.Person;
import lt.inntecTask.repository.IPersonDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PersonServiceTest {

    private PersonService personService;
    @Mock
    private IPersonDao personDao;

    private List<Person> personList = new ArrayList<>();
    private Person person = new Person();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        personService = new PersonService(personDao);

        personList.add(person);
    }

    @Test
    public void personList() throws Exception {
        when(personDao.personList()).thenReturn(personList);
        assertEquals(personService.personList(), personList);
        verify(personDao, times(1)).personList();
    }

    @Test
    public void updatePerson() throws Exception {
        when(personDao.updatePerson(person)).thenReturn(person);
        assertEquals(personService.updatePerson(person), person);
        verify(personDao, times(1)).updatePerson(person);
    }

}