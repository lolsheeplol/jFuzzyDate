package net.sf.jfuzzydate;

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

    private static FuzzyDateFormatter formatter;
    private static Date today;

    @BeforeClass
    public static void beforeAll() {
        formatter = new FuzzyDateFormatterImpl(DefaultFuzzingConfiguration.getInstance());
    }

    @Before
    public void beforeTests() {
        today = new Date(2021, Calendar.APRIL, 24);
    }

    @Test
    public void testFormat() {
        // known to be 'not implemented'
        Date now = new Date();
        Assert.assertEquals("not implemented", formatter.format(now));
        Assert.assertEquals("not implemented", formatter.format(now, Locale.ENGLISH));
    }

    @Test
    public void testFormatDurationDate() {
        Date now = new Date();
        Date tenSecondsAgo = new Date(now.getTime() + 10 * 1000);
        Date thirtySecondsAgo = new Date(now.getTime() + 30 * 1000);
        Date thirtyOneSecondsAgo = new Date(now.getTime() + 31 * 1000);
    }

    @Test
    public void testFormatDurationMillis() {

    }

    @Test
    public void testFormatDistance() {

    }
}
