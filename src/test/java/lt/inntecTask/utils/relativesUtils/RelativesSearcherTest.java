package lt.inntecTask.utils.relativesUtils;

import lt.inntecTask.models.Person;
import lt.inntecTask.modelsDTO.RelativesDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RelativesSearcherTest {

    RelativesSearcher relativesSearcher;
    @Mock
    private Kinship kinship = new Kinship();
    private RelativesDTO relativesDTO = new RelativesDTO();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        relativesSearcher = new RelativesSearcher(kinship);
    }

    @Test
    public void relativesSearchByPerson() throws Exception {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();

        when(kinship.isSon(personList, person)).thenReturn(personList);
        when(kinship.isDaugther(anyList(), any())).thenReturn(personList);
        when(kinship.isBrother(anyList(), any())).thenReturn(personList);
        when(kinship.isSister(anyList(), any())).thenReturn(personList);
        when(kinship.isMother(anyList(), any())).thenReturn(personList);
        when(kinship.isFather(anyList(), any())).thenReturn(personList);
        when(kinship.isHusband(anyList(), any())).thenReturn(personList);
        when(kinship.isWife(anyList(), any())).thenReturn(personList);
        when(kinship.isGrandFather(anyList(), any())).thenReturn(personList);
        when(kinship.isGrandMother(anyList(), any())).thenReturn(personList);
        when(kinship.isGrandSon(anyList(), any())).thenReturn(personList);
        when(kinship.isGrandDaugther(anyList(), any())).thenReturn(personList);

        assertTrue(relativesSearcher.relativesSearchByPerson(anyList(), any()).getGrandDaughter() == personList);
        verify(kinship, times(12));

    }

}