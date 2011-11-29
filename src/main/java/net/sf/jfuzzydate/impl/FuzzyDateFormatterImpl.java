package net.sf.jfuzzydate.impl;

import net.sf.jfuzzydate.FuzzingConfiguration;
import net.sf.jfuzzydate.FuzzingStrength;
import net.sf.jfuzzydate.FuzzyDateFormatter;
import net.sf.jfuzzydate.FuzzyStringProvider;
import net.sf.jfuzzydate.Range;
import net.sf.jfuzzydate.i18n.Pluralizer;

import java.util.Date;
import java.util.Locale;


/**
 * Basic implementation for fuzzy date formatting.
 *
 * @author amaasch
 *
 * @see FuzzyDateFormatter
 */
public class FuzzyDateFormatterImpl implements FuzzyDateFormatter {
    //~ Instance fields --------------------------------------------------------------------------------------

    /**
     * The fuzzing configuration.
     */
    private final FuzzingConfiguration config;

    /**
     * The pluralizer used to build plurals of unit names.
     */
    private final Pluralizer pluralizer;

    //~ Constructors -----------------------------------------------------------------------------------------

/**
     * Creates a new FuzzyDateFormatterImpl object with the specified
     * configuration.
     *
     * @param config
     *            the given configuration.
     */
    public FuzzyDateFormatterImpl(final FuzzingConfiguration config) {
        this.config = config;
        pluralizer = new Pluralizer(this.config.getStringProvider());
    }

    //~ Methods ----------------------------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     *
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#format(java.util.Date)
     */
    public String format(final Date date) {
        return format(date, Locale.getDefault());
    }

