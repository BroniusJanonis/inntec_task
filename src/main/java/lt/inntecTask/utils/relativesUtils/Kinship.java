package lt.inntecTask.utils.relativesUtils;

import lt.inntecTask.models.Person;
import lt.inntecTask.utils.relativesUtils.kindshipUtils.KindshipSubstring;
import lt.inntecTask.utils.relativesUtils.kindshipUtils.YearsSubtraction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kinship {

    private List<Person> prsnList = new ArrayList<>();
    private KindshipSubstring relative = new KindshipSubstring();
    private YearsSubtraction yearsSubtraction = new YearsSubtraction();

    List<Person> isSon (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(person.getDate(), s.getDate()) >= 16
                        && yearsSubtraction.yearsGap(person.getDate(), s.getDate()) <= 40
                        && relative.isMan(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    List<Person> isDaugther (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(person.getDate(), s.getDate()) >= 16
                        && yearsSubtraction.yearsGap(person.getDate(), s.getDate()) <= 40
                        && relative.isUnmarriedWoman(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    List<Person> isFather (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 16
                        && yearsSubtraction.yearsGap(s.getDate(), person.getDate()) <= 40
                        && yearsSubtraction.firstIsOlder(s.getDate(), person.getDate())
                        && relative.isMan(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    List<Person> isMother (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 16
                        && yearsSubtraction.yearsGap(s.getDate(), person.getDate()) <= 40
                        && relative.isMarriedWoman(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    List<Person> isBrother (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 0
                        && yearsSubtraction.yearsGap(s.getDate(), person.getDate()) <= 15
                        && relative.isMan(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    List<Person> isSister (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 0
                        && yearsSubtraction.yearsGap(s.getDate(), person.getDate()) <= 15
                        && relative.isUnmarriedWoman(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    List<Person> isWife (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 0
                        && yearsSubtraction.yearsGap(s.getDate(), person.getDate()) <= 15
                        && relative.isMarriedWoman(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    List<Person> isHusband (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 0
                        && yearsSubtraction.yearsGap(s.getDate(), person.getDate()) <= 15
                        && relative.isMan(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    List<Person> isGrandSon (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 41
                        && relative.isMan(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    List<Person> isGrandDaugther (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 41
                        && relative.isUnmarriedWoman(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    List<Person> isGrandFather (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(person.getDate(), s.getDate()) >= 41
                        && relative.isMan(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    List<Person> isGrandMother (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(person.getDate(), s.getDate()) >= 41
                        && relative.isMarriedWoman(s))
                .collect(Collectors.toList());
        return prsnList;
    }



//    private int yearsGap(Date firstYear, Date secondYear) {
//        // YODA time
////        LocalDate prsnYear = LocalDate.fromDateFields(firstYear);
////        LocalDate rltvYear = LocalDate.fromDateFields(secondYear);
////
////        Period period = new Period(prsnYear, rltvYear);
////        long diff = Math.abs(period.getYears());
//
//
//        long diff = 0;
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
//
//            java.util.Date firstDate = sdf.parse(String.valueOf(firstYear));
//            java.util.Date secondDate = sdf.parse(String.valueOf(secondYear));
//
//            long diffInMillies = Math.abs(firstDate.getTime() - secondDate.getTime());
//            diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) / 365;
//        }catch (Exception ex){
//            System.out.println("Date difference exception: " + ex);
//        }
//
//        return (int) diff;
//    }

}
