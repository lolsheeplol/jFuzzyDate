package net.sf.jfuzzydate;

import net.sf.jfuzzydate.i18n.FuzzyStrings;


/**
 * An object that represents a configuration for date and duration fuzzing.
 * 
 * <p>
 * A fuzzing configuration is a set of ranges which are mapped to
 * internationalized strings. Each of these ranges represents a special human
 * understanding of a distance of time or duration.
 * 
 * @author amaasch
 */
public interface FuzzingConfiguration {
    //~ Methods ----------------------------------------------------------------

    /**
     * This method returns an array of range objects. These are used to
     * map ranges of relative distances of time to internationalized readable
     * strings.
     *
     * @param strenght the fuzzing strength defining the granularity of ranges
     *        to return.
     *
     * @return an array of ranges for distances of time.
     */
    Range[] getDistanceRanges(FuzzingStrength strenght);

    /**
     * This method returns an array of range objects. These are used to
     * map ranges of durations to internationalized readable strings.
     *
     * @param strenght the fuzzing strength defining the granularity of ranges
     *        to return.
     *
     * @return an array of ranges for durations.
     */
    Range[] getDurationRanges(FuzzingStrength strenght);

    /**
     * Returns the configured fuzzy string builder instance.
     *
     * @return a FuzzyStrings object.
     */
    FuzzyStrings getStringBuilder();
}
