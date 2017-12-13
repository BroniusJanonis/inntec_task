package lt.inntecTask.utils.relativesUtils.kindshipUtils;

import lt.inntecTask.models.Person;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class YearsSubtractionTest {

    YearsSubtraction yearsSubtraction = new YearsSubtraction();

    private Date date1 = null;
    private Date date2 = null;
    private List<Person> personList = new ArrayList<>();
    private String years1 = "01-01-1987";
    private String years2 = "01-01-2007";
    private int yearsGap = 20;

    @Before
    public void setUp() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date dt1 = sdf.parse(years1);
        java.util.Date dt2 = sdf.parse(years2);
        date1 = new java.sql.Date(dt1.getTime());
        date2 = new java.sql.Date(dt2.getTime());
    }

    @Test
    public void yearsGap() throws Exception {
        assertEquals(yearsGap, yearsSubtraction.yearsGap(date1, date2));
    }

}