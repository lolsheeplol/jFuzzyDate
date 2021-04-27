package net.sf.jfuzzydate;

import org.junit.Test;

import java.util.Date;
import java.util.Locale;

public class DemoTest {

    private static final int DAY = 24 * 60 * 60 * 1000;

    /**
     * FuzzyDateFormatter.formatDuration(Date date)
     *
     *
     * FuzzyDateFormatter.formatDistance(Date date)
     *
     *
     * FuzzyDateFormatter.formatDistance(Date from, Date to)
     */
    @Test
    public void demo() {
        FuzzyDateFormatter formatter = FuzzyDateFormat.getInstance();

        Date now = new Date();
        Date yesterday = new Date(now.getTime() - DAY);
        Date sixDaysAgo = new Date(now.getTime() - 6 * DAY);
        Date lastWeek = new Date(now.getTime() - 7 * DAY);
        Date twoDays = new Date(now.getTime() + 2 * DAY);

        // "a day"
        System.out.println(formatter.formatDuration(yesterday));
        // "6 days"
        System.out.println(formatter.formatDuration(sixDaysAgo, now, Locale.ENGLISH));
        // "a week"
        System.out.println(formatter.formatDuration(lastWeek));

        System.out.println("----------");

        // "a day ago"
        System.out.println(formatter.formatDistance(yesterday));
        // "a week ago"
        System.out.println(formatter.formatDistance(lastWeek));
        // "in two days"
        System.out.println(formatter.formatDistance(twoDays));
    }
}
