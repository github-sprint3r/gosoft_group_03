package bean;

import java.sql.Timestamp;

public class TimeSpecial {
	
	private String strStartTime;
	private Timestamp startTime;
	private String strEndtTime;
	private Timestamp EndTime;
	public TimeSpecial() {
		
	}
	public String getStrStartTime() {
		return strStartTime;
	}
	public void setStrStartTime(String strStartTime) {
		this.strStartTime = strStartTime;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public String getStrEndtTime() {
		return strEndtTime;
	}
	public void setStrEndtTime(String strEndtTime) {
		this.strEndtTime = strEndtTime;
	}
	public Timestamp getEndTime() {
		return EndTime;
	}
	public void setEndTime(Timestamp endTime) {
		EndTime = endTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EndTime == null) ? 0 : EndTime.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result
				+ ((strEndtTime == null) ? 0 : strEndtTime.hashCode());
		result = prime * result
				+ ((strStartTime == null) ? 0 : strStartTime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeSpecial other = (TimeSpecial) obj;
		if (EndTime == null) {
			if (other.EndTime != null)
				return false;
		} else if (!EndTime.equals(other.EndTime))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (strEndtTime == null) {
			if (other.strEndtTime != null)
				return false;
		} else if (!strEndtTime.equals(other.strEndtTime))
			return false;
		if (strStartTime == null) {
			if (other.strStartTime != null)
				return false;
		} else if (!strStartTime.equals(other.strStartTime))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TimeSpecial [strStartTime=" + strStartTime + ", startTime="
				+ startTime + ", strEndtTime=" + strEndtTime + ", EndTime="
				+ EndTime + "]";
	}

	
}
