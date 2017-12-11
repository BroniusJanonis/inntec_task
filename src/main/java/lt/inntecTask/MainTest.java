package lt.inntecTask;

import org.joda.time.LocalDate;
import org.joda.time.Period;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainTest {

    public static void main(String[] args) throws ParseException {

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

    }
}
