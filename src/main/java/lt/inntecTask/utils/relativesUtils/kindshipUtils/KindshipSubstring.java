package lt.inntecTask.utils.relativesUtils.kindshipUtils;

import lt.inntecTask.models.Person;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class KindshipSubstring {

    private String bothShouldContain = "";
    private String bothShouldNotContain = "";

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

//    public boolean isRelateive(Person relative, Person person) {
//        boolean pass = false;
//
//        String[] splittedRelativeSurname = relative.getSurname().split("-");
//        String[] splittedPersonSurname = person.getSurname().split("-");
//
//        for (String rltv : splittedRelativeSurname) {
//            for (String prsn : splittedPersonSurname) {
//                if (surnameSubstringMatches(rltv, prsn)) {
//                    return true;
//                }
//            }
//        }
//
//        return pass;
//    }
//
//    private boolean surnameSubstringMatches(String relativeSurname, String personSurname) {
//        boolean pass = false;
//
//        String rltvSurname = relativeSurname.replaceAll("(ienė|aitė|ūtė|ytė|is|s)$", "");
//        String prsnSurname = personSurname.replaceAll("(ienė|aitė|ūtė|ytė|is|s)$", "");
//        if (rltvSurname.matches(prsnSurname)) {
//            return true;
//        }
//
//        return pass;
//    }



    public boolean isBrotherOrSister(Person relative, Person person) {
        boolean pass = false;
        bothShouldContain = "(aitė|ūtė|ytė|is|s)$";
        bothShouldNotContain = "(ienė)$";

        shouldNotMatchAtEnding(relative, person, bothShouldNotContain);


        if (relativesMatcherLoop(relative, person, bothShouldContain)
                && shouldNotMatchAtEnding(relative, person, bothShouldNotContain)) return true;

        return pass;
    }

    public boolean isSpouse(Person relative, Person person) {
        boolean pass = false;
        bothShouldContain = "(ienė|is|s)$";
        bothShouldNotContain = "(aitė|ūtė|ytė)$";

        if (relativesMatcherLoop(relative, person, bothShouldContain)
                && shouldNotMatchAtEnding(relative, person, bothShouldNotContain))return true;

        return pass;
    }

    public boolean isNoSpouseNoSibling(Person relative, Person person) {
        boolean pass = false;
        bothShouldContain = "(ienė|is|s|aitė|ūtė|ytė)$";

        if (relativesMatcherLoop(relative, person, bothShouldContain)
                && (!containsTheSameSurname(relative, person) || !isWoman(person))
                )return true;

        return pass;
    }


    private boolean relativesMatcherLoop(Person relative, Person person, String regexParse) {
        String[] splittedRelativeSurname = relative.getSurname().split("-");
        String[] splittedPersonSurname = person.getSurname().split("-");

        for (String rltv : splittedRelativeSurname) {
            for (String prsn : splittedPersonSurname) {
                if (compareSurnamesSubstring(rltv, prsn, regexParse)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean compareSurnamesSubstring(String relativeSurname, String personSurname, String regexParse) {
        boolean pass = false;

        String rltvSurname = relativeSurname.replaceAll(regexParse, "");
        String prsnSurname = personSurname.replaceAll(regexParse, "");
        if (rltvSurname.matches(prsnSurname)) {
            return true;
        }

        return pass;
    }

    private boolean shouldNotMatchAtEnding(Person relative, Person person, String regexShouldNotContains) {
        String[] splittedRelativeSurname = relative.getSurname().split("-");
        String[] splittedPersonSurname = person.getSurname().split("-");
        String lastRelativeSurname = splittedRelativeSurname[splittedRelativeSurname.length-1];
        String lastPersonSurname = splittedPersonSurname[splittedPersonSurname.length-1];
        Pattern patern = Pattern.compile(regexShouldNotContains);
        if (patern.matcher(lastRelativeSurname).find()
                && patern.matcher(lastPersonSurname).find()) {
            return !true;
        }
        return !false;
    }

    private boolean containsTheSameSurname(Person relative, Person person) {

        String[] splittedRelativeSurname = relative.getSurname().split("-");
        String[] splittedPersonSurname = person.getSurname().split("-");

        for (String rltv : splittedRelativeSurname) {
            for (String prsn : splittedPersonSurname) {
                if (rltv.matches(prsn)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isDaugtherGrandDaughter(Person relative, Person person) {
        boolean pass = false;
        bothShouldContain = "(aitė|ūtė|ytė|is|s)$";
        bothShouldNotContain = "(ienė)$";

        if (relativesMatcherLoop(relative, person, bothShouldContain)
                && shouldNotMatchAtEnding(relative, person, bothShouldNotContain))return true;

        return pass;
    }

    public boolean isSonGrandSon(Person relative, Person person) {
        boolean pass = false;
        bothShouldContain = "(ienė|is|s)$";
        bothShouldNotContain = "(aitė|ūtė|ytė)$";

        if (relativesMatcherLoop(relative, person, bothShouldContain)
                && shouldNotMatchAtEnding(relative, person, bothShouldNotContain))return true;

        return pass;
    }



}
