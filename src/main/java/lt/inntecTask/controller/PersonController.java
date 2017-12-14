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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ComponentScan({"lt.inntecTask"})
public class PersonController {

    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private RelativesSearcher relativesSearcher;
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
        Map<String, List<Person>> relativesMap = relativesSearcher.relativesSearchByPerson(personList, person);
        model.addAttribute("relativesMap", relativesMap);
        return "SelectedPerson";
    }

    @RequestMapping(value = "/updastePeron", method = RequestMethod.POST)
    public String updatePeron(@ModelAttribute("person") Person person, Model model, BindingResult bindresult){

        personValidator.validate(person, bindresult);
        if(bindresult.hasErrors()){
            return "SelectedPerson";
        }
        personDao.updatePerson(person);

        return "redirect:";
    }

}
