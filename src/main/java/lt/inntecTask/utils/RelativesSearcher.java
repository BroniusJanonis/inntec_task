package lt.inntecTask.utils;

import lt.inntecTask.models.Person;
import lt.inntecTask.modelsDTO.RelativesDTO;
import org.joda.time.Period;
import org.springframework.stereotype.Component;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class RelativesSearcher {

    List<Person> prsnList = new ArrayList<>();

    public RelativesDTO relativesSearchByPeron(List<Person> personList, Person person) {
        RelativesDTO relativesDTO = new RelativesDTO();

        relativesDTO.setSon(new RelativesSearcher().isSon(personList, person));
        relativesDTO.setSon(new RelativesSearcher().isDaugther(personList, person));

//        senelis, senelė, anūkas, anūkė

        return relativesDTO;
    }


    private List<Person> isSon (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubstraction(person.getDate(), s.getDate()) >= 16
                        && yearsSubstraction(person.getDate(), s.getDate()) <= 40
                        && s.getSurname().substring(s.getSurname().length()-1).matches("s"))
                .collect(Collectors.toList());
        return prsnList;
    }

    private List<Person> isDaugther (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubstraction(person.getDate(), s.getDate()) >= 16
                        && yearsSubstraction(person.getDate(), s.getDate()) <= 40
                        && s.getSurname().substring(s.getSurname().length()-3).matches("ytė")
                        || s.getSurname().substring(s.getSurname().length()-4).matches("aitė")
                        || s.getSurname().substring(s.getSurname().length()-3).matches("ūtė"))
            .collect(Collectors.toList());
        return prsnList;
}

    private List<Person> isFather (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubstraction(s.getDate(), person.getDate()) >= 16
                        && yearsSubstraction(s.getDate(), person.getDate()) <= 40
                        && s.getSurname().substring(s.getSurname().length()-3).matches("s"))
                .collect(Collectors.toList());
        return prsnList;
    }

    private List<Person> isMother (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubstraction(s.getDate(), person.getDate()) >= 16
                        && yearsSubstraction(s.getDate(), person.getDate()) <= 40
                        && s.getSurname().substring(s.getSurname().length()-3).matches("ytė")
                        || s.getSurname().substring(s.getSurname().length()-4).matches("aitė")
                        || s.getSurname().substring(s.getSurname().length()-3).matches("ūtė"))
                .collect(Collectors.toList());
        return prsnList;
    }

    private List<Person> isBrother (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubstraction(s.getDate(), person.getDate()) >= 0
                        && yearsSubstraction(s.getDate(), person.getDate()) <= 15
                        && person.getSurname().matches(s.getSurname()))
                .collect(Collectors.toList());
        return prsnList;
    }

    private List<Person> isSister (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubstraction(s.getDate(), person.getDate()) >= 0
                        && yearsSubstraction(s.getDate(), person.getDate()) <= 15
                        && s.getSurname().substring(s.getSurname().length()-3).matches("ytė")
                        || s.getSurname().substring(s.getSurname().length()-4).matches("aitė")
                        || s.getSurname().substring(s.getSurname().length()-3).matches("ūtė"))
                .collect(Collectors.toList());
        return prsnList;
    }

    private List<Person> isWife (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubstraction(s.getDate(), person.getDate()) >= 0
                        && yearsSubstraction(s.getDate(), person.getDate()) <= 15
                        && s.getSurname().substring(0, s.getSurname().length()-4)
                            .matches(person.getSurname().substring(0, person.getSurname().length() -1))
                        && s.getSurname().substring(s.getSurname().length()-4).matches("ienė"))
                .collect(Collectors.toList());
        return prsnList;
    }

    private List<Person> isHusband (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubstraction(s.getDate(), person.getDate()) >= 0
                        && yearsSubstraction(s.getDate(), person.getDate()) <= 15
                        && s.getSurname().substring(0, s.getSurname().length()-1)
                            .matches(person.getSurname().substring(0, person.getSurname().length() -4))
                        && s.getSurname().substring(s.getSurname().length()-1).matches("s"))
                .collect(Collectors.toList());
        return prsnList;
    }

    private List<Person> isGrandSon (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubstraction(s.getDate(), person.getDate()) >= 41
                        && s.getSurname().substring(s.getSurname().length()-1).matches("s"))
                .collect(Collectors.toList());
        return prsnList;
    }

    private List<Person> isGrandDaugther (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubstraction(s.getDate(), person.getDate()) >= 41
                        && s.getSurname().substring(s.getSurname().length()-3).matches("ytė")
                        || s.getSurname().substring(s.getSurname().length()-4).matches("aitė")
                        || s.getSurname().substring(s.getSurname().length()-3).matches("ūtė"))
                .collect(Collectors.toList());
        return prsnList;
    }

    private List<Person> isGrandFather (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubstraction(person.getDate(), s.getDate()) >= 41
                        && s.getSurname().substring(s.getSurname().length()-1).matches("s"))
                .collect(Collectors.toList());
        return prsnList;
    }

    private List<Person> isGrandMother (List<Person> personList, Person person){
        prsnList = personList.stream()
                .filter(s -> yearsSubstraction(person.getDate(), s.getDate()) >= 41
                        && s.getSurname().substring(0, s.getSurname().length()-4)
                        .matches(person.getSurname().substring(0, person.getSurname().length() -1))
                        && s.getSurname().substring(s.getSurname().length()-4).matches("ienė"))
                .collect(Collectors.toList());
        return prsnList;
    }



    private int yearsSubstraction (Date firstYear, Date secondYear) {
        // YODA time
//        LocalDate prsnYear = LocalDate.fromDateFields(firstYear);
//        LocalDate rltvYear = LocalDate.fromDateFields(secondYear);
//
//        Period period = new Period(prsnYear, rltvYear);
//        long diff = Math.abs(period.getYears());


        long diff = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

            java.util.Date firstDate = sdf.parse(String.valueOf(firstYear));
            java.util.Date secondDate = sdf.parse(String.valueOf(secondYear));

            long diffInMillies = Math.abs(firstDate.getTime() - secondDate.getTime());
            diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) / 365;
        }catch (Exception ex){
            System.out.println("Date difference exception: " + ex);
        }

        return (int) diff;
    }

}
