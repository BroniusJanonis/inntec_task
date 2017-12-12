package lt.inntecTask.utils;

import lt.inntecTask.models.Person;

public class KindshipSubstring {

    private boolean pass = false;

    boolean isUnmarriedWoman(Person person){
        String surname = person.getSurname();
        if(surname.substring(surname.length()-3).matches("ytė")
                || surname.substring(surname.length()-4).matches("aitė")
                || surname.substring(surname.length()-3).matches("ūtė")
           )
        {
            pass = true;
        }
        return pass;
    }

    boolean isMarriedWoman(Person person){
        String surname = person.getSurname();
        if(surname.substring(surname.length()-4).matches("ienė"))
        {
            pass = true;
        }
        return pass;
    }


    boolean isMan(Person person){
        String surname = person.getSurname();
        if(surname.substring(surname.length()-1).matches("s"))
        {
            pass = true;
        }
        return pass;
    }

}
