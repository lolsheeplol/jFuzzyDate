package net.sf.jfuzzydate;

/**
 * Enumeration of time measurement units.
 * 
 * @author amaasch
 */
public enum Unit {SECOND(1), MINUTE(60), HOUR(60 * MINUTE.numberOfSeconds), DAY(24 * HOUR.numberOfSeconds), 
    WEEK(7 * DAY.numberOfSeconds), MONTH(30 * DAY.numberOfSeconds), YEAR(31556952), CENTURY(100 * 31556952);
    /**
     * DOCUMENT ME!
     */
    private long numberOfSeconds;

/**
     * Creates a new Unit object.
     *
     * @param seconds DOCUMENT ME!
     */
    private Unit(final long seconds) {
        this.numberOfSeconds = seconds;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public long getSeconds() {
        return numberOfSeconds;
    }
}
