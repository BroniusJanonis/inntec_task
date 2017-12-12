package lt.inntecTask.controller;

import lt.inntecTask.models.Person;
import lt.inntecTask.modelsDTO.RelativesDTO;
import lt.inntecTask.repository.IPersonDao;
import lt.inntecTask.utils.validatorsUtils.PersonValidator;
import lt.inntecTask.utils.relativesUtils.RelativesSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private RelativesSearcher relativesSearcher;
    @Autowired
    private IPersonDao personDao;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String getPersonList(Model model){
        List<Person> personList = personDao.personList();
        model.addAttribute("personList", personList);
        return "PersonPage";
    }

    @RequestMapping(value = "/updastePeron", method = RequestMethod.PUT)
    private String updatePeron(@ModelAttribute Person person, Model model, BindingResult bindresult){

        personValidator.validate(person, bindresult);
        if(bindresult.hasErrors()){
            return "PersonPage";
        }
        personDao.updatePerson(person);

        // TO DO: parser of object
        List<Person> personList = personDao.personList();
        RelativesDTO relativesDTOS = relativesSearcher.relativesSearchByPeron(personList, person);
        model.addAttribute("relativesList", relativesDTOS);

        return "PersonPage";
    }

}
