package net.sf.jfuzzydate.i18n;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Locale;


/**
 * Tests {@link ResourceBundleFSProvider}
 *
 * @author amaasch
 */
public class ResourceBundleFSProviderTest {
    //~ Methods ----------------------------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     */
    @Test
    public void testGetStringString() {
        ResourceBundleFSProvider resourceBundleFSProvider = new ResourceBundleFSProvider("net.sf.jfuzzydate.i18n.ResourceBundleFSProviderTest");

        if (Locale.getDefault().equals(Locale.ENGLISH) || Locale.getDefault().equals(Locale.US) ||
                Locale.getDefault().equals(Locale.UK)) {
            assertEquals("apple", resourceBundleFSProvider.getString("fruit"));
        }

        if (Locale.getDefault().equals(Locale.GERMAN) || Locale.getDefault().equals(Locale.GERMANY)) {
            assertEquals("Apfel", resourceBundleFSProvider.getString("fruit"));
        }
    }

    /**
     * TODO DOCUMENT ME!
     */
    @Test
    public void testGetStringStringLocale() {
        final ResourceBundleFSProvider resourceBundleFSProvider = new ResourceBundleFSProvider("net.sf.jfuzzydate.i18n.ResourceBundleFSProviderTest");
        assertEquals("apple", resourceBundleFSProvider.getString("fruit", Locale.ENGLISH));
        assertEquals("Apfel", resourceBundleFSProvider.getString("fruit", Locale.GERMAN));
    }

    /**
     * TODO DOCUMENT ME!
     */
    @Test
    public void testGetStringStringLocaleObjectArray() {
        final ResourceBundleFSProvider resourceBundleFSProvider = new ResourceBundleFSProvider("net.sf.jfuzzydate.i18n.ResourceBundleFSProviderTest");

        assertEquals("apple", resourceBundleFSProvider.getString("fruit", Locale.ENGLISH, null));
        assertEquals("Apfel", resourceBundleFSProvider.getString("fruit", Locale.GERMAN, null));

        assertEquals("apple abc", resourceBundleFSProvider.getString("fruitwithparam", Locale.ENGLISH, "abc"));
        assertEquals("Apfel def", resourceBundleFSProvider.getString("fruitwithparam", Locale.GERMAN, "def"));
    }

    /**
     * TODO DOCUMENT ME!
     */
    @Test
    public void testResourceBundleFSProvider() {
        try {
            new ResourceBundleFSProvider("net.sf.jfuzzydate.i18n.ResourceBundleFSProviderTest");
        } catch (final Throwable e) {
            fail("Failed to initialize ResourceBundleFSProvider class");
        }
    }
}
