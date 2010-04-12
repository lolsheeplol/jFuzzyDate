
package net.sf.jfuzzydate;

import java.util.Date;
import java.util.Locale;

public interface FuzzyDateFormatter {

	String format(Date date);
	String format(Date date, Locale locale);
	String formatDistance(Date date);
	String formatDistance(Date date, Locale locale);
	String formatDuration(long milliSeconds, Locale locale);
	String formatDuration(Date relative, Locale locale);
	String formatDuration(Date from,Date to, Locale locale);
}
