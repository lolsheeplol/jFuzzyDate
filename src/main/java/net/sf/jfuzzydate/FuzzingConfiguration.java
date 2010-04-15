package net.sf.jfuzzydate;

import net.sf.jfuzzydate.impl.Range;

import java.util.Locale;


/**
 * An object that represents a configuration for date and duration fuzzing.
 * 
 * <p>A fuzzing configuration is a set of ranges which are mapped to 
 * internationalized strings. Each of these ranges represents a special human 
 * understanding of a distance of time or duration.
 *
 * @author ma³
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
     * DOCUMENT ME!
     *
     * @param strenght DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    Range[] getDurationRanges(FuzzingStrength strenght);

    /**
     * DOCUMENT ME!
     *
     * @param range
     * @param locale
     *
     * @return
     */
    String getFuzzyString(Range range, Locale locale, Object... params);

    /**
     * DOCUMENT ME!
     *
     * @param pattern
     * @param locale
     *
     * @return
     */
    String getFuzzyString(String pattern, Locale locale, Object... params);
}
