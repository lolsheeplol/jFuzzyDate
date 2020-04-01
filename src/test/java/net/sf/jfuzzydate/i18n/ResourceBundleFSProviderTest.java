package net.sf.jfuzzydate.i18n;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.Locale;


/**
 * Tests {@link ResourceBundleFSProvider}.
 *
 * @author amaasch
 */
public class ResourceBundleFSProviderTest {

    //~ Methods ----------------------------------------------------------------------------------------------

    /**
     * Test get string string.
     */
    @Test public void testGetStringString() {
        final ResourceBundleFSProvider resourceBundleFSProvider = new ResourceBundleFSProvider("net.sf.jfuzzydate.i18n.ResourceBundleFSProviderTest");

        if (Locale.getDefault().equals(Locale.ENGLISH) || Locale.getDefault().equals(Locale.US) ||
                Locale.getDefault().equals(Locale.UK)) {
            assertEquals("apple", resourceBundleFSProvider.getString("fruit"));
        }

        if (Locale.getDefault().equals(Locale.GERMAN) || Locale.getDefault().equals(Locale.GERMANY)) {
            assertEquals("Apfel", resourceBundleFSProvider.getString("fruit"));
        }
    }

    /**
     * Test get string string locale.
     */
    @Test public void testGetStringStringLocale() {
        final ResourceBundleFSProvider resourceBundleFSProvider = new ResourceBundleFSProvider("net.sf.jfuzzydate.i18n.ResourceBundleFSProviderTest");
        assertEquals("apple", resourceBundleFSProvider.getString("fruit", Locale.ENGLISH));
        assertEquals("Apfel", resourceBundleFSProvider.getString("fruit", Locale.GERMAN));
    }

    /**
     * Test get string for unknown locale.
     */
    @Test public void testGetStringForUnknownLocale() {
        final Locale defaultLocale = Locale.getDefault();

        // switch to something not supported as default
        Locale.setDefault(Locale.CHINESE);

        final ResourceBundleFSProvider resourceBundleFSProvider = new ResourceBundleFSProvider("net.sf.jfuzzydate.i18n.ResourceBundleFSProviderTest");
        assertEquals("default", resourceBundleFSProvider.getString("fruit", Locale.JAPAN));

        Locale.setDefault(defaultLocale);
    }

    /**
     * Test get string string locale object array.
     */
    @Test public void testGetStringStringLocaleObjectArray() {
        final ResourceBundleFSProvider resourceBundleFSProvider = new ResourceBundleFSProvider("net.sf.jfuzzydate.i18n.ResourceBundleFSProviderTest");

        assertEquals("apple", resourceBundleFSProvider.getString("fruit", Locale.ENGLISH, null));
        assertEquals("Apfel", resourceBundleFSProvider.getString("fruit", Locale.GERMAN, null));

        assertEquals("apple abc",
                     resourceBundleFSProvider.getString("fruitwithparam", Locale.ENGLISH, "abc"));
        assertEquals("Apfel def", resourceBundleFSProvider.getString("fruitwithparam", Locale.GERMAN, "def"));
    }

    /**
     * Test resource bundle fs provider.
     */
    @Test public void testResourceBundleFSProvider() {
        try {
            new ResourceBundleFSProvider("net.sf.jfuzzydate.i18n.ResourceBundleFSProviderTest");
        } catch (final Throwable e) {
            fail("Failed to initialize ResourceBundleFSProvider class");
        }
    }

    /**
     * In this test case we get fallback resource for not existing resource in locale "Chinese".
     */
    @Test
    public void testResourceBundleFSProviderWithFallback() {
        final ResourceBundleFSProvider resourceBundleFSProvider = new ResourceBundleFSProvider("net.sf.jfuzzydate.i18n.ResourceBundleFSProviderTest");
        assertEquals("default", resourceBundleFSProvider.getString("fruit", Locale.CHINESE));
    }
}
