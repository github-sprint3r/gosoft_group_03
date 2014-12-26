package business;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
public class LocalizedTimestamp extends java.sql.Timestamp implements Serializable{

	private static final long serialVersionUID = 1L;

	public static LocalizedTimestamp toLocalizedTimestamp(Date date) {
	        return (date == null) ? null : new LocalizedTimestamp( date.getTime() );
	    }
	    public static LocalizedTimestamp toLocalizedTimestamp(Date date, Calendar calendar) {
	        return (date == null) ? null : new LocalizedTimestamp( date.getTime(), calendar );
	    }
	    

	    protected Calendar calendar;
	    
	    public LocalizedTimestamp() {
	        this( DateTimeHelper.getDefaultCalendar() );
	    }
	    public LocalizedTimestamp(long date) {
	        this( date, DateTimeHelper.getDefaultCalendar() );
	    }
	    public LocalizedTimestamp(long date, Calendar calendar) {
	        super( date );
	        this.calendar = calendar;
	    }
	    public LocalizedTimestamp(Calendar calendar) {
	        super( calendar.getTimeInMillis() );
	        this.calendar = calendar;
	    }
	    
	    
	    public Calendar getCalendar() {
	        return calendar;
	    }
	    public void setCalendar(Calendar calendar) {
	        this.calendar = calendar;
	    }

}
