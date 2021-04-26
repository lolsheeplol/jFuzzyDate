package net.sf.jfuzzydate.st;

import net.sf.jfuzzydate.FuzzingConfiguration;
import net.sf.jfuzzydate.impl.DefaultFuzzingConfiguration;
import org.junit.Assert;
import org.junit.Test;

public class FuzzingConfigurationTest {

    @Test
    public void testDefaultFuzzingConfigurationInstanceSame() {
        FuzzingConfiguration instance = DefaultFuzzingConfiguration.getInstance();
        FuzzingConfiguration another = DefaultFuzzingConfiguration.getInstance();
        Assert.assertSame(instance, another);
    }

    @Test
    public void testFuzzingConfigurationInstanceNotNull() {
        FuzzingConfiguration instance = DefaultFuzzingConfiguration.getInstance();
        Assert.assertNotNull(instance);
    }
}
