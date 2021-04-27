package net.sf.jfuzzydate.wb;

import net.sf.jfuzzydate.FuzzingConfiguration;
import net.sf.jfuzzydate.FuzzingStrength;
import net.sf.jfuzzydate.FuzzyStringProvider;
import net.sf.jfuzzydate.Range;
import net.sf.jfuzzydate.i18n.ResourceBundleFSProvider;

public class BadRangeFuzzingConfiguration implements FuzzingConfiguration {

    private static final String FUZZY_STRING_BUNDLE = "net.sf.jfuzzydate.i18n.jFuzzyDate";

    private final FuzzyStringProvider fuzzyStrings = new ResourceBundleFSProvider(FUZZY_STRING_BUNDLE);

    @Override
    public Range[] getDistanceRanges(FuzzingStrength strenght) {
        return new Range[0];
    }

    @Override
    public Range[] getDurationRanges(FuzzingStrength strenght) {
        return new Range[0];
    }

    @Override
    public FuzzyStringProvider getStringProvider() {
        return fuzzyStrings;
    }
}
