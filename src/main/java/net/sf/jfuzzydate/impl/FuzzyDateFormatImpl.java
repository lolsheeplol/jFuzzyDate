package net.sf.jfuzzydate.impl;

import net.sf.jfuzzydate.FuzzingConfiguration;
import net.sf.jfuzzydate.FuzzingStrength;
import net.sf.jfuzzydate.FuzzyDateFormatter;

import java.util.Date;
import java.util.Locale;


/**
 * Basic implementation for fuzzy date formatting.
 *
 * @author ma³
 */
public class FuzzyDateFormatImpl implements FuzzyDateFormatter {
    //~ Instance fields --------------------------------------------------------

    /**
     * 
     */
    private FuzzingConfiguration config;

    //~ Constructors -----------------------------------------------------------

/**
     * Creates a new FuzzyDateFormatImpl object.
     *
     * @param config 
     */
    public FuzzyDateFormatImpl(DefaultFuzzingConfiguration config) {
        this.config = config;
    }

    //~ Methods ----------------------------------------------------------------

    /* (non-Javadoc)
    * @see net.sf.jfuzzydate.FuzzyDateFormatter#format(java.util.Date)
    */
    public String format(final Date date) {
        return format(date, Locale.getDefault());
    }

    /* (non-Javadoc)
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#format(java.util.Date, java.util.Locale)
     */
    public String format(final Date date, final Locale locale) {
        return formatDate(date.getTime() - new Date().getTime(),
                          FuzzingStrength.NORMAL, locale);
    }

    /* (non-Javadoc)
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#formatDistance(java.util.Date)
     */
    public String formatDistance(Date date) {
        return format(date, Locale.getDefault());
    }

    /* (non-Javadoc)
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#formatDistance(java.util.Date, java.util.Locale)
     */
    public String formatDistance(Date date, Locale locale) {
        return formatDistance(date.getTime() - new Date().getTime(),
                              FuzzingStrength.NORMAL, locale);
    }

    /* (non-Javadoc)
    * @see net.sf.jfuzzydate.FuzzyDateFormatter#formatDuration(long, java.util.Locale)
    */
    public String formatDuration(long milliSeconds, Locale locale) {
        return formatDuration(milliSeconds, FuzzingStrength.NORMAL, locale);
    }

    /* (non-Javadoc)
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#formatDuration(java.util.Date, java.util.Locale)
     */
    public String formatDuration(Date relative, Locale locale) {
        return formatDuration(new Date().getTime() - relative.getTime(), locale);
    }

    /* (non-Javadoc)
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#formatDuration(java.util.Date, java.util.Date, java.util.Locale)
     */
    public String formatDuration(Date from, Date to, Locale locale) {
        return formatDuration(to.getTime() - from.getTime(), locale);
    }

    /**
     * 
     *
     * @param l
     * @param normal
     * @param locale
     *
     * @return
     */
    private String formatDate(long l, FuzzingStrength normal, Locale locale) {
        return "not implemented";
    }

    /**
     * 
     *
     * @param distanceSec
     * @param strength
     * @param locale
     *
     * @return
     */
    private String formatDistance(final long distanceSec,
                                  final FuzzingStrength strength,
                                  final Locale locale) {
        String pattern;

        if (distanceSec <= 0) {
            pattern = "distance.past.pattern";
        } else {
            pattern = "distance.future.pattern";
        }

        final long absDistance = Math.abs(distanceSec);

        for (final Range range : config.getDistanceIntervals(strength)) {
            if (absDistance < range.getUpperBound()) {
                if (range.hasDivisor()) {
                    final int parameter = Math.round(absDistance / range.getParameterDivisor());

                    return config.getFuzzyString(pattern, locale,
                                                 config.getFuzzyString(range,
                                                                       locale,
                                                                       parameter));
                }

                return config.getFuzzyString(pattern, locale,
                                             config.getFuzzyString(range, locale));
            }
        }

        return config.getFuzzyString(pattern, locale,
                                     config.getFuzzyString(Range.ETERNAL, locale));
    }

    /**
     * 
     *
     * @param milliSeconds
     * @param strength
     * @param locale
     *
     * @return 
     */
    private String formatDuration(final long milliSeconds,
                                  final FuzzingStrength strength,
                                  final Locale locale) {
        for (final Range range : config.getDurationIntervals(strength)) {
            if (milliSeconds < range.getUpperBound()) {
                if (range.hasDivisor()) {
                    final int parameter = Math.round(milliSeconds / range.getParameterDivisor());

                    return config.getFuzzyString(range, locale, parameter);
                }

                return config.getFuzzyString(range, locale);
            }
        }

        return config.getFuzzyString(Range.ETERNAL, locale);
    }
}
