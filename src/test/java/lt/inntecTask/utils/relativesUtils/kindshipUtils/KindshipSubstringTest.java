package lt.inntecTask.utils.relativesUtils.kindshipUtils;

import lt.inntecTask.models.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class KindshipSubstringTest {


    KindshipSubstring kindshipSubstring = new KindshipSubstring();
    private Person person = new Person();
    private String mensSurname = "Petraitis";
    private String singleWomansOneSurname = "Petraitytė";
    private String marriedWomansOneSurname = "Petraitienė";
    private String marriedWomansTwoSurnameBegining1 = "Petraitytė-Onutienė";
    private String marriedWomansTwoSurnameBegiging2 = "Petraitytė-Testutienė";
    private String marriedWomanTwoSurnameEnding = "Testutytė-Petraitienė";
    private String NonRelativeWomanOneSurname1 = "Onutytė";
    private String NonRelativeWomanOneSurname2 = "Onutytienė";
    private String NonRelativeWomanTwoSurname1 = "Testutytė-Onutienė";

    @Test
    public void isMan() throws Exception {
        person.setSurname(singleWomansOneSurname);
        assertFalse(kindshipSubstring.isMan(person));
        person.setSurname(mensSurname);
        assertTrue(kindshipSubstring.isMan(person));
    }

    @Test
    public void isWoman() throws Exception {
        person.setSurname(mensSurname);
        assertFalse(kindshipSubstring.isWoman(person));
        person.setSurname(singleWomansOneSurname);
        assertTrue(kindshipSubstring.isWoman(person));
    }

    @Test
    public void isRelateive() throws Exception {
    }

    @Test
    public void isBrotherOrSister() throws Exception {
        Person person = new Person();
        person.setSurname(marriedWomanTwoSurnameEnding);
        Person relative = new Person();
        relative.setSurname(singleWomansOneSurname);
        assertFalse(kindshipSubstring.isBrotherOrSister(relative, person));
        relative.setSurname(mensSurname);
        assertFalse(kindshipSubstring.isBrotherOrSister(relative, person));
        relative.setSurname(marriedWomansOneSurname);
        assertFalse(kindshipSubstring.isBrotherOrSister(relative, person));
        relative.setSurname(marriedWomansTwoSurnameBegiging2);
        assertFalse(kindshipSubstring.isBrotherOrSister(relative, person));
        relative.setSurname(NonRelativeWomanOneSurname1);
        assertFalse(kindshipSubstring.isBrotherOrSister(relative, person));
        relative.setSurname(NonRelativeWomanOneSurname2);
        assertFalse(kindshipSubstring.isBrotherOrSister(relative, person));
        relative.setSurname(NonRelativeWomanTwoSurname1);
        assertFalse(kindshipSubstring.isBrotherOrSister(relative, person));
        relative.setSurname(marriedWomansTwoSurnameBegining1);
        assertFalse(kindshipSubstring.isBrotherOrSister(relative, person));
        person.setSurname(mensSurname);
        assertTrue(kindshipSubstring.isBrotherOrSister(person, person));
    }

    @Test
    public void isSpouse() throws Exception {
        Person person = new Person();
        person.setSurname(mensSurname);
        Person relative = new Person();
        relative.setSurname(marriedWomansOneSurname);
        assertTrue(kindshipSubstring.isSpouse(relative, person));
        relative.setSurname(marriedWomanTwoSurnameEnding);
        assertTrue(kindshipSubstring.isSpouse(relative, person));
        relative.setSurname(marriedWomansOneSurname);
        assertTrue(kindshipSubstring.isSpouse(relative, person));
        relative.setSurname(singleWomansOneSurname);
        assertFalse(kindshipSubstring.isSpouse(relative, person));
        relative.setSurname(marriedWomansTwoSurnameBegiging2);
        assertFalse(kindshipSubstring.isSpouse(relative, person));
        relative.setSurname(NonRelativeWomanOneSurname1);
        assertFalse(kindshipSubstring.isSpouse(relative, person));
        relative.setSurname(NonRelativeWomanOneSurname2);
        assertFalse(kindshipSubstring.isSpouse(relative, person));
        relative.setSurname(NonRelativeWomanTwoSurname1);
        assertFalse(kindshipSubstring.isSpouse(relative, person));
    }

    @Test
    public void isNoSpouceNoSibling() throws Exception {
        Person person = new Person();
        person.setSurname(marriedWomansTwoSurnameBegining1);
        Person relative = new Person();
        relative.setSurname(mensSurname);
        assertTrue(kindshipSubstring.isNoSpouseNoSibling(relative, person));
        relative.setSurname(marriedWomansOneSurname);
        assertTrue(kindshipSubstring.isNoSpouseNoSibling(relative, person));
        relative.setSurname(marriedWomanTwoSurnameEnding);
        assertTrue(kindshipSubstring.isNoSpouseNoSibling(relative, person));
        relative.setSurname(NonRelativeWomanOneSurname1);
        assertTrue(kindshipSubstring.isNoSpouseNoSibling(relative, person));
        relative.setSurname(NonRelativeWomanTwoSurname1);
        assertFalse(kindshipSubstring.isNoSpouseNoSibling(relative, person));
        relative.setSurname(NonRelativeWomanOneSurname2);
        assertFalse(kindshipSubstring.isNoSpouseNoSibling(relative, person));
        relative.setSurname(marriedWomansTwoSurnameBegiging2);
        assertFalse(kindshipSubstring.isNoSpouseNoSibling(relative, person));
        relative.setSurname(singleWomansOneSurname);
        assertFalse(kindshipSubstring.isNoSpouseNoSibling(relative, person));
    }

}