package net.sf.jfuzzydate;

import net.sf.jfuzzydate.impl.DefaultFuzzingConfiguration;
import org.junit.Assert;
import org.junit.Test;

public class FuzzingConfigurationTest {

    @Test
    public void testFuzzingConfigurationInstanceNotNull() {
        FuzzingConfiguration instance = DefaultFuzzingConfiguration.getInstance();
        Assert.assertNotNull(instance);
    }

    @Test
    public void testFuzzingConfiguration() {

    }
}
