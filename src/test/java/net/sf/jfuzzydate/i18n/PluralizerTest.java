package net.sf.jfuzzydate.i18n;

import net.sf.jfuzzydate.FuzzyStringProvider;

import org.jmock.Expectations;
import org.jmock.Mockery;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Locale;


/**
 * Tests {@link Pluralizer}.
 *
 * @author amaasch
 */
public class PluralizerTest {
    //~ Instance fields --------------------------------------------------------------------------------------

    /**
     * The jmock context.
     */
    private Mockery mockery = new Mockery();

    //~ Methods ----------------------------------------------------------------------------------------------

    /**
     * Tests {@link Pluralizer#pluralize(int, String, Locale)}
     */
    @Test
    public void testPluralize() {
        final FuzzyStringProvider stringProvider = mockery.mock(FuzzyStringProvider.class);
        mockery.checking(new Expectations() {

                {
                    allowing(stringProvider).getString("plurals.mode", Locale.ENGLISH);
                    will(returnValue("TWO_FORMS_1"));
                    allowing(stringProvider).getString("day", Locale.ENGLISH);
                    will(returnValue("day;days"));

                    allowing(stringProvider).getString("plurals.mode", Locale.FRENCH);
                    will(returnValue("TWO_FORMS_2"));
                    allowing(stringProvider).getString("day", Locale.FRENCH);
                    will(returnValue("jour;jours"));
                }
            });

        final Pluralizer pluralizer = new Pluralizer(stringProvider);
        assertEquals("days", pluralizer.pluralize(0, "day", Locale.ENGLISH));
        assertEquals("day", pluralizer.pluralize(1, "day", Locale.ENGLISH));
        assertEquals("days", pluralizer.pluralize(2, "day", Locale.ENGLISH));
        assertEquals("days", pluralizer.pluralize(9, "day", Locale.ENGLISH));
        assertEquals("days", pluralizer.pluralize(11, "day", Locale.ENGLISH));

        assertEquals("jour", pluralizer.pluralize(0, "day", Locale.FRENCH));
        assertEquals("jour", pluralizer.pluralize(1, "day", Locale.FRENCH));
        assertEquals("jours", pluralizer.pluralize(2, "day", Locale.FRENCH));
        assertEquals("jours", pluralizer.pluralize(9, "day", Locale.FRENCH));
        assertEquals("jours", pluralizer.pluralize(11, "day", Locale.FRENCH));

        mockery.assertIsSatisfied();
    }

    /**
     * Tests {@link Pluralizer#Pluralizer(FuzzyStringProvider)}
     */
    @Test
    public void testPluralizerFuzzyStringProvider() {
        FuzzyStringProvider stringProvider = new ResourceBundleFSProvider("some.bundle");

        try {
            Pluralizer pluralizer1 = new Pluralizer(null);
            fail("Expected an exception on init with null stringprovider.");
        } catch (final Exception e) {
        }

        try {
            Pluralizer pluralizer2 = new Pluralizer(stringProvider);
        } catch (final Exception e) {
            fail("Failed to initialize pluralizer with non-null argument.");
        }
    }

    /**
     * Tests {@link Pluralizer#Pluralizer(FuzzyStringProvider, String)}
     */
    @Test
    public void testPluralizerFuzzyStringProviderString() {
        FuzzyStringProvider stringProvider = new ResourceBundleFSProvider("some.bundle");

        try {
            Pluralizer pluralizer1 = new Pluralizer(null, ";");
            Pluralizer pluralizer2 = new Pluralizer(null, null);
            fail("Expected an exception on init with null stringprovider.");
        } catch (final Exception e) {
        }

        try {
            Pluralizer pluralizer2 = new Pluralizer(stringProvider, ";");
            Pluralizer pluralizer4 = new Pluralizer(stringProvider, null);
        } catch (final Exception e) {
            fail("Failed to initialize pluralizer with non-null stringprovider.");
        }

    }
}
