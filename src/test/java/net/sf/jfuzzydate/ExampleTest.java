package net.sf.jfuzzydate;

import net.sf.jfuzzydate.impl.DefaultFuzzingConfiguration;
import net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ExampleTest {

    // variable name format
    // plusorminus_amount_unit
    // mSec10 is minus 10 seconds, or 10 seconds ago

    private static final int SECONDS = 1000;
    private static final int MINUTES = 60 * 1000;
    private static final int HOURS = 60 * 60 * 1000;
    private static final int DAYS = 24 * 60 * 60 * 1000;
    private static final int WEEKS = 7 * 24 * 60 * 60 * 1000;
    private static final int MONTHS = -1;
    private static final int YEARS = -1;

    @Test
    public void test() {
        final FuzzyDateFormatter f = new FuzzyDateFormatterImpl( DefaultFuzzingConfiguration.getInstance());
        Date today = new Date(121, Calendar.APRIL, 25);
        Date now = new Date();

        // seconds
        Date mSec1 = new Date(now.getTime() - 1 * SECONDS);
        Date mSec2 = new Date(now.getTime() - 2 * SECONDS);
        Date mSec30 = new Date(now.getTime() - 30 * SECONDS);
        Date mSec31 = new Date(now.getTime() - 31 * SECONDS);

        Date pSec1 = new Date(now.getTime() + 1 * SECONDS);
        Date pSec2 = new Date(now.getTime() + 2 * SECONDS);
        Date pSec30 = new Date(now.getTime() + 30 * SECONDS);
        Date pSec31 = new Date(now.getTime() + 31 * SECONDS);

        // minutes
        Date mMin1 = new Date(now.getTime() - 1 * MINUTES);
        Date mMin2 = new Date(now.getTime() - 2 * MINUTES);
        Date mMin30 = new Date(now.getTime() - 30 * MINUTES);
        Date mMin31 = new Date(now.getTime() - 31 * MINUTES);

        Date pMin1 = new Date(now.getTime() + 1 * MINUTES);
        Date pMin2 = new Date(now.getTime() + 2 * MINUTES);
        Date pMin30 = new Date(now.getTime() + 30 * MINUTES);
        Date pMin31 = new Date(now.getTime() + 31 * MINUTES);

        // hours
        Date mHour1 = new Date(now.getTime() - 1 * HOURS);
        Date mHour2 = new Date(now.getTime() - 2 * HOURS);
        Date mHour12 = new Date(now.getTime() - 12 * HOURS);
        Date mHour25 = new Date(now.getTime() - 25 * HOURS);

        Date pHour1 = new Date(now.getTime() + 1 * HOURS);
        Date pHour2 = new Date(now.getTime() + 2 * HOURS);
        Date pHour12 = new Date(now.getTime() + 12 * HOURS);
        Date pHour25 = new Date(now.getTime() + 25 * HOURS);

        Date test = new Date(now.getTime() - 2 * HOURS);

        System.out.println(f.formatDuration(test));
    }
}
