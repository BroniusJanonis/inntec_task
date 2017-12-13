package lt.inntecTask.modelsDTO;

import lt.inntecTask.models.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RelativesDTOTest {

    private RelativesDTO relativesDTO = new RelativesDTO();
    private List<Person> personList = new ArrayList<>();
    private Person person = new Person();

    @Before
    public void setUp() throws Exception {
        personList.add(person);
    }

    @Test
    public void getSon() throws Exception {
        relativesDTO.setSon(personList);
        assertEquals(relativesDTO.getSon(), personList);
    }

    @Test
    public void setSon() throws Exception {
        relativesDTO.setSon(personList);
        assertEquals(relativesDTO.getSon(), personList);
    }

    @Test
    public void getDaughter() throws Exception {
        relativesDTO.setDaughter(personList);
        assertEquals(relativesDTO.getDaughter(), personList);
    }

    @Test
    public void setDaughter() throws Exception {
        relativesDTO.setDaughter(personList);
        assertEquals(relativesDTO.getDaughter(), personList);
    }

    @Test
    public void getHusband() throws Exception {
        relativesDTO.setHusband(personList);
        assertEquals(relativesDTO.getHusband(), personList);
    }

    @Test
    public void setHusband() throws Exception {
        relativesDTO.setHusband(personList);
        assertEquals(relativesDTO.getHusband(), personList);
    }

    @Test
    public void getWife() throws Exception {
        relativesDTO.setWife(personList);
        assertEquals(relativesDTO.getWife(), personList);
    }

    @Test
    public void setWife() throws Exception {
        relativesDTO.setHusband(personList);
        assertEquals(relativesDTO.getHusband(), personList);
    }

    @Test
    public void getFather() throws Exception {
        relativesDTO.setFather(personList);
        assertEquals(relativesDTO.getFather(), personList);
    }

    @Test
    public void setFather() throws Exception {
        relativesDTO.setFather(personList);
        assertEquals(relativesDTO.getFather(), personList);
    }

    @Test
    public void getMother() throws Exception {
        relativesDTO.setMother(personList);
        assertEquals(relativesDTO.getMother(), personList);
    }

    @Test
    public void setMother() throws Exception {
        relativesDTO.setMother(personList);
        assertEquals(relativesDTO.getMother(), personList);
    }

    @Test
    public void getGrandfather() throws Exception {
        relativesDTO.setGrandfather(personList);
        assertEquals(relativesDTO.getGrandfather(), personList);
    }

    @Test
    public void setGrandfather() throws Exception {
        relativesDTO.setGrandfather(personList);
        assertEquals(relativesDTO.getGrandfather(), personList);
    }

    @Test
    public void getGrandmother() throws Exception {
        relativesDTO.setGrandmother(personList);
        assertEquals(relativesDTO.getGrandmother(), personList);
    }

    @Test
    public void setGrandmother() throws Exception {
        relativesDTO.setGrandmother(personList);
        assertEquals(relativesDTO.getGrandmother(), personList);
    }

    @Test
    public void getBrother() throws Exception {
        relativesDTO.setBrother(personList);
        assertEquals(relativesDTO.getBrother(), personList);
    }

    @Test
    public void setBrother() throws Exception {
        relativesDTO.setBrother(personList);
        assertEquals(relativesDTO.getBrother(), personList);
    }

    @Test
    public void getSister() throws Exception {
        relativesDTO.setSister(personList);
        assertEquals(relativesDTO.getSister(), personList);
    }

    @Test
    public void setSister() throws Exception {
        relativesDTO.setSister(personList);
        assertEquals(relativesDTO.getSister(), personList);
    }

    @Test
    public void getGrandSon() throws Exception {
        relativesDTO.setGrandSon(personList);
        assertEquals(relativesDTO.getGrandSon(), personList);
    }

    @Test
    public void setGrandSon() throws Exception {
        relativesDTO.setGrandSon(personList);
        assertEquals(relativesDTO.getGrandSon(), personList);
    }

    @Test
    public void getGrandDaughter() throws Exception {
        relativesDTO.setGrandDaughter(personList);
        assertEquals(relativesDTO.getGrandDaughter(), personList);
    }

    @Test
    public void setGrandDaughter() throws Exception {
        relativesDTO.setGrandDaughter(personList);
        assertEquals(relativesDTO.getGrandDaughter(), personList);
    }

}