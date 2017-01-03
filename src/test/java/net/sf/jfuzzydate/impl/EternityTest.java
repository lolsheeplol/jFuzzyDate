package net.sf.jfuzzydate.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Tests {@link Eternity}.
 *
 * @author amaasch
 */
public class EternityTest {
    //~ Methods ----------------------------------------------------------------------------------------------

    /**
     * Tests {@link Eternity#contains(long)}.
     */
    @Test
    public void testContains() {
        final Eternity eternity = new Eternity("abc123");
        assertTrue("All long numbers should be contained by eternity.", eternity.contains(Long.MIN_VALUE));
        assertTrue("All long numbers should be contained by eternity.", eternity.contains(-1));
        assertTrue("All long numbers should be contained by eternity.", eternity.contains(0));
        assertTrue("All long numbers should be contained by eternity.", eternity.contains(1));
        assertTrue("All long numbers should be contained by eternity.", eternity.contains(Long.MAX_VALUE));
    }

    /**
     * Tests {@link Eternity#Eternity(String)} and {@link Eternity#getI18nKey()}.
     */
    @Test
    public void testGetI18nKey() {
        final String i18nKey = "yenlahbbxcvj";
        final Eternity eternity = new Eternity(i18nKey);
        assertEquals("getI18nKey should return value given in constructor.", i18nKey, eternity.getI18nKey());
    }
}
