package lt.inntecTask.utils.relativesUtils;

import lt.inntecTask.models.Person;
import lt.inntecTask.utils.relativesUtils.kindshipUtils.KindshipSubstring;
import lt.inntecTask.utils.relativesUtils.kindshipUtils.YearsSubtraction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Kinship {

    private List<Person> prsnList = new ArrayList<>();
    private KindshipSubstring relative = new KindshipSubstring();
    private YearsSubtraction yearsSubtraction = new YearsSubtraction();

    public List<Person> isSon(List<Person> personList, Person person) {
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(person.getDate(), s.getDate()) >= 16
                        && yearsSubtraction.yearsGap(person.getDate(), s.getDate()) <= 40
                        && yearsSubtraction.firstIsOlder(person.getDate(), s.getDate())
                        && relative.isSonGrandSon(s, person)
                        && relative.isMan(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    public List<Person> isDaugther(List<Person> personList, Person person) {
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(person.getDate(), s.getDate()) >= 16
                        && yearsSubtraction.yearsGap(person.getDate(), s.getDate()) <= 40
                        && yearsSubtraction.firstIsOlder(person.getDate(), s.getDate())
//                        && relative.isNoSpouseNoSibling(s, person)
                        && relative.isDaugtherGrandDaughter(s, person)
                        && relative.isWoman(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    public List<Person> isFather(List<Person> personList, Person person) {
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 16
                        && yearsSubtraction.yearsGap(s.getDate(), person.getDate()) <= 40
                        && yearsSubtraction.firstIsOlder(s.getDate(), person.getDate())
                        && relative.isNoSpouseNoSibling(s, person)
                        && relative.isMan(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    public List<Person> isMother(List<Person> personList, Person person) {
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 16
                        && yearsSubtraction.yearsGap(s.getDate(), person.getDate()) <= 40
                        && yearsSubtraction.firstIsOlder(s.getDate(), person.getDate())
                        && relative.isNoSpouseNoSibling(s, person)
                        && relative.isWoman(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    public List<Person> isBrother(List<Person> personList, Person person) {
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 0
                        && yearsSubtraction.yearsGap(s.getDate(), person.getDate()) <= 15
                        && relative.isBrotherOrSister(s, person)
                        && relative.isMan(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    public List<Person> isSister(List<Person> personList, Person person) {
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 0
                        && yearsSubtraction.yearsGap(s.getDate(), person.getDate()) <= 15
                        && relative.isBrotherOrSister(s, person)
                        && relative.isWoman(s))
                .collect(Collectors.toList());
        return prsnList;
    }

    public List<Person> isWife(List<Person> personList, Person person) {
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 0
                                && yearsSubtraction.yearsGap(s.getDate(), person.getDate()) <= 15
                                && relative.isSpouse(s, person)
                                && relative.isWoman(s)
                                && relative.isMan(person)
                )
                .collect(Collectors.toList());
        return prsnList;
    }

    public List<Person> isHusband(List<Person> personList, Person person) {
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 0
                                && yearsSubtraction.yearsGap(s.getDate(), person.getDate()) <= 15
                                && relative.isSpouse(s, person)
                                && relative.isMan(s)
                                && relative.isWoman(person)
                )
                .collect(Collectors.toList());
        return prsnList;
    }

    public List<Person> isGrandSon(List<Person> personList, Person person) {
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 41
                                && yearsSubtraction.firstIsOlder(person.getDate(), s.getDate())
                                && relative.isSonGrandSon(s, person)
                                && relative.isMan(s)
                )
                .collect(Collectors.toList());
        return prsnList;
    }

    public List<Person> isGrandDaugther(List<Person> personList, Person person) {
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(s.getDate(), person.getDate()) >= 41
                                && yearsSubtraction.firstIsOlder(person.getDate(), s.getDate())
//                                && relative.isNoSpouseNoSibling(s, person)
                                && relative.isDaugtherGrandDaughter(s, person)
                                && relative.isWoman(s)
                )
                .collect(Collectors.toList());
        return prsnList;
    }

    public List<Person> isGrandFather(List<Person> personList, Person person) {
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(person.getDate(), s.getDate()) >= 41
                                && yearsSubtraction.firstIsOlder(s.getDate(), person.getDate())
                                && relative.isNoSpouseNoSibling(s, person)
                                && relative.isMan(s)
                )
                .collect(Collectors.toList());
        return prsnList;
    }

    public List<Person> isGrandMother(List<Person> personList, Person person) {
        prsnList = personList.stream()
                .filter(s -> yearsSubtraction.yearsGap(person.getDate(), s.getDate()) >= 41
                        && yearsSubtraction.firstIsOlder(s.getDate(), person.getDate())
                        && relative.isNoSpouseNoSibling(s, person)
                        && relative.isWoman(s))
                .collect(Collectors.toList());
        return prsnList;
    }

}
