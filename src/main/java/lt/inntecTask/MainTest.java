package lt.inntecTask;

import lt.inntecTask.models.Person;
import lt.inntecTask.utils.relativesUtils.kindshipUtils.KindshipSubstring;
import org.joda.time.LocalDate;
import org.joda.time.Period;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {


    public static void main(String[] args) throws ParseException {

        // 1. TIME TESTS
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

            Date firstDate = sdf.parse("06/30/2014");
            Date secondDate = sdf.parse("06/30/2000");

            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)/365;

            System.out.println("Milliseconds: " + diffInMillies + " to days: " + diff);

        }catch (Exception ex){
            System.out.println(ex);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date testDate1 = sdf.parse("06/30/2014");
        Date testDate2 = sdf.parse("06/30/2007");

        LocalDate firstDate = LocalDate.fromDateFields(new java.sql.Date(1512992978));
        LocalDate secondDate = LocalDate.fromDateFields(new java.sql.Date(1449834578));

        Period period = new Period(firstDate, secondDate);
        long diff = Math.abs(period.getYears());

        System.out.println(firstDate);
        System.out.println(secondDate);
        System.out.println(diff);

        // 2. SPLIT TESTS
        Person relative = new Person();
//        relative.setSurname("Petraitytė-Antanienė");
        relative.setSurname("Petraitytė-Petraitienė");
        Person person = new Person();
        person.setSurname("Petraitis");
        String[] split = relative.getSurname().split("-");
        System.out.println(split[split.length-1]);

        KindshipSubstring kindshipSubstring = new KindshipSubstring();

        // 3. REGEX TESTS
//        String relativeSurname = "Petraitaitė";
        String relativeSurname = "Petraitienė";

        String str = relativeSurname.replaceAll("(ienė|aitė|ūtė|ytė|is)$", "");
        System.out.println(str);

        Matcher m = Pattern.compile("(ienė|is|s)$").matcher(relativeSurname);
        System.out.println(m.find());

        boolean spouse = kindshipSubstring.isSpouse(relative, person);
        System.out.println("Is spouse: " + spouse);


        // 4. ENUM TESTS
        System.out.println();
        System.out.println("compareTo() the same enums: " + TestEnum.name.compareTo(TestEnum.name));
        System.out.println("compareTo() different enums: " + TestEnum.name.compareTo(TestEnum.surname));
        System.out.println("name() method: " + TestEnum.name.name());
        System.out.println("ordinam() method: " + TestEnum.Numb1.ordinal());
        System.out.println("toString() method: " + TestEnum.name.toString());
        System.out.println("equals() the same enums: " + TestEnum.name.equals(TestEnum.name));
        System.out.println("equals() different enums: " + TestEnum.name.equals(TestEnum.surname));
        System.out.println("getValue() getter method: " + TestEnum.Numb1.getValue());
    }

    public enum TestEnum{
        name(0),
        surname(0),
        Numb1(1),
        date(0);

        private final int value;
        TestEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
