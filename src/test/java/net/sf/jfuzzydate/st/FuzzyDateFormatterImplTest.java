package net.sf.jfuzzydate.st;

import net.sf.jfuzzydate.FuzzyDateFormatter;
import net.sf.jfuzzydate.impl.DefaultFuzzingConfiguration;
import net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FuzzyDateFormatterImplTest {

    private static final long SECONDS = 1000;
    private static final long MINUTES = 60 * 1000;
    private static final long HOURS = 60 * 60 * 1000;
    private static final long DAYS = 24 * 60 * 60 * 1000;
    private static final long WEEKS = 7 * 24 * 60 * 60 * 1000;
    private static final long MONTHS = 30L * 24 * 60 * 60 * 1000;
    private static final long YEARS = 366L * 24 * 60 * 60 * 1000;   // Not accurate in long run but days in year are rounded up (365.25 -> 366)

    private static FuzzyDateFormatter formatter;
    private static Date now;

    @BeforeClass
    public static void beforeAll() {
        formatter = new FuzzyDateFormatterImpl(DefaultFuzzingConfiguration.getInstance());
    }

    @Before
    public void beforeTests() {
        now = new Date();
    }

    private void assertEqualsFormatDuration(String expected, Date date) {
        Assert.assertEquals(expected, formatter.formatDuration(date));
        Assert.assertEquals(expected, formatter.formatDuration(date, Locale.ENGLISH));
    }

    private void assertEqualsFormatDurationMillis(String expected, long millis) {
        Assert.assertEquals(expected, formatter.formatDuration(millis));
        Assert.assertEquals(expected, formatter.formatDuration(millis, Locale.ENGLISH));
    }

    private void assertEqualsFormatDurationFromTo(String expected, Date from, Date to) {
        Assert.assertEquals(expected, formatter.formatDuration(from, to, Locale.ENGLISH));
    }

    private void assertFormatDistance(String expected, Date date) {
        Assert.assertEquals(expected, formatter.formatDistance(date));
        Assert.assertEquals(expected, formatter.formatDistance(date, Locale.ENGLISH));
    }

    @Test
    public void testFormatDistanceInFuture() {
        long time = now.getTime();
        Date hour = new Date(time + 1 * HOURS);
        assertFormatDistance("in an hour", hour);
    }

    @Test
    public void testFormatDistanceInPast() {
        long time = now.getTime();
        Date hour = new Date(time - 1 * HOURS);
        assertFormatDistance("an hour ago", hour);
    }

}
