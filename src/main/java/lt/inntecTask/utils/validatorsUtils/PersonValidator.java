package lt.inntecTask.utils.validatorsUtils;

import lt.inntecTask.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object oPerson, Errors errors) {
        Person person = (Person) oPerson;

        // TO DO: must set fields in Enum class
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "EmptyName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "EmptySurname");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "EmptyDate");

        if(person.getName().length() <= 2 || person.getName().length() >= 50){
            errors.rejectValue("name", "Size.name");
        }

        if(person.getSurname().length() <= 2 || person.getSurname().length() >= 50){
            errors.rejectValue("surname", "Size.surname");
        }

    }

}
