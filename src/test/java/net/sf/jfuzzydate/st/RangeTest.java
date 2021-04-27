package net.sf.jfuzzydate.st;

import net.sf.jfuzzydate.Unit;
import net.sf.jfuzzydate.impl.GenericRange;
import org.junit.Assert;
import org.junit.Test;

public class RangeTest {

    @Test
    public void testRangeKey() {
        String key = "foobar";
        GenericRange range = new GenericRange(10, key, Unit.SECOND);
        Assert.assertNotNull(range.getI18nKey());
        Assert.assertEquals(key, range.getI18nKey());
    }

    @Test
    public void testRangeUnit() {
        Unit unit = Unit.SECOND;
        GenericRange range = new GenericRange(100, "foobar", unit);
        Assert.assertNotNull(range.getUnit());
        Assert.assertEquals(unit, range.getUnit());
    }
    @Test
    public void testRangeContains() {
        GenericRange range = new GenericRange(60, "foobar", Unit.SECOND);
        Assert.assertTrue(range.contains(0));
        Assert.assertTrue(range.contains(1000));
        Assert.assertTrue(range.contains(59 * 1000));

        Assert.assertFalse(range.contains(60 * 1000));
        Assert.assertFalse(range.contains(100 * 1000));

        Assert.assertTrue(range.contains(-1));
        Assert.assertTrue(range.contains(-59 * 1000));
        Assert.assertTrue(range.contains(-60 * 1000));
        Assert.assertTrue(range.contains(-1000 * 1000));
    }
}
