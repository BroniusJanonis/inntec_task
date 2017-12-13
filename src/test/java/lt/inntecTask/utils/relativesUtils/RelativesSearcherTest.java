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
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RelativesSearcherTest {

    private RelativesSearcher relativesSearcher;
    private List<Person> personList = new ArrayList<>();
    private Person person = new Person();
    private RelativesDTO relatDTO = new RelativesDTO();
    private RelativesDTO relativesDTO = new RelativesDTO();

    @Mock
    private Kinship kinship;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        relativesSearcher = new RelativesSearcher(kinship);
    }

    @Test
    public void relativesSearchByPerson() throws Exception {

        when(kinship.isSon(anyList(), anyObject())).thenReturn(personList);
        when(kinship.isDaugther(anyList(), anyObject())).thenReturn(personList);
        when(kinship.isBrother(anyList(), anyObject())).thenReturn(personList);
        when(kinship.isSister(anyList(), anyObject())).thenReturn(personList);
        when(kinship.isMother(anyList(), anyObject())).thenReturn(personList);
        when(kinship.isFather(anyList(), anyObject())).thenReturn(personList);
        when(kinship.isHusband(anyList(), anyObject())).thenReturn(personList);
        when(kinship.isWife(anyList(), anyObject())).thenReturn(personList);
        when(kinship.isGrandFather(anyList(), anyObject())).thenReturn(personList);
        when(kinship.isGrandMother(anyList(), anyObject())).thenReturn(personList);
        when(kinship.isGrandSon(anyList(), anyObject())).thenReturn(personList);
        when(kinship.isGrandDaugther(anyList(), anyObject())).thenReturn(personList);

        when(relativesSearcher.relativesSearchByPerson(anyList(), anyObject())).thenReturn(relativesDTO);

        verify(kinship, times(12));
        assertEquals(relativesSearcher.relativesSearchByPerson(anyList(), anyObject()), relativesDTO);
        assertEquals(kinship.isBrother(anyList(), anyObject()), personList);

    }

}