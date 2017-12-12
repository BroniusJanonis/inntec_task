package lt.inntecTask.models;

import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person = new Person();

    @Test
    public void getId() throws Exception {
        long id = 1L;
        person.setId(id);
        assertEquals(person.getId(), id);
    }

    @Test
    public void setId() throws Exception {
        long id = 1L;
        person.setId(id);
        assertEquals(person.getId(), id);
    }

    @Test
    public void getName() throws Exception {
        String name = "person";
        person.setName(name);
        assertEquals(person.getName(), name);
    }

    @Test
    public void setName() throws Exception {
        String name = "person";
        person.setName(name);
        assertEquals(person.getName(), name);
    }

    @Test
    public void getSurname() throws Exception {
        String surname = "personsurname";
        person.setSurname(surname);
        assertEquals(person.getSurname(), surname);
    }

    @Test
    public void setSurname() throws Exception {
        String surname = "personsurname";
        person.setSurname(surname);
        assertEquals(person.getSurname(), surname);
    }

    @Test
    public void getDate() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = sdf.parse("01-01-1987");
        java.sql.Date data = new java.sql.Date(date.getTime());
        person.setDate(data);

        assertEquals(person.getDate(), data);
    }

    @Test
    public void setDate() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = sdf.parse("01-01-1987");
        java.sql.Date data = new java.sql.Date(date.getTime());
        person.setDate(data);

        assertEquals(person.getDate(), data);
    }

}