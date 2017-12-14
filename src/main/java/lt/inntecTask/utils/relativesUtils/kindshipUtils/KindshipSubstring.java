package lt.inntecTask.utils.relativesUtils.kindshipUtils;

import lt.inntecTask.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class KindshipSubstring {

    public boolean isMarriedWoman(Person person) {
        boolean pass = false;
        String surname = person.getSurname();
        if (surname.substring(surname.length() - 4).matches("ienė")) {
            pass = true;
        }
        return pass;
    }

    public boolean isMan(Person person) {
        boolean pass = false;
        String surname = person.getSurname();
        if (surname.substring(surname.length() - 1).matches("s")) {
            pass = true;
        }
        return pass;
    }

    public boolean isWoman(Person person) {
        boolean pass = false;
        String surname = person.getSurname();
        if (surname.substring(surname.length() - 1).matches("ė")) {
            pass = true;
        }
        return pass;
    }

    public boolean isRelatedByFirstSurname(Person relative, Person person) {
        boolean pass = false;
        String relativeSubstring = getFirstSurnameSubstring(relative);
        String personSubstring = getFirstSurnameSubstring(person);
        if (relativeSubstring.matches(personSubstring)) {
            pass = true;
        }
        return pass;
    }

    private String getFirstSurnameSubstring(Person relativeOrPerson) {
        String[] firstSurname = relativeOrPerson.getSurname().split("-");
        String surnameSubstring = getString(relativeOrPerson, firstSurname[0]);
        return surnameSubstring;
    }

    public boolean isRelatedBySecondSurname(Person relative, Person person) {
        boolean pass = false;
        String relativeSubstring = getSecondSurnameSubstring(relative);
        String personSubstring = getSecondSurnameSubstring(person);
        if (relativeSubstring.matches(personSubstring)) {
            pass = true;
        }
        return pass;
    }

    private String getSecondSurnameSubstring(Person relativeOrPerson) {
        String[] splittedSurname = relativeOrPerson.getSurname().split("-");
        String secondSurname = splittedSurname[splittedSurname.length-1];
        String surnameSubstring = getString(relativeOrPerson, secondSurname);
        return surnameSubstring;
    }

    private String getString(Person relativeOrPerson, String surname) {
        if (isWoman(relativeOrPerson) && surname.substring(surname.length() - 4).matches("ienė")) {
            return surname.substring(0, surname.length() - 4);
        } else if (isWoman(relativeOrPerson)) {
            return surname.substring(0, surname.length() - 3);
        }
        return surname.substring(0, surname.length() - 2);
    }


}
