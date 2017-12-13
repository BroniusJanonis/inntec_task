package lt.inntecTask.utils.relativesUtils.kindshipUtils;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

@Component
public class YearsSubtraction {

    private int daysInYears = 365;
    private long diff = 0;

    public int yearsGap(Date firstYear, Date secondYear) {
        // YODA time
//        LocalDate prsnYear = LocalDate.fromDateFields(firstYear);
//        LocalDate rltvYear = LocalDate.fromDateFields(secondYear);
//
//        Period period = new Period(prsnYear, rltvYear);
//        long diff = Math.abs(period.getYears());

        long yearsToLong1 = firstYear.getTime();
        long yearsToLong2 = secondYear.getTime();
        long timeGapInLong = Math.abs(yearsToLong1 - yearsToLong2);
        diff = TimeUnit.DAYS.convert(timeGapInLong, TimeUnit.MILLISECONDS) / daysInYears;

        return (int) diff;
    }

    public boolean firstIsOlder (Date firstYear, Date secondYear) {

        boolean firstOlder = false;

        long yearsToLong1 = firstYear.getTime();
        long yearsToLong2 = secondYear.getTime();
        if(yearsToLong1 < yearsToLong2){
            return true;
        }
        return firstOlder;
    }

}
