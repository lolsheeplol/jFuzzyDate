package net.sf.jfuzzydate;

import net.sf.jfuzzydate.impl.DefaultFuzzingConfiguration;
import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Tests {@link FuzzyDateFormat}
 *
 * @author amaasch
 */
public class FuzzyDateFormatTest {
    //~ Methods ----------------------------------------------------------------------------------------------

    /**
     * Tests {@link FuzzyDateFormat#getInstance()}
     */
    @Test
    public void testGetInstance() {
        FuzzyDateFormatter instance = FuzzyDateFormat.getInstance();
        assertNotNull(instance);
    }

    /**
     * Tests {@link FuzzyDateFormat#getInstance(FuzzingConfiguration)}
     */
    @Test
    public void testGetInstanceFuzzingConfiguration() {
        FuzzyDateFormatter instance = FuzzyDateFormat.getInstance(DefaultFuzzingConfiguration.getInstance());
        assertNotNull(instance);
    }
}
