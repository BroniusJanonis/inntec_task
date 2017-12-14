package lt.inntecTask.utils.relativesUtils.kindshipUtils;

import lt.inntecTask.models.Person;
import lt.inntecTask.utils.relativesUtils.kindshipUtils.KindshipSubstring;
import org.junit.Test;

import static org.junit.Assert.*;

public class KindshipSubstringTest {

    KindshipSubstring kindshipSubstring = new KindshipSubstring();
    private Person person = new Person();
    private String mensSurname = "Petraitis";
    private String womansOneSurname = "Petraitytė";
    private String marriedOneSurname = "Petraitytienė";
    private String womansTwoSurname = "Test-Petraitytė";
    private String marriedTwoSurname = "Test-Petraitytienė";

//    @Test
//    public void isMarriedWoman() throws Exception {
//        person.setSurname(womansOneSurname);
//        assertFalse(kindshipSubstring.isMarriedWoman(person));
//        person.setSurname(womansOneSurname);
//        assertTrue(kindshipSubstring.isMarriedWoman(person));
//    }

    @Test
    public void isMan() throws Exception {
        person.setSurname(marriedOneSurname);
        assertFalse(kindshipSubstring.isMan(person));
        person.setSurname(mensSurname);
        assertTrue(kindshipSubstring.isMan(person));
    }

    @Test
    public void isWoman() throws Exception {
        person.setSurname(mensSurname);
        assertFalse(kindshipSubstring.isWoman(person));
        person.setSurname(marriedOneSurname);
        assertTrue(kindshipSubstring.isWoman(person));
    }

//    @Test
//    public void isRelatedByFirstSurname() throws Exception {
//        Person firstPerson = new Person();
//        firstPerson.setSurname(marriedOneSurname);
//        Person secondPerson = new Person();
//        secondPerson.setSurname(mensSurname);
//        kindshipSubstring.isRelatedByFirstSurname(firstPerson, secondPerson);
//    }
//
//    @Test
//    public void isRelatedBySecondSurname() throws Exception {
//        Person firstPerson = new Person();
//        firstPerson.setSurname(marriedTwoSurname);
//        Person secondPerson = new Person();
//        secondPerson.setSurname(mensSurname);
//        Person thirdPerson = new Person();
//        thirdPerson.setSurname(womansTwoSurname);
//        kindshipSubstring.isRelatedByFirstSurname(firstPerson, secondPerson);
//        kindshipSubstring.isRelatedByFirstSurname(firstPerson, thirdPerson);
//    }


}