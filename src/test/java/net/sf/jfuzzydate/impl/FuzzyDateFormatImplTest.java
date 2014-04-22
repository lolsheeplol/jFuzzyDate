package net.sf.jfuzzydate.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;


/**
 * Test class for {@link FuzzyDateFormatterImpl}. Mostly black box testing.
 *
 * @author ma�
 */
public class FuzzyDateFormatImplTest {

    //~ Static fields/initializers ---------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     */
    private static final Locale DE = Locale.GERMAN;

    /**
     * TODO DOCUMENT ME!
     */
    private static final Locale EN = Locale.ENGLISH;

    /**
     * TODO DOCUMENT ME!
     */
    private static final int SECONDS_HOUR = 60 * 60;

    /**
     * TODO DOCUMENT ME!
     */
    private static final long SECONDS_DAY = SECONDS_HOUR * 24;

    /**
     * TODO DOCUMENT ME!
     */
    private static final long SECONDS_YEAR = SECONDS_DAY * 356;

    //~ Methods ----------------------------------------------------------------------------------------------

    /**
     * Test method for {@link net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#formatDistance(java.util.Date)}.
     */
    @Test
    public void testFormatDistanceDate() {
        FuzzyDateFormatterImpl impl = new FuzzyDateFormatterImpl(DefaultFuzzingConfiguration.getInstance());
        Date aMinuteAgo = new Date(new Date().getTime() - (30 * 1000));
        Date in35Minutes = new Date(new Date().getTime() + (60 * 35 * 1000));

        try {
            assertEquals(impl.formatDistance(aMinuteAgo),
                         impl.formatDistance(aMinuteAgo, Locale.getDefault()));
            assertEquals(impl.formatDistance(in35Minutes),
                         impl.formatDistance(in35Minutes, Locale.getDefault()));
        } catch (MissingResourceException e) {
            // System.out.println("Warning: Resource for default locale not available for testing.");
        }
    }

    /**
     * Test method for
     * {@link net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#formatDistance(java.util.Date, java.util.Locale)}.
     */
    @Test
    public void testFormatDistanceDateLocale() {
        testDistance("a minute ago", -30, EN);
        testDistance("in a minute", 30, EN);
        testDistance("two minutes ago", -60 * 2, EN);
        testDistance("in two minutes", 60 * 2, EN);
        testDistance("in 35 minutes", 60 * 35, EN);
        testDistance("in 3 hours", (3 * SECONDS_HOUR) + (60 * 20), EN);
        testDistance("a day ago", -SECONDS_DAY - 500, EN);
        testDistance("in 5 days", SECONDS_DAY * 5, EN);
        testDistance("a week ago", -SECONDS_DAY * 7, EN);
        testDistance("a year ago", -SECONDS_DAY * 350, EN);
        testDistance("3 years ago", (-SECONDS_YEAR * 3) - (SECONDS_DAY * 30), EN);
        testDistance("3 centuries ago", -SECONDS_YEAR * 340, EN);

        testDistance("vor einer Woche", -SECONDS_DAY * 7, DE);
        testDistance("vor zwei Wochen", -SECONDS_DAY * 14, DE);
        testDistance("in 3 Wochen", SECONDS_DAY * 21, DE);
        testDistance("vor 4 Monaten", -SECONDS_DAY * 130, DE);
        testDistance("in einem Jahr", SECONDS_DAY * 400, DE);
    }

    /**
     * Test method for
     * {@link net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#formatDuration(java.util.Date, java.util.Date, java.util.Locale)}
     * .
     */
    @Test
    public void testFormatDurationDateDateLocale() {
    }

    /**
     * Test method for
     * {@link net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#formatDuration(java.util.Date, java.util.Locale)}.
     */
    @Test
    public void testFormatDurationDateLocale() {
    }

    /**
     * Test method for
     * {@link net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#formatDuration(long, java.util.Locale)}.
     */
    @Test
    public void testFormatDurationLongLocale() {
        FuzzyDateFormatterImpl impl = new FuzzyDateFormatterImpl(DefaultFuzzingConfiguration.getInstance());
        assertEquals("a minute", impl.formatDuration(30 * 1000, EN));
        assertEquals("two minutes", impl.formatDuration(60 * 2 * 1000, EN));
        assertEquals("35 minutes", impl.formatDuration(60 * 35 * 1000, EN));
        assertEquals("a day", impl.formatDuration(SECONDS_DAY * 1000, EN));
        assertEquals("5 days", impl.formatDuration(SECONDS_DAY * 5 * 1000, EN));
        assertEquals("a week", impl.formatDuration(SECONDS_DAY * 7 * 1000, EN));
    }

    /**
     * Test method for
     * {@link net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#FuzzyDateFormatImpl(net.sf.jfuzzydate.impl.DefaultFuzzingConfiguration)}
     * .
     */
    @Test
    public void testFuzzyDateFormatImpl() {
    }

    /**
     * TODO DOCUMENT ME!
     *
     * @param expectedString
     * @param seconds        l
     * @param locale
     */
    private void testDistance(String expectedString, long seconds, Locale locale) {
        FuzzyDateFormatterImpl impl = new FuzzyDateFormatterImpl(DefaultFuzzingConfiguration.getInstance());

        final long now = new Date().getTime();

        assertEquals(expectedString, impl.formatDistance(new Date(now + (seconds * 1000)), locale));
    }
}