    /*
     * (non-Javadoc)
     *
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#format(java.util.Date,
     * java.util.Locale)
     */
    public String format(final Date date, final Locale locale) {
        return formatDate(date.getTime() - new Date().getTime(), FuzzingStrength.NORMAL, locale);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#formatDistance(java.util.Date)
     */
    public String formatDistance(final Date date) {
        return formatDistance(date, Locale.getDefault());
    }

    /*
     * (non-Javadoc)
     *
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#formatDistance(java.util.Date,
     * java.util.Locale)
     */
    public String formatDistance(final Date date, final Locale locale) {
        return formatDistance(date.getTime() - System.currentTimeMillis(), FuzzingStrength.NORMAL, locale);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#formatDuration(java.util.Date)
     */
    public String formatDuration(final Date relative) {
        return formatDuration(relative, Locale.getDefault());
    }

    /*
     * (non-Javadoc)
     *
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#formatDuration(java.util.Date,
     * java.util.Date, java.util.Locale)
     */
    public String formatDuration(final Date from, final Date to, final Locale locale) {
        return formatDuration(to.getTime() - from.getTime(), locale);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#formatDuration(java.util.Date,
     * java.util.Locale)
     */
    public String formatDuration(final Date relative, final Locale locale) {
        return formatDuration(new Date().getTime() - relative.getTime(), locale);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#formatDuration(long)
     */
    public String formatDuration(final long milliSeconds) {
        return formatDuration(milliSeconds, Locale.getDefault());
    }

    /*
     * (non-Javadoc)
     *
     * @see net.sf.jfuzzydate.FuzzyDateFormatter#formatDuration(long,
     * java.util.Locale)
     */
    public String formatDuration(final long milliSeconds, final Locale locale) {
        return formatDuration(milliSeconds, FuzzingStrength.NORMAL, locale);
    }

    /**
     * Formats a point in time. Not yet implemented.
     *
     * @param distance todo
     * @param strength the strength of the fuzzyfication.
     * @param locale the locale for formatting.
     *
     * @return a string representing a point in time in relation to the current time.
     */
    private String formatDate(final long distance, final FuzzingStrength strength, final Locale locale) {
        return "not implemented";
    }

    /**
     * Formats a distance.
     *
     * @param distanceSec a relative distance (number of milliseconds). Negative distances are assumed to be
     *        past values.
     * @param strength the strength of the fuzzyfication.
     * @param locale the locale for formatting.
     *
     * @return a string representing a readable distance.
     *
     * @throws IllegalStateException thrown if no range was found. Fix this by configuring an instance of
     *         {@link Eternity} as last element in the list of ranges.
     */
    private String formatDistance(final long distanceSec, final FuzzingStrength strength, final Locale locale) {
        String tensePattern;

        if (distanceSec <= 0) {
            tensePattern = "distance.past.pattern";
        } else {
            tensePattern = "distance.future.pattern";
        }

        final long absDistance = Math.abs(distanceSec);

        for (final Range range : config.getDistanceRanges(strength)) {
            if (range.contains(absDistance)) {
                return formatDistanceRange(locale, tensePattern, absDistance, range);
            }
        }

        throw new IllegalStateException("No range found. Configuration should end up with an instance of Eternity.");
    }

    /**
     * DOCUMENT ME!
     *
     * @param locale
     * @param tensePattern
     * @param milliSeconds
     * @param range
     *
     * @return
     */
    private String formatDistanceRange(final Locale locale, final String tensePattern,
                                       final long milliSeconds, final Range range) {
        final FuzzyStringProvider fuzzyStrings = config.getStringProvider();

        if (range instanceof GenericRange) {
            final GenericRange genericRange = (GenericRange) range;
            final float readableDistance = mapToGenericRange(milliSeconds, genericRange);
            final int parameter = Math.round(readableDistance);

            final String pluralizedUnit = pluralizer.pluralize(parameter,
                                                               genericRange.getUnit().name().toLowerCase(),
                                                               locale);
            final String distanceString = fuzzyStrings.getString(range.getI18nKey(), locale,
                                                                 new Object[] {
                                                                     String.valueOf(parameter), pluralizedUnit
                                                                 });

            return fuzzyStrings.getString(tensePattern, locale, distanceString);
        }

        return fuzzyStrings.getString(tensePattern, locale, fuzzyStrings.getString(range.getI18nKey(), locale));
    }

    /**
     * Formats a duration.
     *
     * @param milliSeconds the duration defined by a number of milliseconds. Negative distances are assumed
     *        to be past values.
     * @param strength the strength of the fuzzyfication.
     * @param locale the locale for formatting.
     *
     * @return a string representing a readable duration.
     *
     * @throws IllegalStateException thrown if no range was found. Fix this by configuring an instance of
     *         {@link Eternity} as last element in the list of ranges.
     */
    private String formatDuration(final long milliSeconds, final FuzzingStrength strength, final Locale locale) {
        for (final Range range : config.getDurationRanges(strength)) {
            if (range.contains(milliSeconds)) {
                return formatDurationRange(milliSeconds, locale, range);
            }
        }

        throw new IllegalStateException("No range found. Configuration should end up with an instance of Eternity.");
    }

    /**
     * DOCUMENT ME!
     *
     * @param milliSeconds
     * @param locale
     * @param range
     *
     * @return
     */
    private String formatDurationRange(final long milliSeconds, final Locale locale, final Range range) {
        final FuzzyStringProvider fuzzyStrings = config.getStringProvider();

        if (range instanceof GenericRange) {
            final GenericRange genericRange = (GenericRange) range;
            final int parameter = mapToGenericRange(milliSeconds, genericRange);

            final String pluralizedUnit = pluralizer.pluralize(parameter,
                                                               genericRange.getUnit().name().toLowerCase(),
                                                               locale);

            return fuzzyStrings.getString(range.getI18nKey(), locale,
                                          new Object[] {String.valueOf(parameter), pluralizedUnit});
        }

        return fuzzyStrings.getString(range.getI18nKey(), locale);
    }

    /**
     * TODO DOCUMENT ME!
     *
     * @param milliSeconds TODO DOCUMENT ME!
     * @param genericRange TODO DOCUMENT ME!
     *
     * @return TODO DOCUMENT ME!
     */
    private int mapToGenericRange(final long milliSeconds, final GenericRange genericRange) {
        return Math.round(milliSeconds / (float) (genericRange.getUnit().getSeconds() * 1000));
    }
}
