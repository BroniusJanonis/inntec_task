package lt.inntecTask.utils.relativesUtils;

import lt.inntecTask.models.Person;
import lt.inntecTask.modelsDTO.RelativesDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class RelativesSearcher {

    private Kinship kinship = new Kinship();
    private RelativesDTO relativesDTO = new RelativesDTO();

    public RelativesSearcher(Kinship kinship) {
        this.kinship = kinship;
    }

    public RelativesDTO relativesSearchByPerson(List<Person> personList, Person person) {

        relativesDTO.setSon(kinship.isSon(personList, person));
        relativesDTO.setDaughter(kinship.isDaugther(personList, person));
        relativesDTO.setBrother(kinship.isBrother(personList, person));
        relativesDTO.setSister(kinship.isSister(personList, person));
        relativesDTO.setMother(kinship.isMother(personList, person));
        relativesDTO.setFather(kinship.isFather(personList, person));
        relativesDTO.setHusband(kinship.isHusband(personList, person));
        relativesDTO.setWife(kinship.isWife(personList, person));
        relativesDTO.setGrandfather(kinship.isGrandFather(personList, person));
        relativesDTO.setGrandmother(kinship.isGrandMother(personList, person));
        relativesDTO.setGrandSon(kinship.isGrandSon(personList, person));
        relativesDTO.setGrandDaughter(kinship.isGrandDaugther(personList, person));

        return relativesDTO;
    }




}
