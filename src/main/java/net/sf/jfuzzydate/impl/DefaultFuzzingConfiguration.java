package net.sf.jfuzzydate.impl;

import net.sf.jfuzzydate.FuzzingConfiguration;
import net.sf.jfuzzydate.FuzzingStrength;
import net.sf.jfuzzydate.Range;
import net.sf.jfuzzydate.Unit;
import net.sf.jfuzzydate.i18n.FuzzyStrings;


/**
 * A very simple and static configuration for fuzzy date formatting.
 *
 * @author amaasch
 */
public final class DefaultFuzzingConfiguration implements FuzzingConfiguration {
    //~ Static fields/initializers ---------------------------------------------

    /**
     * The singleton instance.
     */
    private static final DefaultFuzzingConfiguration INSTANCE = new DefaultFuzzingConfiguration();

    /**
     * The internationalization resource bundle name for looking up the
     * strings of this configuration.
     *
     * @see #getFuzzyString(Range, Locale, Object...)
     * @see #getFuzzyString(String, Locale, Object...)
     */
    private static final String FUZZY_STRING_BUNDLE = "net.sf.jfuzzydate.i18n.jFuzzyDate";

    //~ Instance fields --------------------------------------------------------

    /**
     * Normal distance configuration.
     */
    private final Range[] dist_normal;

    /**
     * Normal duration configuration.
     */
    private final Range[] dur_normal;

    /**
     * The provider of the fuzzy strings.
     */
    private final FuzzyStrings fuzzyStrings = new FuzzyStrings(FUZZY_STRING_BUNDLE);

    //~ Constructors -----------------------------------------------------------

/**
     * Creates a new DefaultFuzzingConfiguration object.
     */
    private DefaultFuzzingConfiguration() {
        final int min = 60;
        final int hour = 60 * min;
        final int day = 24 * hour;
        final int week = 7 * day;

        dur_normal = new Range[] {
                         new StaticRange(80, "duration.minute.1"),
                         new StaticRange(140, "duration.minute.2"),
                         new GenericRange(40 * min, "duration.numbered", Unit.MINUTE),
                         new StaticRange(90 * min, "duration.hour.1"),
                         new StaticRange(150 * min, "duration.hour.2"),
                         new GenericRange(day, "duration.numbered", Unit.HOUR),
                         new StaticRange(36 * hour, "duration.day.1"),
                         new StaticRange(60 * hour, "duration.day.2"),
                         new GenericRange(week, "duration.numbered", Unit.DAY),
                         new StaticRange(11 * day, "duration.week.1"),
                         new StaticRange(18 * day, "duration.week.2"),
                         new GenericRange(4 * week, "duration.numbered", Unit.WEEK),
                         new StaticRange(45 * day, "duration.month.1"),
                         new StaticRange(75 * day, "duration.month.2"),
                         new GenericRange(300 * day, "duration.numbered",
                                          Unit.MONTH),
                         new Eternity("duration.eternal")
                     };

        dist_normal = new Range[] {
                          new StaticRange(80, "distance.minute.1"),
                          new StaticRange(140, "distance.minute.2"),
                          new GenericRange(40 * min, "distance.numbered", Unit.MINUTE),
                          new StaticRange(90 * min, "distance.hour.1"),
                          new StaticRange(150 * min, "distance.hour.2"),
                          new GenericRange(day, "distance.numbered", Unit.HOUR),
                          new StaticRange(36 * hour, "distance.day.1"),
                          new StaticRange(60 * hour, "distance.day.2"),
                          new GenericRange(week, "distance.numbered", Unit.DAY),
                          new StaticRange(11 * day, "distance.week.1"),
                          new StaticRange(18 * day, "distance.week.2"),
                          new GenericRange(4 * week, "distance.numbered", Unit.WEEK),
                          new StaticRange(45 * day, "distance.month.1"),
                          new StaticRange(75 * day, "distance.month.2"),
                          new GenericRange(300 * day, "distance.numbered",
                                           Unit.MONTH),
                          new Eternity("distance.eternal")
                      };
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * This static method returns a shared instance of this default
     * configuration class.
     *
     * @return a DefaultFuzzingConfiguration instance.
     */
    public static DefaultFuzzingConfiguration getInstance() {
    	return INSTANCE;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * net.sf.jfuzzydate.FuzzingConfiguration#getDistanceRanges(net.sf.jfuzzydate
     * .FuzzingStrength)
     */
    public Range[] getDistanceRanges(final FuzzingStrength strenght) {
        final Range[] ranges;

        switch (strenght) {
            case NORMAL :
                ranges = dist_normal;

                break;

            case STRONG :
                // TODO
                ranges = dist_normal;

                break;

            case EXTREME :
                // TODO
                ranges = dist_normal;

                break;

            default :
                ranges = dist_normal;
        }

        return ranges;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * net.sf.jfuzzydate.FuzzingConfiguration#getDurationRanges(net.sf.jfuzzydate
     * .FuzzingStrength)
     */
    public Range[] getDurationRanges(final FuzzingStrength strenght) {
        final Range[] ranges;

        switch (strenght) {
            case NORMAL :
                ranges = dur_normal;

                break;

            case STRONG :
                // TODO
                ranges = dur_normal;

                break;

            case EXTREME :
                // TODO
                ranges = dur_normal;

                break;

            default :
                ranges = dur_normal;
        }

        return ranges;
    }

    /* (non-Javadoc)
     * @see net.sf.jfuzzydate.FuzzingConfiguration#getStringBuilder()
     */
    public FuzzyStrings getStringBuilder() {
        return this.fuzzyStrings;
    }
}
