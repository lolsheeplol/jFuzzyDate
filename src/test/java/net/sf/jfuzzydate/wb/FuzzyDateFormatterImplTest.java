package net.sf.jfuzzydate.wb;

import net.sf.jfuzzydate.FuzzingConfiguration;
import net.sf.jfuzzydate.FuzzyDateFormatter;
import net.sf.jfuzzydate.impl.DefaultFuzzingConfiguration;
import net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

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

    @Test
    public void testFormatDurationDateSeconds() {
        Date mSec30 = new Date(now.getTime() - 30 * SECONDS);
        assertEqualsFormatDuration("a minute", mSec30);
    }

    @Test
    public void testFormatDurationMillis() {
        long millisecond = 1;
        assertEqualsFormatDurationMillis("a minute", millisecond);
    }

    private void assertFormatDistance(String expected, Date date) {
        Assert.assertEquals(expected, formatter.formatDistance(date));
        Assert.assertEquals(expected, formatter.formatDistance(date, Locale.ENGLISH));
    }

    @Test
    public void testFormatDurationFromToDate() {
        Date mHour12 = new Date(now.getTime() - 12 * HOURS);
        assertEqualsFormatDurationFromTo("12 hours", mHour12, now);
    }

    @Test
    public void testFormatDistanceInFuture() {
        long time = now.getTime();
        Date sec1 = new Date(time + 1 * SECONDS);
        Date min2 = new Date(time + 2 * MINUTES);
        Date hour = new Date(time + 1 * HOURS);
        Date day = new Date(time + 1 * DAYS);
        Date week = new Date(time + 1 * WEEKS);
        Date month = new Date(time + 1 * MONTHS);
        Date year = new Date(time + 1 * YEARS);
        Date year100 = new Date(time + 100 * YEARS);

        assertFormatDistance("in a minute", sec1);
        assertFormatDistance("in two minutes", min2);
        assertFormatDistance("in an hour", hour);
        assertFormatDistance("in a day", day);
        assertFormatDistance("in a week", week);
        assertFormatDistance("in a month", month);
        assertFormatDistance("in a year", year);
        assertFormatDistance("in a century", year100);
    }

    @Test
    public void testFormatDistanceInPast() {
        long time = now.getTime();
        Date hour = new Date(time - 1 * HOURS);
        assertFormatDistance("an hour ago", hour);
    }

    @Test
    public void testFormatUnimplemented() {
        // known to be 'not implemented'
        Date now = new Date();
        Assert.assertEquals("not implemented", formatter.format(now));
        Assert.assertEquals("not implemented", formatter.format(now, Locale.ENGLISH));
    }

    @Test
    public void testFormatDurationThrowsExceptionWithPluralizer() {
        FuzzingConfiguration badConfig = new BadPluralizerFuzzingConfiguration();
        final FuzzyDateFormatter formatter = new FuzzyDateFormatterImpl(badConfig);

        Assert.assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                formatter.formatDuration(new Date());
            }
        });
    }

    @Test
    public void testFormatDurationThrowsExceptionWithBadRange() {
        FuzzingConfiguration badConfig = new BadRangeFuzzingConfiguration();
        final FuzzyDateFormatter formatter = new FuzzyDateFormatterImpl(badConfig);

        Assert.assertThrows(IllegalStateException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                formatter.formatDuration(new Date());
            }
        });
    }
}
