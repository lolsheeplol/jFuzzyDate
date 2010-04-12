package net.sf.jfuzzydate;

import net.sf.jfuzzydate.impl.DefaultFuzzingConfiguration;
import net.sf.jfuzzydate.impl.FuzzyDateFormatImpl;


/**
 * 
 *
 * @author ma³
 */
public final class FuzzyDateFormat {
    //~ Methods ----------------------------------------------------------------

    /**
     * 
     *
     * @return 
     */
    public static final FuzzyDateFormatter getInstance() {
        return new FuzzyDateFormatImpl(DefaultFuzzingConfiguration.getInstance());
    }
}
