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

public class FuzzyDateFormatterTest {

    // black-box test FuzzyDateFormatter interface

    // variable name format
    // plusorminus_amount_unit
    // mSec10 is minus 10 seconds, or 10 seconds ago

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

    // TODO: enable
    // @Test
    public void testFormat() {
        Date now = new Date();

        String expected = "one second";
        Assert.assertEquals(expected, formatter.format(now));
        Assert.assertEquals(expected, formatter.format(now, Locale.ENGLISH));
    }

    @Test
    public void testFormatUnimplemented() {
        // known to be 'not implemented'
        Date now = new Date();
        Assert.assertEquals("not implemented", formatter.format(now));
        Assert.assertEquals("not implemented", formatter.format(now, Locale.ENGLISH));
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
        // seconds
        Date mSec1 = new Date(now.getTime() - 1 * SECONDS);
        Date mSec2 = new Date(now.getTime() - 2 * SECONDS);
        Date mSec30 = new Date(now.getTime() - 30 * SECONDS);
        Date mSec31 = new Date(now.getTime() - 31 * SECONDS);
        Date mSec60 = new Date(now.getTime() - 60 * SECONDS);
        Date mSec120 = new Date(now.getTime() - 120 * SECONDS);

        assertEqualsFormatDuration("a minute", mSec1);

        assertEqualsFormatDuration("a minute", mSec2);

        assertEqualsFormatDuration("a minute", mSec30);

        assertEqualsFormatDuration("a minute", mSec31);

        assertEqualsFormatDuration("a minute", mSec60);

        assertEqualsFormatDuration("two minutes", mSec120);
    }

    @Test
    public void testFormatDurationDateMinutes() {
        // minutes
        Date mMin1 = new Date(now.getTime() - 1 * MINUTES);
        Date mMin2 = new Date(now.getTime() - 2 * MINUTES);
        Date mMin30 = new Date(now.getTime() - 30 * MINUTES);
        Date mMin31 = new Date(now.getTime() - 31 * MINUTES);
        Date mMin60 = new Date(now.getTime() - 60 * MINUTES);

        assertEqualsFormatDuration("a minute", mMin1);

        assertEqualsFormatDuration("two minutes", mMin2);

        assertEqualsFormatDuration("30 minutes", mMin30);

        assertEqualsFormatDuration("31 minutes", mMin31);

        assertEqualsFormatDuration("an hour", mMin60);
    }

    @Test
    public void testFormatDurationDateHours() {
        // hours
        Date mHour1 = new Date(now.getTime() - 1 * HOURS);
        Date mHour2 = new Date(now.getTime() - 2 * HOURS);
        Date mHour12 = new Date(now.getTime() - 12 * HOURS);
        Date mHour25 = new Date(now.getTime() - 25 * HOURS);

        assertEqualsFormatDuration("an hour", mHour1);

        assertEqualsFormatDuration("two hours", mHour2);

        assertEqualsFormatDuration("12 hours", mHour12);

        assertEqualsFormatDuration("a day", mHour25);
    }

    @Test
    public void testFormatDurationDateDays() {
        // days
        Date mDay1 = new Date(now.getTime() - 1 * DAYS);
        Date mDay2 = new Date(now.getTime() - 2 * DAYS);
        Date mDay7 = new Date(now.getTime() - 7 * DAYS);
        Date mDay14 = new Date(now.getTime() - 14 * DAYS);

        assertEqualsFormatDuration("a day", mDay1);

        assertEqualsFormatDuration("two days", mDay2);

        assertEqualsFormatDuration("a week", mDay7);

        assertEqualsFormatDuration("two weeks", mDay14);
    }

    @Test
    public void testFormatDurationDateWeeks() {
        // weeks
        Date mWeek1 = new Date(now.getTime() - 1 * WEEKS);
        Date mWeek2 = new Date(now.getTime() - 2 * WEEKS);
        Date mWeek4 = new Date(now.getTime() - 4 * WEEKS);
        Date mWeek6 = new Date(now.getTime() - 6 * WEEKS);
        Date mWeek8 = new Date(now.getTime() - 8 * WEEKS);

        assertEqualsFormatDuration("a week", mWeek1);

        assertEqualsFormatDuration("two weeks", mWeek2);

        assertEqualsFormatDuration("a month", mWeek4);

        assertEqualsFormatDuration("a month", mWeek6);

        assertEqualsFormatDuration("two months", mWeek8);
    }

