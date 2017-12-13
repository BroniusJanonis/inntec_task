package lt.inntecTask.utils.relativesUtils;

import lt.inntecTask.models.Person;
import lt.inntecTask.utils.relativesUtils.kindshipUtils.KindshipSubstring;
import lt.inntecTask.utils.relativesUtils.kindshipUtils.YearsSubtraction;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class KinshipTest {

    Kinship kinship = new Kinship();
    Person personMan = new Person();
    Person personWoman = new Person();
    List<Person> personList = new ArrayList<>();

    Person son = new Person(2, "son", "Petraitis", getDate("01-01-2007"));
    Person daughter = new Person(3, "daughter", "Petraitytė", getDate("01-01-2008"));
    Person brother = new Person(4, "brother", "Petraitis", getDate("01-01-1992"));
    Person sister = new Person(5, "sister", "Petraitytė", getDate("01-01-1995"));
    Person father = new Person(6, "father", "Petraitis", getDate("01-01-1965"));
    Person mother = new Person(7, "mother", "Petraitienė", getDate("01-01-1967"));
    Person husband = new Person(8, "husband", "Petraitis", getDate("01-01-1985"));
    Person wife = new Person(9, "wife", "Petraitienė", getDate("01-01-1989"));
    Person grandfather = new Person(10, "grandfather", "Petraitis", getDate("01-01-1944"));
    Person grandmother = new Person(11, "grandmother", "Petraitienė", getDate("01-01-1942"));
    Person grandson = new Person(12, "grandson", "Petraitis", getDate("01-01-2030"));
    Person granddaughter = new Person(13, "granddaughter", "Petraitytė", getDate("01-01-2032"));

    public KinshipTest() throws ParseException {
    }

    @Before
    public void setUp() throws Exception {
        personMan = new Person(1, "person", "Petraitis", getDate("01-01-1987"));
        personWoman = new Person(1, "person", "Petraitienė", getDate("01-01-1987"));

        personList.add(son);
        personList.add(daughter);
        personList.add(brother);
        personList.add(sister);
        personList.add(father);
        personList.add(mother);
        personList.add(husband);
        personList.add(wife);
        personList.add(grandfather);
        personList.add(grandmother);
        personList.add(grandson);
        personList.add(granddaughter);
    }

    @Test
    public void isSon() throws Exception {
        assertEquals(kinship.isSon(personList, personMan).get(0), son);
    }

    @Test
    public void isDaugther() throws Exception {
        assertEquals(kinship.isDaugther(personList, personMan).get(0), daughter);
    }

    @Test
    public void isFather() throws Exception {
        assertEquals(kinship.isFather(personList, personMan).get(0), father);
    }

    @Test
    public void isMother() throws Exception {
        assertEquals(kinship.isMother(personList, personMan).get(0), mother);
    }

    @Test
    public void isBrother() throws Exception {
        assertEquals(kinship.isBrother(personList, personMan).get(0), brother);
    }

    @Test
    public void isSister() throws Exception {
        assertEquals(kinship.isSister(personList, personMan).get(0), sister);
    }

    @Test
    public void isWife() throws Exception {
        assertEquals(kinship.isWife(personList, personMan).get(0), wife);
    }

    // Because of Husband and husband's brother is hard to define withou relationship tables, it finds two persons
    @Test
    public void isHusband() throws Exception {
        assertEquals(kinship.isHusband(personList, personWoman).get(1), husband);
    }

    @Test
    public void isGrandSon() throws Exception {
        assertEquals(kinship.isGrandSon(personList, personMan).get(0), grandson);
    }

    @Test
    public void isGrandDaugther() throws Exception {
        assertEquals(kinship.isGrandDaugther(personList, personMan).get(0), granddaughter);
    }

    @Test
    public void isGrandFather() throws Exception {
        assertEquals(kinship.isGrandFather(personList, personMan).get(0), grandfather);
    }

    @Test
    public void isGrandMother() throws Exception {
        assertEquals(kinship.isGrandMother(personList, personMan).get(0), grandmother);
    }

    private Date getDate(String givenYears) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        long timeToLong = format.parse(givenYears).getTime();
        return new Date(timeToLong);
    }

}