package lt.inntecTask.controller;

import lt.inntecTask.models.Person;
import lt.inntecTask.modelsDTO.RelativesDTO;
import lt.inntecTask.repository.IPersonDao;
import lt.inntecTask.utils.relativesUtils.Kinship;
import lt.inntecTask.utils.validatorsUtils.PersonValidator;
import lt.inntecTask.utils.relativesUtils.RelativesSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@ComponentScan({"lt.inntecTask"})
public class PersonController {

    @Autowired
    private PersonValidator personValidator;
//    @Autowired
//    private RelativesSearcher relativesSearcher;
    @Autowired
    Kinship kinship;
    @Autowired
    private IPersonDao personDao;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getPersonList(Model model){
        List<Person> personList = personDao.personList();
        model.addAttribute("personList", personList);
        return "PersonPage";
    }

    @RequestMapping(value = "/selectedPerson", method = RequestMethod.POST)
    public String getSelectedPerson(@ModelAttribute("person") Person person, Model model){
        List<Person> personList = personDao.personList();
        // MAYBE ADING ModelAttribute("RelativesDTO") would solve the issue of Spring recognizing Object
//        RelativesDTO relativesDTOS = relativesSearcher.relativesSearchByPerson(personList, person);
        model.addAttribute("person", person);
        model.addAttribute("sonList", kinship.isSon(personList, person));
        model.addAttribute("daughterList", kinship.isDaugther(personList, person));
        model.addAttribute("brotherList", kinship.isBrother(personList, person));
        model.addAttribute("sisterList", kinship.isSister(personList, person));
        model.addAttribute("wifeList", kinship.isWife(personList, person));
        model.addAttribute("husbandList", kinship.isHusband(personList, person));
        model.addAttribute("fatherList", kinship.isFather(personList, person));
        model.addAttribute("motherList", kinship.isMother(personList, person));
        model.addAttribute("grandfatherList", kinship.isGrandFather(personList, person));
        model.addAttribute("grandmotherList", kinship.isGrandMother(personList, person));
        model.addAttribute("grandsonList", kinship.isGrandSon(personList, person));
        model.addAttribute("granddaughterList", kinship.isGrandDaugther(personList, person));

        return "SelectedPerson";
    }

    @RequestMapping(value = "/updastePeron", method = RequestMethod.POST)
    public String updatePeron(@ModelAttribute("person") Person person, Model model, BindingResult bindresult){

        personValidator.validate(person, bindresult);
        if(bindresult.hasErrors()){
            List<Person> personList = personDao.personList();
//            RelativesDTO relativesDTOS = relativesSearcher.relativesSearchByPerson(personList, person);
//            model.addAttribute("relativesList", relativesDTOS);
            return "SelectedPerson";
        }
        personDao.updatePerson(person);

        return "redirect:";
    }

}