    @Test
    public void testFormatDurationDateMonths() {
        // weeks
        Date mMonth1 = new Date(now.getTime() - 1 * MONTHS);
        Date mMonth2 = new Date(now.getTime() - 2 * MONTHS);
        Date mMonth6 = new Date(now.getTime() - 6 * MONTHS);
        Date mMonth13 = new Date(now.getTime() - 13 * MONTHS);

        assertEqualsFormatDuration("a month", mMonth1);

        assertEqualsFormatDuration("two months", mMonth2);

        assertEqualsFormatDuration("6 months", mMonth6);

        assertEqualsFormatDuration("1 year", mMonth13);
    }

    @Test
    public void testFormatDurationDateYear() {
        // weeks
        Date mYear1 = new Date(now.getTime() - 1 * YEARS);
        Date mYear2 = new Date(now.getTime() - 2 * YEARS);
        Date mYear10 = new Date(now.getTime() - 10 * YEARS);
        Date mYear100 = new Date(now.getTime() - 100 * YEARS);

        assertEqualsFormatDuration("1 year", mYear1);

        assertEqualsFormatDuration("2 years", mYear2);

        assertEqualsFormatDuration("10 years", mYear10);

        assertEqualsFormatDuration("1 century", mYear100);
    }

    @Test
    public void testFormatDurationMillis() {
        long millisecond = 1;

        assertEqualsFormatDurationMillis("a minute", millisecond);
        assertEqualsFormatDurationMillis("a minute", SECONDS);
        assertEqualsFormatDurationMillis("a minute", MINUTES);
        assertEqualsFormatDurationMillis("an hour", HOURS);
        assertEqualsFormatDurationMillis("a day", DAYS);
        assertEqualsFormatDurationMillis("a week", WEEKS);
        assertEqualsFormatDurationMillis("a month", MONTHS);
        assertEqualsFormatDurationMillis("1 year", YEARS);
    }

    @Test
    public void testFormatDurationFromToDate() {
        Date mSec2 = new Date(now.getTime() - 2 * SECONDS);
        Date mMin30 = new Date(now.getTime() - 30 * MINUTES);
        Date mHour12 = new Date(now.getTime() - 12 * HOURS);
        Date mDay1 = new Date(now.getTime() - 1 * DAYS);
        Date mWeek2 = new Date(now.getTime() - 2 * WEEKS);
        Date mMonth6 = new Date(now.getTime() - 6 * MONTHS);
        Date mYear2 = new Date(now.getTime() - 2 * YEARS);

        assertEqualsFormatDurationFromTo("a minute", mSec2, now);
        assertEqualsFormatDurationFromTo("30 minutes", mMin30, now);
        assertEqualsFormatDurationFromTo("12 hours", mHour12, now);
        assertEqualsFormatDurationFromTo("a day", mDay1, now);
        assertEqualsFormatDurationFromTo("two weeks", mWeek2, now);
        assertEqualsFormatDurationFromTo("6 months", mMonth6, now);
        assertEqualsFormatDurationFromTo("2 years", mYear2, now);
    }

    @Test
    public void testFormatDurationDateInFuture() {
        Date pSec1 = new Date(now.getTime() + 1 * SECONDS);
        Date pMin1 = new Date(now.getTime() + 1 * MINUTES);
        Date pHour1 = new Date(now.getTime() + 1 * HOURS);

        assertEqualsFormatDuration("a minute", pSec1);
        assertEqualsFormatDuration("a minute", pMin1);
        assertEqualsFormatDuration("an hour", pHour1);
    }

    private void assertFormatDistance(String expected, Date date) {
        Assert.assertEquals(expected, formatter.formatDistance(date));
        Assert.assertEquals(expected, formatter.formatDistance(date, Locale.ENGLISH));
    }

    @Test
    public void testFormatDistance() {
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
        assertFormatDistance("in a months", month);
        assertFormatDistance("in 1 year", year);
        assertFormatDistance("in a century", year100);
    }
}
