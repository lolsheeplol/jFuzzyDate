package net.sf.jfuzzydate.wb;

import net.sf.jfuzzydate.FuzzingConfiguration;
import net.sf.jfuzzydate.FuzzingStrength;
import net.sf.jfuzzydate.Range;
import net.sf.jfuzzydate.impl.DefaultFuzzingConfiguration;
import org.junit.Assert;
import org.junit.Test;

public class DefaultFuzzingConfigurationTest {

    @Test
    public void testFuzzingConfigurationStringProviderNotNull() {
        FuzzingConfiguration config = DefaultFuzzingConfiguration.getInstance();

        Assert.assertNotNull(config.getStringProvider());
    }

    @Test
    public void testFuzzingConfigurationDurationRange() {
        FuzzingConfiguration config = DefaultFuzzingConfiguration.getInstance();

        Range[] normalRange = config.getDurationRanges(FuzzingStrength.NORMAL);
        Range[] strongRange = config.getDurationRanges(FuzzingStrength.STRONG);
        Range[] extremeRange = config.getDurationRanges(FuzzingStrength.EXTREME);

        Assert.assertArrayEquals(normalRange, strongRange);
        Assert.assertArrayEquals(normalRange, extremeRange);
    }

    @Test
    public void testFuzzingConfigurationDistanceRange() {
        FuzzingConfiguration config = DefaultFuzzingConfiguration.getInstance();

        Range[] normalRange = config.getDistanceRanges(FuzzingStrength.NORMAL);
        Range[] strongRange = config.getDistanceRanges(FuzzingStrength.STRONG);
        Range[] extremeRange = config.getDistanceRanges(FuzzingStrength.EXTREME);

        Assert.assertArrayEquals(normalRange, strongRange);
        Assert.assertArrayEquals(normalRange, extremeRange);
    }
}
