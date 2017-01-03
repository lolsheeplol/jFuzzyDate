package net.sf.jfuzzydate.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Date;
import java.util.Locale;

/**
 * Test class for {@link FuzzyDateFormatterImpl}. Mostly black box testing.
 * 
 * @author ma³
 */
public class FuzzyDateFormatImplTest {

	/**
     * 
     */
	private static final int SECONDS_HOUR = 60 * 60;

	/**
     * 
     */
	private static final int SECONDS_DAY = SECONDS_HOUR * 24;

	/**
     * 
     */
	private static final int SECONDS_WEEK = SECONDS_DAY * 7;

	/**
     * 
     */
	private static final int SECONDS_MONTH = SECONDS_DAY * 30;

	/**
     * 
     */
	private static final int SECONDS_YEAR = SECONDS_DAY * 256;

	/**
	 * Test method for
	 * {@link net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#formatDistance(java.util.Date)}
	 * .
	 */
	@Test
	public void testFormatDistanceDate() {
		FuzzyDateFormatterImpl impl = new FuzzyDateFormatterImpl(
				DefaultFuzzingConfiguration.getInstance());
		Date aMinuteAgo = new Date(new Date().getTime() - (30 * 1000));
		Date in35Minutes = new Date(new Date().getTime() + (60 * 35 * 1000));

		// executing formatDistance(Date) should use system default locale
		// so we simply compare
		assertEquals(impl.formatDistance(aMinuteAgo), impl.formatDistance(
				aMinuteAgo, Locale.getDefault()));
		assertEquals(impl.formatDistance(in35Minutes), impl.formatDistance(
				in35Minutes, Locale.getDefault()));
	}

	/**
	 * Test method for
	 * {@link net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#formatDistance(java.util.Date, java.util.Locale)}
	 * .
	 */
	@Test
	public void testFormatDistanceDateLocale() {
		FuzzyDateFormatterImpl impl = new FuzzyDateFormatterImpl(
				DefaultFuzzingConfiguration.getInstance());

		assertEquals("a minute ago", impl.formatDistance(new Date(new Date()
				.getTime()
				- (30 * 1000)), Locale.ENGLISH));
		assertEquals("in a minute", impl.formatDistance(new Date(new Date()
				.getTime()
				+ (30 * 1000)), Locale.ENGLISH));
		assertEquals("two minutes ago", impl.formatDistance(new Date(new Date()
				.getTime()
				- (60 * 2 * 1000)), Locale.ENGLISH));
		assertEquals("in two minutes", impl.formatDistance(new Date(new Date()
				.getTime()
				+ (60 * 2 * 1000)), Locale.ENGLISH));
		assertEquals("in 35 minutes", impl.formatDistance(new Date(new Date()
				.getTime()
				+ (60 * 35 * 1000)), Locale.ENGLISH));
		assertEquals("in 3 hours", impl.formatDistance(new Date(new Date()
				.getTime()
				+ (((3 * SECONDS_HOUR) + (60 * 20)) * 1000)), Locale.ENGLISH));
		assertEquals("a day ago", impl.formatDistance(new Date(new Date()
				.getTime()
				- (SECONDS_DAY * 1000)), Locale.ENGLISH));
		assertEquals("in 5 days", impl.formatDistance(new Date(new Date()
				.getTime()
				+ (SECONDS_DAY * 5 * 1000)), Locale.ENGLISH));
		assertEquals("a week ago", impl.formatDistance(new Date(new Date()
				.getTime()
				- (SECONDS_DAY * 7 * 1000)), Locale.ENGLISH));
		assertEquals("vor einer Woche", impl.formatDistance(new Date(new Date()
				.getTime()
				- (SECONDS_DAY * 7 * 1000)), Locale.GERMAN));
		assertEquals("vor zwei Wochen", impl.formatDistance(new Date(new Date()
				.getTime()
				- (SECONDS_DAY * 14 * 1000)), Locale.GERMAN));
	}

	/**
	 * Test method for
	 * {@link net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#formatDuration(java.util.Date, java.util.Date, java.util.Locale)}
	 * .
	 */
	@Test
	public void testFormatDurationDateDateLocale() {
	}

	/**
	 * Test method for
	 * {@link net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#formatDuration(java.util.Date, java.util.Locale)}
	 * .
	 */
	@Test
	public void testFormatDurationDateLocale() {
	}

	/**
	 * Test method for
	 * {@link net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#formatDuration(long, java.util.Locale)}
	 * .
	 */
	@Test
	public void testFormatDurationLongLocale() {
		FuzzyDateFormatterImpl impl = new FuzzyDateFormatterImpl(
				DefaultFuzzingConfiguration.getInstance());
		assertEquals("a minute", impl.formatDuration(30 * 1000, Locale.ENGLISH));
		assertEquals("two minutes", impl.formatDuration(60 * 2 * 1000,
				Locale.ENGLISH));
		assertEquals("35 minutes", impl.formatDuration(60 * 35 * 1000,
				Locale.ENGLISH));
		assertEquals("a day", impl.formatDuration(SECONDS_DAY * 1000,
				Locale.ENGLISH));
		assertEquals("5 days", impl.formatDuration(SECONDS_DAY * 5 * 1000,
				Locale.ENGLISH));
		assertEquals("a week", impl.formatDuration(SECONDS_DAY * 7 * 1000,
				Locale.ENGLISH));
	}

	/**
	 * Test method for
	 * {@link net.sf.jfuzzydate.impl.FuzzyDateFormatterImpl#FuzzyDateFormatImpl(net.sf.jfuzzydate.impl.DefaultFuzzingConfiguration)}
	 * .
	 */
	@Test
	public void testFuzzyDateFormatImpl() {
	}
}
