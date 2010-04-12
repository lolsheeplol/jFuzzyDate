package net.sf.jfuzzydate;

import net.sf.jfuzzydate.impl.Range;

import java.util.Locale;


/**
 * 
 *
 * @author $author$
 * @version $Revision$
  */
public interface FuzzingConfiguration {
    //~ Methods ----------------------------------------------------------------

    /**
     * 
     *
     * @param strenght 
     *
     * @return 
     */
    Range[] getDistanceIntervals(FuzzingStrength strenght);

    /**
     * 
     *
     * @param strenght 
     *
     * @return 
     */
    Range[] getDurationIntervals(FuzzingStrength strenght);

    /**
     * 
     *
     * @param range 
     * @param locale 
     *
     * @return 
     */
    String getFuzzyString(Range range, Locale locale, Object... params);

    /**
     * 
     *
     * @param pattern
     * @param locale
     *
     * @return
     */
    String getFuzzyString(String pattern, Locale locale, Object... params);
}
