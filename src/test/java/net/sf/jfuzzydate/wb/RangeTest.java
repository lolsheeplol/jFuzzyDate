package net.sf.jfuzzydate.wb;

import net.sf.jfuzzydate.Unit;
import net.sf.jfuzzydate.impl.GenericRange;
import net.sf.jfuzzydate.impl.StaticRange;
import org.junit.Assert;
import org.junit.Test;

public class RangeTest {

    @Test
    public void testRangeKey() {
        final String key = "foobar";
        GenericRange range = new GenericRange(10, key, Unit.SECOND);
        Assert.assertNotNull(range.getI18nKey());
        Assert.assertEquals(key, range.getI18nKey());
    }

    @Test
    public void testRangeUnit() {
        final Unit unit = Unit.SECOND;
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

    @Test
    public void testRangeContainsUpperBoundZero() {
        GenericRange range = new GenericRange(0, "foobar", Unit.SECOND);

        Assert.assertFalse(range.contains(0));
        Assert.assertFalse(range.contains(1));

        Assert.assertTrue(range.contains(-1));
        Assert.assertTrue(range.contains(-1000));
    }

    @Test
    public void testStaticRangeKey() {
        final String key = "foorbar";
        StaticRange range = new StaticRange(10, key);
        Assert.assertNotNull(range.getI18nKey());
        Assert.assertEquals(key, range.getI18nKey());
    }

    @Test
    public void testStaticRangeContains() {
        final int bound = 100;
        StaticRange range = new StaticRange(bound, "foobar");

        Assert.assertTrue(range.contains(10 * 1000));
        Assert.assertFalse(range.contains(100 * 1000));
    }
}
