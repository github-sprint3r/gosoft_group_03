package business;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Locale;

public class DateTimeHelper {
	protected static String defaultPattern = "dd/MM/yyyy hh:mm a";
	protected static Locale defaultLocale = Locale.getDefault();
	private static Hashtable<String, DateFormat> _dateFormatCache = new Hashtable<String, DateFormat>();

	public DateTimeHelper() {
	}

	public static Timestamp getTimestamp(String dateStr) {
		Date dateCustom = DateTimeHelper.toDate(dateStr);
		return new LocalizedTimestamp(dateCustom.getTime(),
				getDefaultCalendar());
	}

	public static Date toDate(String dateStr) {
		return toDate(dateStr, defaultPattern, defaultLocale);
	}

	public static Calendar getDefaultCalendar() {
		return new GregorianCalendar(defaultLocale);
	}

	public static Date toDate(String dateStr, String pattern, Locale locale) {
		if (dateStr != null && !dateStr.trim().equals("")) {
			synchronized (DateTimeHelper.class) {
				try {
					return getFormatter(pattern, locale).parse(dateStr);
				} catch (Exception e) {
				}
			}
		}
		return null;
	}

	protected static DateFormat getFormatter(String pattern, Locale locale) {
		String key = pattern + "-" + locale.toString();

		DateFormat formatter = _dateFormatCache.get(key);

		if (formatter == null) {
			formatter = new SimpleDateFormat(pattern, locale);
			formatter.setLenient(false);
			_dateFormatCache.put(key, formatter);
		}

		return formatter;
	}

}
