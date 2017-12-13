package lt.inntecTask.utils.validatorsUtils;

import lt.inntecTask.models.Person;
import org.assertj.core.internal.Objects;
import org.junit.Test;
import org.springframework.validation.Errors;

import static org.junit.Assert.*;

public class PersonValidatorTest {

    private PersonValidator personValidator;

    @Test
    public void supports() throws Exception {
        assertFalse(Person.class.equals(Object.class));
    }

    @Test
    public void validate() throws Exception {
    }

}