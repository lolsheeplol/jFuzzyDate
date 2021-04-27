package net.sf.jfuzzydate.wb;

import net.sf.jfuzzydate.Unit;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

    @Test
    public void testUnit() {
        Unit sec = Unit.SECOND;
        Assert.assertEquals(1, sec.getSeconds());

        Unit min = Unit.MINUTE;
        Assert.assertEquals(60, min.getSeconds());
    }
}
