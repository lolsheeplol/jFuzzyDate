package net.sf.jfuzzydate.wb;

import net.sf.jfuzzydate.FuzzingConfiguration;
import net.sf.jfuzzydate.FuzzingStrength;
import net.sf.jfuzzydate.FuzzyStringProvider;
import net.sf.jfuzzydate.Range;

public class BadPluralizerFuzzingConfiguration implements FuzzingConfiguration {
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
        return null;
    }
}
