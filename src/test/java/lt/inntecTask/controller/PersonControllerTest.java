package lt.inntecTask.controller;

import lt.inntecTask.models.Person;
import lt.inntecTask.repository.IPersonDao;
import lt.inntecTask.utils.relativesUtils.Kinship;
import lt.inntecTask.utils.relativesUtils.RelativesSearcher;
import lt.inntecTask.utils.validatorsUtils.PersonValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class PersonControllerTest {

    @Mock
    private PersonValidator personValidator;
    @Mock
    private RelativesSearcher relativesSearcher;
    @Mock
    private IPersonDao personDao;

    @InjectMocks
    private PersonController personController;

    private MockMvc mockMvc;

    private List<Person> personList = new ArrayList<>();
    private Map<String, List<Person>> relativesMap = new HashMap<>();
    private Person person1;
    private Long id1 = 1L;
    private String name1 = "name1";
    private String surname1 = "surname1";
    private String years1 = "01-01-1987";
    private Date date1 = null;
    private String mapKey = "son";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(personController).setViewResolvers(viewResolver).build();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date dt1 = sdf.parse(years1);
        date1 = new java.sql.Date(dt1.getTime());

        person1 = new Person(id1, name1, surname1, date1);
        personList.add(person1);
        relativesMap.put(mapKey, personList);
    }

    @Test
    public void getPersonList() throws Exception {

        when(personDao.personList()).thenReturn(personList);

        mockMvc.perform(get(""))
                .andExpect(status().isOk())
                .andExpect(view().name("PersonPage"))
                .andExpect(model().attribute("personList", hasSize(1)))
                .andExpect(model().attribute("personList", is(personList)))
                .andExpect(model().attribute("personList", hasItems(
                        allOf(
                                hasProperty("id", is(id1)),
                                hasProperty("name", is(name1)),
                                hasProperty("surname", is(surname1)),
                                hasProperty("date", is(date1))
                        )
                )));

        verify(personDao, times(1)).personList();
    }

    @Test
    public void getSelectedPerson() throws Exception {

        when(personDao.personList()).thenReturn(personList);
        when(relativesSearcher.relativesSearchByPerson(anyList(), Matchers.any())).thenReturn(relativesMap);

        mockMvc.perform(post("/selectedPerson")
                .param("id", String.valueOf(id1))
                .param("name", name1)
                .param("surname", surname1)
                .param("date", String.valueOf(date1)))
                .andExpect(status().isOk())
                .andExpect(view().name("SelectedPerson"))
                .andExpect(model().attribute("relativesMap", hasEntry(mapKey, personList)))
                .andExpect(model().attribute("relativesMap", is(relativesMap)))
                .andExpect(model().attribute("relativesMap", hasKey(mapKey)))
                .andExpect(model().attribute("relativesMap", hasValue(
                        hasItems(
                                allOf(
                                        hasProperty("id", is(id1)),
                                        hasProperty("name", is(name1)),
                                        hasProperty("surname", is(surname1)),
                                        hasProperty("date", is(date1))
                                    )
                                )
                )));

        verify(personDao, times(1)).personList();
        verify(relativesSearcher, times(1)).relativesSearchByPerson(anyList(), Matchers.anyObject());

        ArgumentCaptor<Person> boundPerson = ArgumentCaptor.forClass(Person.class);
        verify(relativesSearcher).relativesSearchByPerson(anyList(), boundPerson.capture());

        assertEquals(1L, boundPerson.getValue().getId());
        assertEquals(name1, boundPerson.getValue().getName());
        assertEquals(surname1, boundPerson.getValue().getSurname());
        assertEquals(date1, boundPerson.getValue().getDate());

    }

    @Test
    public void updatePeron() throws Exception {

        when(personDao.updatePerson(Matchers.any())).thenReturn(person1);

        mockMvc.perform(post("/updastePeron")
                .param("id", String.valueOf(id1))
                .param("name", name1)
                .param("surname", surname1)
                .param("date", String.valueOf(date1)))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:"));

        verify(personValidator, times(1)).validate(anyObject(), Matchers.any());

        ArgumentCaptor<Person> boundPerson = ArgumentCaptor.forClass(Person.class);
        verify(personDao).updatePerson(boundPerson.capture());

        assertEquals(1L, boundPerson.getValue().getId());
        assertEquals(name1, boundPerson.getValue().getName());
        assertEquals(surname1, boundPerson.getValue().getSurname());
        assertEquals(date1, boundPerson.getValue().getDate());

        assertTrue(personDao.updatePerson(Matchers.any()) != null);

    }

}