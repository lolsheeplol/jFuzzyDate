package net.sf.jfuzzydate;

import java.util.Date;
import java.util.Locale;

/**
 * Formatter for human readable dates, distances of time and durations.
 * 
 * <p>
 * Use the {@link #format(Date)} methods to create relative strings like
 * "today", "last friday". These dates are used to tell the a user when an event
 * has happened or will happen. The string will be built relative to the current
 * time/date.
 * 
 * <p>
 * Use the {@link #formatDistance(Date)} methods to create strings for distances
 * of time such as "in 5 days", "a month ago". This format is used to tell the
 * user how much time has passed since an event or how much time is left before
 * something happens. These strings will also be built relative to the current
 * date/time.
 * 
 * <p>
 * Use the {@link #formatDuration(long)} methods to create strings representing
 * the time between two events, like "5 minutes", "two centuries". These strings
 * are used for durations of processes. Calling this method with a single date
 * will calculate the duration from this date to the current time.
 * 
 * <p>
 * Each available method may be parameterized with a {@link Locale} object to
 * select a specific formatting locale. If this locale parameter is missing the
 * formatting process will use the system default locale.
 * 
 * @author amaasch
 */
public interface FuzzyDateFormatter {

	/**
	 * Creates a string representing a point in time in reference to the current
	 * time/date. Use this method to tell the a user when an event has happened
	 * or will happen. This method uses the system default locale to format the
	 * string.
	 * 
	 * @param date
	 *            the date to be formatted as fuzzy string.
	 * 
	 * @return a fuzzy string representing a point in time.
	 */
	String format(Date date);

	/**
	 * Creates a string representing a point in time in reference to the current
	 * time/date. Use this method to tell the a user when an event has happened
	 * or will happen. Uses the locale parameter to format an internationalized
	 * string.
	 * 
	 * @param date
	 *            the date to be formatted as fuzzy string.
	 * @param locale
	 *            the given locale for internationalized formatting.
	 * 
	 * @return a fuzzy string representing a point in time.
	 */
	String format(Date date, Locale locale);

	/**
	 * Creates a string representing a distance to a given date. Use this method
	 * to tell the user how much time has passed since an event or how much time
	 * is left before something happens. This method uses the system default
	 * locale to format the string.
	 * 
	 * @param date
	 *            the relative date to which the relative distance will be
	 *            formatted as fuzzy string.
	 * 
	 * @return a fuzzy string representing the distance from the current time.
	 */
	String formatDistance(Date date);

	/**
	 * Creates a string representing a distance to a given date. Use this method
	 * to tell the user how much time has passed since an event or how much time
	 * is left before something happens. Uses the locale parameter to format an
	 * internationalized string.
	 * 
	 * @param date
	 *            the relative date to which the relative distance will be
	 *            formatted as fuzzy string.
	 * @param locale
	 *            the given locale for internationalized formatting.
	 * 
	 * @return a fuzzy string representing the distance from the current time.
	 */
	String formatDistance(Date date, Locale locale);

	/**
	 * Creates a string representing a duration. Use this method to tell the
	 * user how much time has passes between two events. Uses the locale
	 * parameter to format an internationalized string.
	 * 
	 * @param milliSeconds
	 *            a duration specified by a number of milliseconds.
	 * @param locale
	 *            the given locale for internationalized formatting.
	 * 
	 * @return a fuzzy string representing the duration between two events.
	 */
	String formatDuration(long milliSeconds, Locale locale);

	/**
	 * Creates a string representing a duration. Use this method to tell the
	 * user how much time has passes between two events. This method uses the
	 * system default locale to format the string.
	 * 
	 * @param milliSeconds
	 *            a duration specified by a number of milliseconds.
	 * 
	 * @return a fuzzy string representing the duration between two events.
	 */
	String formatDuration(long milliSeconds);

	/**
	 * Creates a string representing a duration. Use this method to tell the
	 * user how much time has passes between two events. Uses the locale
	 * parameter to format an internationalized string.
	 * 
	 * @param relative
	 *            the given related date/time.
	 * @param locale
	 *            the given locale for internationalized formatting.
	 * 
	 * @return a fuzzy string representing the duration between the given and
	 *         the current date/time.
	 */
	String formatDuration(Date relative, Locale locale);

	/**
	 * Creates a string representing a duration. Use this method to tell the
	 * user how much time has passes between two events. This method uses the
	 * system default locale to format the string.
	 * 
	 * @param relative
	 *            the given related date/time.
	 * 
	 * @return a fuzzy string representing the duration between the given and
	 *         the current date/time.
	 */
	String formatDuration(Date relative);

	/**
	 * Creates a string representing a duration. Use this method to tell the
	 * user how much time has passes between two events specified by given start
	 * and end dates. Uses the locale parameter to format an internationalized
	 * string.
	 * 
	 * @param from
	 *            the given start date/time.
	 * @param to
	 *            the given end date/time.
	 * @param locale
	 *            the given locale for internationalized formatting.
	 * 
	 * @return a fuzzy string representing the duration between the given start
	 *         and end date/time.
	 */
	String formatDuration(Date from, Date to, Locale locale);
}
