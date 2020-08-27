package net.sf.jfuzzydate.impl;

import net.sf.jfuzzydate.Range;


/**
 * The unreachable, the one an only eternal fuzzing range. Calls to {@link
 * #contains(long)} will always return <code>true</code>.
 *
 * @author amaasch
 */
public final class Eternity implements Range {
    //~ Instance fields --------------------------------------------------------

    /**
     * The internationalization key used to format values of this range.
     */
    private final String internationalizationKey;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates an eteranal range.
     * 
     * @param i18nKey the i18N key.
     */
    public Eternity(final String i18nKey) {
        internationalizationKey = i18nKey;
    }

    //~ Methods ----------------------------------------------------------------

    /* (non-Javadoc)
     * @see net.sf.jfuzzydate.Range#contains(long)
     */
    public boolean contains(final long number) {
        return true;
    }

    /* (non-Javadoc)
     * @see net.sf.jfuzzydate.Range#getI18nKey()
     */
    public String getI18nKey() {
        return internationalizationKey;
    }
}
