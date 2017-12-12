package lt.inntecTask.repository;

import lt.inntecTask.models.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PersonDaoTestIT {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PersonDao personDao;

    private List<Person> personList = new ArrayList<>();
    private Person person1 = new Person();
    private Person person2 = new Person();

    @Before
    public void setUp() throws Exception {
        ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection()
                ,new ClassPathResource("scripts/create/insert.sql"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date1 = sdf.parse("01-01-1987");
        java.util.Date date2 = sdf.parse("01-01-2007");
        java.sql.Date data1 = new java.sql.Date(date1.getTime());
        java.sql.Date data2 = new java.sql.Date(date2.getTime());

        person1 = new Person(1L, "person", "Petraitis", data1);
        person2 = new Person(1L, "son", "Petraitis", data2);
        personList.add(person1);
        personList.add(person2);
    }

    @After
    public void tearDown() throws Exception {
        ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection()
                ,new ClassPathResource("scripts/drop/delete.sql"));
    }

    @Test
    public void personList() throws Exception {
        assertEquals(personDao.personList().get(0).getDate(), personList.get(0).getDate());
        assertTrue(personDao.personList().size() > 0);
    }

    @Test
    public void updatePerson() throws Exception {
        String changedName = "NotPerson";
        person1.setName(changedName);

        assertEquals(personDao.updatePerson(person1).getName(), personDao.personList().get(0).getName());
        assertTrue(personDao.updatePerson(person1) != null);
    }

}