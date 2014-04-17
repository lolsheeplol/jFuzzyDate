package net.sf.jfuzzydate;

/**
 * Enumeration of time measurement units.
 *
 * @author amaasch
 */
public enum Unit {

    //~ Enum constants ---------------------------------------------------------------------------------------

    SECOND(1), MINUTE(60), HOUR(60 * MINUTE.numberOfSeconds), DAY(24 * HOUR.numberOfSeconds),
    WEEK(7 * DAY.numberOfSeconds), MONTH(30 * DAY.numberOfSeconds), YEAR(31556927),
    CENTURY(100 * YEAR.numberOfSeconds);

    //~ Instance fields --------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     */
    private long numberOfSeconds;

    //~ Constructors -----------------------------------------------------------------------------------------

    /**
     * Creates a new Unit object.
     *
     * @param seconds DOCUMENT ME!
     */
    private Unit(final long seconds) {
        this.numberOfSeconds = seconds;
    }

    //~ Methods ----------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public long getSeconds() {
        return numberOfSeconds;
    }
}
