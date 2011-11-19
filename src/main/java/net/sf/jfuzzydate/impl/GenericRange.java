package net.sf.jfuzzydate.impl;

import net.sf.jfuzzydate.Range;
import net.sf.jfuzzydate.Unit;


/**
 * A date/time range mapping time values up to an upper bound to an
 * externalized string.
 *
 * @author amaasch
 */
public class GenericRange implements Range {
    //~ Instance fields --------------------------------------------------------

    /**
     * Internationalization key for formatting values fitting in this
     * range.
     */
    private final String internationalizationKey;

    /**
     * The time unit of this range.
     */
    private final Unit unit;

    /**
     * The upper limit for values in this range.
     */
    private final long upperBound;

    //~ Constructors -----------------------------------------------------------

/**
     * Creates a new GenericRange object with an upper binding and a reference
     * to an externalized string.
     *
     * @param upperBoundSeconds
     * @param i18nKey
     * @param unit
     */
    public GenericRange(final long upperBoundSeconds, final String i18nKey,
                        final Unit unit) {
        upperBound = upperBoundSeconds * 1000;
        this.internationalizationKey = i18nKey;
        this.unit = unit;
    }

    //~ Methods ----------------------------------------------------------------

    /*
     * (non-Javadoc)
     *
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

    /**
     * Returns the unit of this range.
     *
     * @return the unit of this range.
     */
    public Unit getUnit() {
        return unit;
    }
}
