package lt.inntecTask.utils.relativesUtils.kindshipUtils;

import lt.inntecTask.models.Person;

public class KindshipSubstring {

    public boolean isUnmarriedWoman(Person person){
        boolean pass = false;
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

    public boolean isMarriedWoman(Person person){
        boolean pass = false;
        String surname = person.getSurname();
        if(surname.substring(surname.length()-4).matches("ienė"))
        {
            pass = true;
        }
        return pass;
    }


    public boolean isMan(Person person){
        boolean pass = false;
        String surname = person.getSurname();
        if(surname.substring(surname.length()-1).matches("s"))
        {
            pass = true;
        }
        return pass;
    }

}
