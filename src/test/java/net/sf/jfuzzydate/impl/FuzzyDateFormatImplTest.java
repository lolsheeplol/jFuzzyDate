package net.sf.jfuzzydate.impl;

import org.junit.After;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
     * The Constant DE.
     */
    private static final Locale DE = Locale.GERMAN;

    /**
     * The Constant EN.
     */
    private static final Locale EN = Locale.ENGLISH;

    /**
     * The Constant SECONDS_HOUR.
     */
    private static final int SECONDS_HOUR = 60 * 60;

    /**
     * The Constant SECONDS_DAY.
     */
    private static final long SECONDS_DAY = SECONDS_HOUR * 24;

    /**
     * The Constant SECONDS_YEAR.
     */
    private static final long SECONDS_YEAR = SECONDS_DAY * 356;

    //~ Instance fields --------------------------------------------------------------------------------------

    /**
     * The {@link Locale}.
     */
    private Locale defaultLocale;

    //~ Methods ----------------------------------------------------------------------------------------------

    /**
     * Sets up the test case.
     */
    @Before public void setUp() {
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.JAPANESE);
    }

    /**
     * Tear down.
     */
    @After public void tearDown() {
        Locale.setDefault(defaultLocale);
    }

    /**
     * Test method for {@link
     * net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#formatDistance(java.util.Date)
     * }.
     */
    @Test public void testFormatDistanceDate() {
        final FuzzyDateFormatterImpl impl = new FuzzyDateFormatterImpl(DefaultFuzzingConfiguration
                                                                       .getInstance());
        final Date aMinuteAgo = new Date(new Date().getTime() - (30 * 1000));
        final Date in35Minutes = new Date(new Date().getTime() + (60 * 35 * 1000));

        try {
            assertEquals(impl.formatDistance(aMinuteAgo),
                         impl.formatDistance(aMinuteAgo, Locale.getDefault()));
            assertEquals(impl.formatDistance(in35Minutes),
                         impl.formatDistance(in35Minutes, Locale.getDefault()));
        } catch (final MissingResourceException e) {
            // System.out.println("Warning: Resource for default locale not available for testing.");
        }
    }

    /**
     * Test method for {@link
     * net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#formatDistance(java.util.Date,
     * java.util.Locale)}.
     */
    @Test public void testFormatDistanceDateLocale() {
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
     * Test method for {@link
     * net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#formatDuration(long,
     * java.util.Locale)}.
     */
    @Test public void testFormatDurationLongLocale() {
        final FuzzyDateFormatterImpl impl = new FuzzyDateFormatterImpl(DefaultFuzzingConfiguration
                                                                       .getInstance());
        assertEquals("a minute", impl.formatDuration(30 * 1000, EN));
        assertEquals("two minutes", impl.formatDuration(60 * 2 * 1000, EN));
        assertEquals("35 minutes", impl.formatDuration(60 * 35 * 1000, EN));
        assertEquals("a day", impl.formatDuration(SECONDS_DAY * 1000, EN));
        assertEquals("5 days", impl.formatDuration(SECONDS_DAY * 5 * 1000, EN));
        assertEquals("a week", impl.formatDuration(SECONDS_DAY * 7 * 1000, EN));
    }

    /**
     * Test distance.
     *
     * @param expectedString the expected string
     * @param seconds        l
     * @param locale         the locale
     */
    private void testDistance(final String expectedString, final long seconds, final Locale locale) {
        final FuzzyDateFormatterImpl impl = new FuzzyDateFormatterImpl(DefaultFuzzingConfiguration
                                                                       .getInstance());

        final long now = new Date().getTime();

        assertEquals(expectedString, impl.formatDistance(new Date(now + (seconds * 1000)), locale));
    }
}
