package lt.inntecTask.utils.relativesUtils;

import lt.inntecTask.models.Person;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RelativesSearcher {

    private Kinship kinship = new Kinship();
    private Map<String,List<Person>> map = new HashMap<String,List<Person>>();

    public RelativesSearcher(Kinship kinship) {
        this.kinship = kinship;
    }

    public Map<String,List<Person>> relativesSearchByPerson(List<Person> personList, Person person) {

        map.put("son", kinship.isSon(personList, person));
        map.put("daugther", kinship.isDaugther(personList, person));
        map.put("brother", kinship.isBrother(personList, person));
        map.put("sister", kinship.isSister(personList, person));
        map.put("mother", kinship.isMother(personList, person));
        map.put("father", kinship.isFather(personList, person));
        map.put("husband", kinship.isHusband(personList, person));
        map.put("wife", kinship.isWife(personList, person));
        map.put("grandfather", kinship.isGrandFather(personList, person));
        map.put("grandmother", kinship.isGrandMother(personList, person));
        map.put("grandson", kinship.isGrandSon(personList, person));
        map.put("granddaughter", kinship.isGrandDaugther(personList, person));

        return map;
    }




}
