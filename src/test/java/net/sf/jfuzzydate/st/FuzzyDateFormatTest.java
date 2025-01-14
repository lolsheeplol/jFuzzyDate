package net.sf.jfuzzydate.st;

import net.sf.jfuzzydate.FuzzyDateFormat;
import net.sf.jfuzzydate.FuzzyDateFormatter;
import net.sf.jfuzzydate.impl.DefaultFuzzingConfiguration;
import org.junit.Assert;
import org.junit.Test;

public class FuzzyDateFormatTest {

    @Test
    public void testFuzzyDateFormatInstance() {
        FuzzyDateFormatter instance = FuzzyDateFormat.getInstance();
        Assert.assertNotNull(instance);

        FuzzyDateFormatter another = FuzzyDateFormat.getInstance(DefaultFuzzingConfiguration.getInstance());
        Assert.assertNotNull(another);

        // do we need to compare the instances?
    }
}
