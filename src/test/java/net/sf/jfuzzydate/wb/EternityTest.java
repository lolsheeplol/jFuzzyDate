package net.sf.jfuzzydate.wb;

import net.sf.jfuzzydate.impl.Eternity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EternityTest {

    @Test
    public void testContains() {
        final Eternity eternity = new Eternity("abc123");
        assertTrue("All long numbers should be contained by eternity.", eternity.contains(1));
        assertTrue("All long numbers should be contained by eternity.", eternity.contains(Long.MAX_VALUE));
    }


    @Test
    public void testGetI18nKey() {
        final String i18nKey = "yenlahbbxcvj";
        final Eternity eternity = new Eternity(i18nKey);
        assertEquals("getI18nKey should return value given in constructor.", i18nKey, eternity.getI18nKey());
    }
}
