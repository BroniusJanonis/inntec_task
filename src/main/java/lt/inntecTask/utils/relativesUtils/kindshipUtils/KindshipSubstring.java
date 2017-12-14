package lt.inntecTask.utils.relativesUtils.kindshipUtils;

import lt.inntecTask.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class KindshipSubstring {


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

    public boolean isRelateive(Person relative, Person person) {
        boolean pass = false;

        String[] splittedRelativeSurname = relative.getSurname().split("-");
        String[] splittedPersonSurname = person.getSurname().split("-");

        for (String rltv : splittedRelativeSurname) {
            for (String prsn : splittedPersonSurname) {
                if (surnameSubstringMatches(rltv, prsn)) {
                    return true;
                }
            }
        }

        return pass;
    }

    private boolean surnameSubstringMatches(String relativeSurname, String personSurname) {
        boolean pass = false;

        String rltvSurname = relativeSurname.replaceAll("(ienė|aitė|ūtė|ytė|is|s)$", "");
        String prsnSurname = personSurname.replaceAll("(ienė|aitė|ūtė|ytė|is|s)$", "");
        if (rltvSurname.matches(prsnSurname)) {
            return true;
        }

        return pass;
    }

    public boolean isSpouse(Person relative, Person person) {
        boolean pass = false;
        String[] splittedRelativeSurname = relative.getSurname().split("-");
        String[] splittedPersonSurname = person.getSurname().split("-");
        String lastRelativeSurname = splittedRelativeSurname[splittedRelativeSurname.length-1];
        String lastPersonSurname = splittedPersonSurname[splittedPersonSurname.length-1];
        Pattern patern = Pattern.compile("(ienė)$");
        if (surnameSubstringMatches(lastRelativeSurname, lastPersonSurname)
                && patern.matcher(lastRelativeSurname).find()
                || patern.matcher(lastPersonSurname).find()) {
            return true;
        }

        return pass;
    }



//    public boolean isBrotherSister(Person relative, Person person) {
//        boolean pass = false;
//
//        String[] splittedRelativeSurname = relative.getSurname().split("-");
//        String[] splittedPersonSurname = person.getSurname().split("-");
//
//        for (String rltv : splittedRelativeSurname) {
//            for (String prsn : splittedPersonSurname) {
//                if (brotherSisterMatcher(rltv, prsn)) {
//                    return true;
//                }
//            }
//        }
//
//        return pass;
//    }
//
//    private boolean brotherSisterMatcher(String relativeSurname, String personSurname) {
//        boolean pass = false;
//
//        String rltvSurname = relativeSurname.replaceAll("(aitė|ūtė|ytė|is|s)$", "");
//        String prsnSurname = personSurname.replaceAll("(aitė|ūtė|ytė|is|s)$", "");
//        if (rltvSurname.matches(prsnSurname)
//                && isRelateiveTest(relativeSurname, personSurname)) {
//            return true;
//        }
//
//        return pass;
//    }
//
//    public boolean isParentChildren(Person relative, Person person) {
//        boolean pass = false;
//
//        String[] splittedRelativeSurname = relative.getSurname().split("-");
//        String[] splittedPersonSurname = person.getSurname().split("-");
//
//        for (String rltv : splittedRelativeSurname) {
//            for (String prsn : splittedPersonSurname) {
//                if (parentChildrenMatcher(rltv, prsn)) {
//                    return true;
//                }
//            }
//        }
//
//        return pass;
//    }
//
//    private boolean parentChildrenMatcher(String relativeSurname, String personSurname) {
//        boolean pass = false;
//
//        String rltvSurname = relativeSurname.replaceAll("(aitė|ūtė|ytė|is|s)$", "");
//        String prsnSurname = personSurname.replaceAll("(aitė|ūtė|ytė|is|s)$", "");
//        if (rltvSurname.matches(prsnSurname)
//                && isRelateiveTest(relativeSurname, personSurname)) {
//            return true;
//        }
//
//        return pass;
//    }
//
//    public boolean isRelateiveTest(String relative, String person) {
//        boolean pass = false;
//
//        String[] splittedRelativeSurname = relative.split("-");
//        String[] splittedPersonSurname = person.split("-");
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
//
//
//    public boolean isGrandparentChildren(Person relative, Person person) {
//        boolean pass = false;
//
//        String[] splittedRelativeSurname = relative.getSurname().split("-");
//        String[] splittedPersonSurname = person.getSurname().split("-");
//
//        for (String rltv : splittedRelativeSurname) {
//            for (String prsn : splittedPersonSurname) {
//                if (parentChildrenMatcher(rltv, prsn)) {
//                    return true;
//                }
//            }
//        }
//
//        return pass;
//    }
//
//    private boolean grandParentChildrenMatcher(String relativeSurname, String personSurname) {
//        boolean pass = false;
//
//        String rltvSurname = relativeSurname.replaceAll("(aitė|ūtė|ytė|is|s)$", "");
//        String prsnSurname = personSurname.replaceAll("(aitė|ūtė|ytė|is|s)$", "");
//        if (rltvSurname.matches(prsnSurname)
//                && isRelateiveTest(relativeSurname, personSurname)) {
//            return true;
//        }
//
//        return pass;
//    }



}
