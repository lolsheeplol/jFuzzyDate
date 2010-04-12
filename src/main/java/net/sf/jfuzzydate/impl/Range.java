package net.sf.jfuzzydate.impl;

/**
 * 
 *
 * @author ma³
 */
public class Range {
    //~ Static fields/initializers ---------------------------------------------

    /**
     * 
     */
    public static final Range ETERNAL = new Range(Long.MAX_VALUE,
                                                  "distance.eternal");

    //~ Instance fields --------------------------------------------------------

    /**
     * 
     */
    private Long parameterDivisor;

    /**
     * 
     */
    private final String bundleKey;

    /**
     * 
     */
    private final long upperBound;

    //~ Constructors -----------------------------------------------------------

/**
     * Creates a new Intervall object.
     *
     * @param upperBound 
     * @param bundleKey 
     */
    public Range(final long upperBound, final String bundleKey) {
        this.upperBound = upperBound * 1000;
        this.bundleKey = bundleKey;
    }

/**
         * Creates a new Intervall object.
         *
         * @param upperBound 
         * @param bundleKey 
         * @param parameterDivisor 
         */
    public Range(final long upperBound, final String bundleKey,
                 final long parameterDivisor) {
        this.upperBound = upperBound * 1000;
        this.bundleKey = bundleKey;
        this.parameterDivisor = parameterDivisor * 1000;
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * 
     *
     * @return the bundleKey
     */
    public String getBundleKey() {
        return bundleKey;
    }

    /**
     * 
     *
     * @return the parameterDivisor
     */
    public long getParameterDivisor() {
        return parameterDivisor;
    }

    /**
     * 
     *
     * @return the upperBound
     */
    public long getUpperBound() {
        return upperBound;
    }

    /**
     * 
     *
     * @return
     */
    public boolean hasDivisor() {
        return parameterDivisor != null;
    }
}
