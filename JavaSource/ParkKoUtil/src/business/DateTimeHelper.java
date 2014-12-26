package business;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class DateTimeHelper {
    protected static String defaultPattern = "dd/MM/yyyy hh:mm";
    protected static Locale defaultLocale = Locale.getDefault();
    private static Hashtable<String, DateFormat> _dateFormatCache = new Hashtable<String, DateFormat>();

	public DateTimeHelper() {
	}
	
	 /**
     * Returns the current timestamp
     * @return an instance of  <code>java.sql.Timestamp</code>.
     */
    public static Timestamp getTimestamp(String dateStr) {
    	Date dateCustom = DateTimeHelper.toDate(dateStr);
        return new LocalizedTimestamp( dateCustom.getTime(), getDefaultCalendar() );
    }

    /**
     * Converts a string into a <code>java.util.Date</code> with the default format.
     * @param dateStr the date/time string
     * @return a <code>java.util.Date</code> object, or <code>null</code> if can not parse date.
     * @see #getDefaultPattern()
     * @see #getDefaultLocale()
     */
    public static Date toDate(String dateStr) {
        return toDate( dateStr, defaultPattern, defaultLocale );
    }

    /**
     * Creates new instance of <tt>GregorianCalendar</tt> with default locale.
     * @return a <code>java.util.GregorianCalendar</code> object.
     * @see #getDefaultLocale()
     */
    public static Calendar getDefaultCalendar() {
        return new GregorianCalendar( defaultLocale );
    }
   
    /**
     * Converts a string into a <code>java.util.Date</code> following the specified format.
     * @param dateStr the date/time string
     * @param pattern the date/time pattern
     * @param locale
     * @return a <code>java.util.Date</code> object, or <code>null</code> if can not parse date.
     */
    public static Date toDate(String dateStr, String pattern, Locale locale) {
        if( dateStr != null && !dateStr.trim().equals( "" ) ) {
            synchronized( DateTimeHelper.class ) {
                try {
                    return getFormatter( pattern, locale ).parse( dateStr );
                } catch( Exception e ) {}
            }
        }
        return null;
    }
    
    /**
     * Returns a <code>DateFormat</code> object from the cache.
     * If no one, create new.
     * @param pattern the date/time pattern
     * @param locale
     * @return a <code>DateFormat</code> object.
     */
    protected static DateFormat getFormatter(String pattern, Locale locale) {
        String key = pattern + "-" + locale.toString();

        /* Get old from cache first */
        DateFormat formatter = _dateFormatCache.get( key );
        
        /* If not exist, create new one */
        if( formatter == null ) {
            formatter = new SimpleDateFormat( pattern, locale );
            formatter.setLenient( false );
            _dateFormatCache.put( key, formatter );
        }
        
        return formatter;
    }



}
