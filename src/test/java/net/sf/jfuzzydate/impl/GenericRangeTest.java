package net.sf.jfuzzydate.impl;

import net.sf.jfuzzydate.Unit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Tests {@link GenericRange}
 *
 * @author amaasch
 */
public class GenericRangeTest {
    //~ Methods ----------------------------------------------------------------------------------------------

    /**
     * Test {@link GenericRange#contains(long)}
     */
    @Test
    public void testContains() {
        final GenericRange range = new GenericRange(500, "foo", Unit.SECOND);

        assertTrue(range.contains(-1000 * 1000));
        assertTrue(range.contains(0));
        assertTrue(range.contains(499 * 1000));
        assertFalse(range.contains(500 * 1000));
    }

    /**
     * Tests {@link GenericRange} constructor.
     */
    @Test
    public void testGenericRange() {
        new GenericRange(500, "foo", Unit.SECOND);
        new GenericRange(0, "foo", Unit.SECOND);
        new GenericRange(500, null, Unit.SECOND);
        new GenericRange(500, "foo", null);
    }

    /**
     * Tests {@link GenericRange#getI18nKey()}
     */
    @Test
    public void testGetI18nKey() {
        final String key = "key-8q58476";
        final GenericRange range = new GenericRange(500, key, Unit.SECOND);
        assertEquals(key, range.getI18nKey());
    }

    /**
     * Tests {@link GenericRange#getUnit()}
     */
    @Test
    public void testGetUnit() {
        final Unit unit = Unit.YEAR;
        final GenericRange range = new GenericRange(500, "foo", unit);
        assertEquals(unit, range.getUnit());
    }
}
