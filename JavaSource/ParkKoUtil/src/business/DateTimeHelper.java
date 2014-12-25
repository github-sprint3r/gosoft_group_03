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

	public DateTimeHelper() {
	}
	

	public static final int minUSYear = 1800;
	public static final int maxUSYear = 2100;
    private static Hashtable<String, DateFormat> _dateFormatCache = new Hashtable<String, DateFormat>();
    
    public static boolean isUSYear(String year){
    	boolean us = false;
    	try {
			int inputYear = Integer.parseInt(year);
			if(inputYear>=minUSYear && inputYear <= maxUSYear){
				us = true;
			}
		} catch (NumberFormatException e) {
			us = false;
		}  	
    	return us;
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

    protected static String defaultPattern = "dd/MM/yyyy";
    protected static Locale defaultLocale = Locale.getDefault();
    
    /**
     * Sets the default locale for the DateTimeHelper class.
     * This does not affect the locale of the Java Virtual Machine.
     * 
     * @param newLocale the new default locale
     * 
     * @throws NullPointerException if <code>newLocale</code> is null
     */
    public static synchronized void setDefaultLocale(Locale newLocale) {
        if( newLocale == null )
            throw new NullPointerException( "Can't set default locale to NULL" );
        defaultLocale = newLocale;
    }
    /**
     * Gets the current value of the default locale for the DateTimeHelper class.
     * <p>
     * It can be changed using the {@link #setDefaultLocale(java.util.Locale) setDefaultLocale} method.
     * If it is not changed, default to the locale of the Java Virtual Machine.
     * <p>
     * Remember: the default locale of this class is NOT the default locale of <tt>java.util.Locale</tt>.
     * 
     * @return the default locale for the DateTimeHelper class.
     */
    public static Locale getDefaultLocale() {
        return defaultLocale;
    }
    
    /**
     * Gets the current value of the default date pattern for the DateTimeHelper class.
     * <p>
     * It can be changed using the {@link #setDefaultPattern(String) setDefaultPattern} method.
     * If it is not changed, default to "dd/MM/yyyy"
     * 
     * @return the default date pattern for the DateTimeHelper class.
     */
    public static String getDefaultPattern() {
        return defaultPattern;
    }
    /**
     * Sets the default date pattern for the DateTimeHelper class.
     * 
     * @param newPattern the new default pattern
     * 
     * @throws NullPointerException if <code>newPattern</code> is null
     */
    public static synchronized void setDefaultPattern(String newPattern) {
        if( newPattern == null )
            throw new NullPointerException( "Can't set default pattern to NULL" );
        defaultPattern = newPattern;
    }
    
    
    /**
     * Thai locale (language="th", country="TH")
     */
    public static final Locale THAI_LOCALE = new Locale( "th", "TH" );

    /**
     * Creates new instance of <tt>GregorianCalendar</tt> with default locale.
     * @return a <code>java.util.GregorianCalendar</code> object.
     * @see #getDefaultLocale()
     */
    public static Calendar getDefaultCalendar() {
        return new GregorianCalendar( defaultLocale );
    }
    
    /**
     * Returns the current date
     * @return a <code>java.util.Date</code> object.
     */
    public static Date currentDate() {
        return new Date( DateTimeUtils.currentTimeMillis() );
    }
    /**
     * Returns a string of the current date in the default format.
     * @return the formatted string.
     * @see #getDefaultLocale()
     */
    public static String currentStringDate() {
        return format( new Date( DateTimeUtils.currentTimeMillis() ), defaultPattern, defaultLocale );
    }
    /**
     * Returns a string of the current date in the specified format.
     * @param pattern the date/time pattern
     * @return the formatted string.
     */
    public static String currentStringDate(String pattern) {
        return format( new Date( System.currentTimeMillis() ), pattern, defaultLocale );
    }
    
    //because SimpleDateFormat is not Thread Safe and web app use Thread Pool
    //then it cannot use synchronized( DateTimeHelper.class )
    //because synchronized is not thread safe when request in concurrency transaction
    private ThreadLocal<DateFormat> dfddMMyyyy_HHmmss = new ThreadLocal<DateFormat> () {
    	@Override
    	protected DateFormat initialValue(){
    		return new SimpleDateFormat("ddMMyyyy_HHmmss",defaultLocale);
    	}
    };
    
    public String currentStringDateDDMMYYYY_HHmmss() {
    	Calendar cal =  new DateTime().toCalendar(defaultLocale);
    	return dfddMMyyyy_HHmmss.get().format(cal.getTime());
    	
    	
    }
    
    /**
     * Returns a string of the current date in the specified format with Joda lib for thread safe purpose.
     * @param pattern the date/time pattern
     * @return the formatted string.
     */
    public String currentStringJodaDate(String pattern){
    	 DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
         fmt = fmt.withLocale(defaultLocale);
         
         DateTime dt =  new DateTime();
    	return dt.toString(fmt);
    }
    /**
     * Returns a string of the current date in the specified format.
     * @param pattern the date/time pattern
     * @param locale
     * @return the formatted string.
     */
    public static String currentStringDate(String pattern, Locale locale) {
        return format( new Date( System.currentTimeMillis() ), pattern, locale );
    }
    
   
    /**
     * Returns the current timestamp
     * @return an instance of  <code>java.sql.Timestamp</code>.
     */
    public static Timestamp getTimestamp(Calendar time) {
        return new LocalizedTimestamp( time.getTimeInMillis(), getDefaultCalendar() );
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
     * Converts a string into a <code>java.util.Date</code> following the specified format.
     * @param dateStr the date/time string
     * @param pattern the date/time pattern
     * @return a <code>java.util.Date</code> object, or <code>null</code> if can not parse date.
     * @see #getDefaultLocale()
     */
    public static Date toDate(String dateStr, String pattern) {
        return toDate( dateStr, pattern, defaultLocale );
    }
    /**
     * Converts a string into a <code>java.util.Date</code> with the default format.
     * @param dateStr the date/time string
     * @param locale
     * @return a <code>java.util.Date</code> object, or <code>null</code> if can not parse date.
     * @see #getDefaultPattern()
     * @see #getDefaultLocale()
     */
    public static Date toDate(String dateStr, Locale locale) {
        return toDate( dateStr, defaultPattern, locale );
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
     * Converts a <code>java.util.Date</code> into a <code>java.sql.Date</code>
     * @param date
     * @return a <code>java.sql.Date</code> object.
     */
    public static java.sql.Date toSqlDate(Date date) {
        return (date == null) ? null : new java.sql.Date( date.getTime() );
    }
    /**
     * Converts a string into a <code>java.sql.Date</code> with the default format.
     * @param dateStr the date/time string
     * @return a <code>java.sql.Date</code> object, or <code>null</code> if can not parse date.
     * @see #getDefaultPattern()
     * @see #getDefaultLocale()
     */
    public static java.sql.Date toSqlDate(String dateStr) {
        return toSqlDate( toDate( dateStr, defaultPattern, defaultLocale ) );
    }
    /**
     * Converts a string into a <code>java.sql.Date</code> following the specified format.
     * @param dateStr the date/time string
     * @param pattern the date/time pattern
     * @return a <code>java.sql.Date</code> object, or <code>null</code> if can not parse date.
     * @see #getDefaultLocale()
     */
    public static java.sql.Date toSqlDate(String dateStr, String pattern) {
        return toSqlDate( toDate( dateStr, pattern, defaultLocale ) );
    }
    /**
     * Converts a string into a <code>java.sql.Date</code> following the specified format.
     * @param dateStr the date/time string
     * @param pattern the date/time pattern
     * @param locale
     * @return a <code>java.sql.Date</code> object, or <code>null</code> if can not parse date.
     */
    public static java.sql.Date toSqlDate(String dateStr, String pattern, Locale locale) {
        return toSqlDate( toDate( dateStr, pattern, locale ) );
    }

    /**
     * Formats a <code>java.util.Date</code> or a <code>java.sql.Date</code>
     * into a string in the pattern of the default format.
     * @param date the date to be formatted
     * @return the formatted string
     *         or <code>null</code> if the <code>date</code> is <code>null</code>.
     * @see #getDefaultPattern()
     * @see #getDefaultLocale()
     */
    public static String format(Date date) {
        return format( date, defaultPattern, defaultLocale );
    }
    /**
     * Formats a <code>java.util.Date</code> or a <code>java.sql.Date</code>
     * into a string in the specified format.
     * @param date the date to be formatted
     * @param pattern the date/time pattern
     * @return the formatted string
     *         or <code>null</code> if the <code>date</code> is <code>null</code>.
     * @see #getDefaultLocale()
     */
    public static String format(Date date, String pattern) {
        return format( date, pattern, defaultLocale );
    }
    /**
     * Formats a <code>java.util.Date</code> or a <code>java.sql.Date</code>
     * into a string in the specified format.
     * @param date the date to be formatted
     * @param pattern the date/time pattern
     * @param locale
     * @return the formatted string 
     *         or <code>null</code> if the <code>date</code> is <code>null</code>.
     */
    public static String format(Date date, String pattern, Locale locale) {
        if( date == null )
            return null;
       
        synchronized( DateTimeHelper.class ) {
        	//use joda time for thread safe
        	 DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
             fmt = fmt.withLocale(locale);
             
             DateTime dt = null;
             if(locale!=null && locale.equals(DateTimeHelper.THAI_LOCALE)){
            	 dt =  new DateTime(date.getTime(),BuddhistChronology.getInstance()); 
             }else{
            	dt =  new DateTime(date.getTime());
             }
             
            
        	return dt.toString(fmt);
        }
//        synchronized( DateTimeHelper.class ) {
//            return getFormatter( pattern, locale ).format( date );
//        }
    }

    /**
     * Adds or subtracts the specified amount of date
     * to the given <code>Date</code> object.
     * 
     * @param date the date to be added.
     * @param amount the amount of date to be added.
     * @return the new <code>Date<code> with the amount added 
     */
    public static Date addDays(Date date, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        cal.add( Calendar.DATE, amount );
        return cal.getTime();
    }
    /**
     * Adds or subtracts the specified amount of date
     * to the given <code>Calendar</code> object.
     * 
     * @param cal    the calendar to be added.
     * @param amount the amount of date to be added.
     * @return the given <code>Calendar<code> with the amount added 
     */
    public static Calendar addDays(Calendar cal, int amount) {
        cal.add( Calendar.DATE, amount );
        return cal;
    }

    /**
     * Adds or subtracts the specified amount of month
     * to the given <code>Date</code> object.
     *
     * @param date the date to be added.
     * @param amount the amount of month to be added.
     * @return the new <code>Date<code> with the amount added 
     */
    public static Date addMonths(Date date, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        cal.add( Calendar.MONTH, amount );
        return cal.getTime();
    }
    /**
     * Adds or subtracts the specified amount of month
     * to the given <code>Calendar</code> object.
     *
     * @param cal    the calendar to be added.
     * @param amount the amount of month to be added.
     * @return the given <code>Calendar<code> with the amount added 
     */
    public static Calendar addMonths(Calendar cal, int amount) {
        cal.add( Calendar.MONTH, amount );
        return cal;
    }

    /**
     * Adds or subtracts the specified amount of year
     * to the given <code>Date</code> object.
     *
     * @param date the date to be added.
     * @param amount the amount of year to be added.
     * @return the new <code>Date<code> with the amount added 
     */
    public static Date addYears(Date date, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        cal.add( Calendar.YEAR, amount );
        return cal.getTime();
    }
    
    public static String getDecreaseYearPeriod_YYYYMM(String period, int yearDecrease){
		String patternPeriod = "yyyyMM";
		Date inputPeriod = DateTimeHelper.toDate(period, patternPeriod);
		inputPeriod = DateTimeHelper.addYears(inputPeriod, -yearDecrease);
		
		return DateTimeHelper.format(inputPeriod, patternPeriod) ;
	}
    /**
     * Adds or subtracts the specified amount of year
     * to the given <code>Calendar</code> object.
     *
     * @param cal    the calendar to be added.
     * @param amount the amount of year to be added.
     * @return the given <code>Calendar<code> with the amount added 
     */
    public static Calendar addYears(Calendar cal, int amount) {
        cal.add( Calendar.YEAR, amount );
        return cal;
    }

    /**
     * Adds or subtracts the specified amounts of time
     * to the given <code>Date</code> object.
     *
     * @param date the date to be added.
     * @param hours the amount of hour to be added.
     * @param minutes the amount of minute to be added.
     * @param seconds the amount of second to be added.
     * @return the new <code>Date<code> with the amount added 
     */
    public static Date addTimes(Date date, int hours, int minutes, int seconds) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        cal.add( Calendar.SECOND, seconds );
        cal.add( Calendar.MINUTE, minutes );
        cal.add( Calendar.HOUR_OF_DAY, hours );
        return cal.getTime();
    }
    /**
     * Adds or subtracts the specified amounts of time
     * to the given <code>Calendar</code> object.
     *
     * @param cal     the calendar to be added.
     * @param hours   the amount of hour to be added.
     * @param minutes the amount of minute to be added.
     * @param seconds the amount of second to be added.
     * @return the new <code>Date<code> with the amount added 
     */
    public static Calendar addTimes(Calendar cal, int hours, int minutes, int seconds) {
        cal.add( Calendar.SECOND, seconds );
        cal.add( Calendar.MINUTE, minutes );
        cal.add( Calendar.HOUR_OF_DAY, hours );
        return cal;
    }

    /**
     * Gets the first day of month from the given <code>Date</code> object.
     *
     * @param date
     * @return the Date object as the first day of month
     */
    public static Date toFirstDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        cal.set( Calendar.DAY_OF_MONTH, 1 );
        return cal.getTime();
    }
    /**
     * Changes the given <code>Calendar</code> to the first day of month.
     *
     * @param cal
     * @return the given Calendar object as the first day of month
     */
    public static Calendar toFirstDay(Calendar cal) {
        cal.set( Calendar.DAY_OF_MONTH, 1 );
        return cal;
    }

    /**
     * Gets the last day of month from the given <code>Date</code> object.
     * @param date
     * @return the Date object as the last day of month
     */
    public static Date toLastDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        int lastDay = cal.getActualMaximum( Calendar.DAY_OF_MONTH );
        cal.set( Calendar.DAY_OF_MONTH, lastDay );
        return cal.getTime();
    }
    
    /**
     * Gets the last day of year from the current time.
     * @param date
     * @return the Date object as the last day of year
     */
    public static Date toLastDayOfYear() {
        Calendar cal = Calendar.getInstance();
        int lastDay = cal.getActualMaximum( Calendar.DAY_OF_YEAR);
        int lastMonth = cal.getActualMaximum(Calendar.MONTH);
        cal.set( Calendar.DAY_OF_YEAR, lastDay );
        cal.set(Calendar.MONTH, lastMonth);
        return cal.getTime();
    }
    /**
     * Gets the last day of year from the given <code>Date</code> object.
     * @param date
     * @return the Date object as the last day of year
     */
    public static Date toLastDayOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        int lastDay = cal.getActualMaximum( Calendar.DAY_OF_YEAR);
        int lastMonth = cal.getActualMaximum(Calendar.MONTH);
        cal.set( Calendar.DAY_OF_YEAR, lastDay );
        cal.set(Calendar.MONTH, lastMonth);
        return cal.getTime();
    }
    /**
     * Changes the given <code>Calendar</code> to the last day of month.
     * @param cal
     * @return the given Calendar object as the last day of month
     */
    public static Calendar toLastDay(Calendar cal) {
        int lastDay = cal.getActualMaximum( Calendar.DAY_OF_MONTH );
        cal.set( Calendar.DAY_OF_MONTH, lastDay );
        return cal;
    }

    /**
     * Returns a number representing the year.
     *
     * @param date
     * @param locale
     * @return the year represented by this date.
     * @see    java.util.Calendar
     */
    public static int getYear(Date date, Locale locale) {
        Calendar cal = Calendar.getInstance( locale );
        cal.setTime( date );
        return cal.get( Calendar.YEAR );
    }
    
    /**
     * Returns a number representing the year.
     *
     * @param date
     * @return the year represented by this date.
     * @see    java.util.Calendar
     * @see #getDefaultLocale()
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance( defaultLocale );
        cal.setTime( date );
        return cal.get( Calendar.YEAR );
    }
    public static int getYear(Calendar cal) {
        return cal.get( Calendar.YEAR );
    }

    /**
     * Returns a number representing the month.
     * The value returned is between <code>1</code> and <code>12</code>,
     *
     * @return the month represented by this date.
     * @see    java.util.Calendar
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        return cal.get( Calendar.MONTH ) + 1;
    }
    /**
     * Returns a number representing the month.
     * The value returned is between <code>1</code> and <code>12</code>,
     *
     * @return the month represented by this calendar.
     * @see    java.util.Calendar
     */
    public static int getMonth(Calendar cal) {
        return cal.get( Calendar.MONTH ) + 1;
    }

    /**
     * Returns the last day of the month.
     *
     * @return the last day of the month represented by this date.
     * @see    java.util.Calendar
     */
    public static int getLastDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        return cal.getActualMaximum( Calendar.DAY_OF_MONTH );
    }
    /**
     * Returns the last day of the month.
     *
     * @return the last day of the month represented by this date.
     * @see    java.util.Calendar
     */
    public static int getLastDate(Calendar cal) {
        return cal.getActualMaximum( Calendar.DAY_OF_MONTH );
    }

    /**
     * Returns a number representing the day of the month.
     * The value returned is between <code>1</code> and <code>31</code>.
     *
     * @return the day of the month represented by this date.
     * @see    java.util.Calendar
     */
    public static int getDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        return cal.get( Calendar.DAY_OF_MONTH );
    }
    /**
     * Returns a number representing the day of the month.
     * The value returned is between <code>1</code> and <code>31</code>.
     *
     * @return the day of the month represented by this date.
     * @see    java.util.Calendar
     */
    public static int getDate(Calendar cal) {
        return cal.get( Calendar.DAY_OF_MONTH );
    }

    /**
     * Returns a number representing the hour of the day.
     * The value returned is between <code>0</code> and <code>23</code>,
     *
     * @return the hour of the day represented by this date.
     * @see    java.util.Calendar
     */
    public static int getHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        return cal.get( Calendar.HOUR_OF_DAY );
    }

    /**
     * Returns a number representing the minute.
     * The value returned is between <code>0</code> and <code>59</code>,
     *
     * @return the minute represented by this date.
     * @see    java.util.Calendar
     */
    public static int getMinute(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        return cal.get( Calendar.MINUTE );
    }

    /**
     * Returns a number representing the second.
     * The value returned is between <code>0</code> and <code>59</code>,
     *
     * @return the second represented by this date.
     * @see    java.util.Calendar
     */
    public static int getSecond(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        return cal.get( Calendar.SECOND );
    }

    /**
     * Converts a <tt>java.util.Date</tt> into a <tt>java.util.Calendar</tt> with the default locale.
     * @param date   the date/time string
     * @return a <tt>java.util.Calendar</tt> object.
     * @see #getDefaultLocale()
     */
    public static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance( defaultLocale );
        cal.setTime( date );
        return cal;
    }
    /**
     * Converts a <tt>java.util.Date</tt> into a <tt>java.util.Calendar</tt>.
     * @param date   the date/time string
     * @param locale the locale of a calendar
     * @return a <tt>java.util.Calendar</tt> object.
     */
    public static Calendar toCalendar(Date date, Locale locale) {
        Calendar cal = Calendar.getInstance( locale );
        cal.setTime( date );
        return cal;
    }
    
    
    /**
     * Converts a string of date from one pattern to another pattern.
     * 
     * @param dateStr    the date/time string
     * @param curPattern the current date/time pattern
     * @param newPattern the new date/time pattern which be returned
     * @return the formatted string in a new pattern
     *         or <code>null</code> if can not parse the <tt>dateStr</tt> with the <tt>curPattern</tt>.
     * @see #getDefaultLocale()        
     */
    public static String reformat(String dateStr, String curPattern, String newPattern) {
        Date date = toDate( dateStr, curPattern, defaultLocale );
        return format( date, newPattern, defaultLocale );
    }

    /**
     * Converts a string of date from one pattern to another pattern.
     * 
     * @param dateStr    the date/time string
     * @param locale
     * @param curPattern the current date/time pattern
     * @param newPattern the new date/time pattern which be returned
     * @return the formatted string in a new pattern
     *         or <code>null</code> if can not parse the <tt>dateStr</tt> with the <tt>curPattern</tt>.
     */
    public static String reformat(String dateStr, Locale locale, String curPattern, String newPattern) {
        Date date = toDate( dateStr, curPattern, locale );
        return format( date, newPattern, locale );
    }

    /**
     * Converts a string of date from one pattern/locale to another pattern/locale.
     * 
     * @param dateStr    the date/time string
     * @param curPattern the current date/time pattern
     * @param curLocale  the current locale
     * @param newPattern the new date/time pattern which be returned
     * @param newLocale  the new locale
     * @return the formatted string in a new pattern
     *         or <code>null</code> if can not parse the <tt>dateStr</tt> with the <tt>curPattern</tt>.
     */
    public static String reformat(String dateStr, String curPattern, Locale curLocale, String newPattern, Locale newLocale) {
        Date date = toDate( dateStr, curPattern, curLocale );
        return format( date, newPattern, newLocale );
    }

    /**
     * Converts a string of date from one locale to another locale.
     * 
     * @param dateStr   the date/time string
     * @param pattern   the date/time pattern
     * @param curLocale the current locale
     * @param newLocale the new locale which be returned
     * @return the formatted string in a new pattern
     *         or <code>null</code> if can not parse the <tt>dateStr</tt> with the <tt>pattern</tt>.
     */
    public static String reformat(String dateStr, String pattern, Locale curLocale, Locale newLocale) {
        Date date = toDate( dateStr, pattern, curLocale );
        return format( date, pattern, newLocale );
    }
    
    /**
     * Calculates number of months between two dates.
     * <p>
     * Example:<br/><code>
     * 01/10/2013 - 01/12/2012 = 10 months. <i>// ignoreDate = false</i><br/>
     * 01/10/2013 - 31/12/2012 = &nbsp;9 months. <i>// ignoreDate = false</i><br/>
     * 01/10/2013 - 31/12/2012 = 10 months. <i>// ignoreDate = true</i><br/>
     * 05/02/2013 - 05/05/2013 = -3 months. <i>// no matter what ignoreDate is</i>
     * </code></p>
     * <p>
     * reference:<br/>
     * http://techmajik.com/2010/01/28/how-to-calculate-number-of-months-between-two-dates-in-java/</p>
     * 
     * @param first      
     * @param second     
     * @param ignoreDate if false and first's date less than second's date
     *                   , the result will be subtracted 1
     * 
     */
    public static int subtractMonths(Calendar first, Calendar second, boolean ignoreDate) {
        return (first.get( Calendar.YEAR ) - second.get( Calendar.YEAR )) * 12 +
        (first.get( Calendar.MONTH ) - second.get( Calendar.MONTH )) +
        ((ignoreDate || first.get( Calendar.DATE ) >= second.get( Calendar.DATE )) ? 0 : -1);
    }
    /**
     * @see #subtractMonths(Calendar, Calendar, boolean)
     */
    public static int subtractMonths(Date first, Date second, boolean ignoreDate) {
        return subtractMonths( toCalendar( first ), toCalendar( second ), ignoreDate );
    }
    
    
    /*---------------------------------------------------------------------*/
    
   

}
