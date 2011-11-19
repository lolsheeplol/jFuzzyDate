package net.sf.jfuzzydate.impl;

import net.sf.jfuzzydate.Range;


/**
 * Static fuzzing range.
 *
 * @author amaasch
 */
public class StaticRange implements Range {
    //~ Instance fields --------------------------------------------------------

    /**
     * Internationalization key for formatting values fitting in this range.
     */
    private final String internationalizationKey;

    /**
     * Upper limit for the range.
     */
    private final long upperBound;

    //~ Constructors -----------------------------------------------------------

/**
     * @param i
     * @param string
     */
    public StaticRange(final long upperBoundSeconds, final String i18nKey) {
        upperBound = upperBoundSeconds * 1000;
        this.internationalizationKey = i18nKey;
    }

    //~ Methods ----------------------------------------------------------------

    /* (non-Javadoc)
     * @see net.sf.jfuzzydate.Range#contains(long)
     */
    public boolean contains(final long number) {
        return number < upperBound;
    }

    /* (non-Javadoc)
     * @see net.sf.jfuzzydate.Range#getI18nKey()
     */
    public String getI18nKey() {
        return internationalizationKey;
    }
}
