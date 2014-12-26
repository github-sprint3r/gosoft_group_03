package business;
import java.sql.Timestamp;
import java.util.HashMap;

import bean.TimeSpecial;

public class CalculateParkKo {
	public static HashMap<Timestamp,TimeSpecial> dateTimeStampMap = new HashMap<Timestamp,TimeSpecial>();
	/*
	static{
		String timeExtraPriceStart1 = "25/12/2014 03:00";
		String timeExtraPriceEnd1 = "25/12/2014 06:00";
		
		String timeExtraPriceStart2 = "26/12/2014 03:00";
		String timeExtraPriceEnd2 = "26/12/2014 06:00";
		
		TimeSpecial special = new TimeSpecial();
		special.setStrStartTime(timeExtraPriceStart1);
		special.setStrEndtTime(timeExtraPriceEnd1);
		
		Timestamp tmp = DateTimeHelper.getTimestamp(timeExtraPriceStart1);
		special.setStartTime(tmp);
		tmp = DateTimeHelper.getTimestamp(timeExtraPriceEnd1);
		special.setEndTime(tmp);		
		
		dateTimeStampMap.put(tmp, special);
		
		special = new TimeSpecial();
		special.setStrStartTime(timeExtraPriceStart2);
		special.setStrEndtTime(timeExtraPriceEnd2);
		
		tmp = DateTimeHelper.getTimestamp(timeExtraPriceStart2);
		special.setStartTime(tmp);
		tmp = DateTimeHelper.getTimestamp(timeExtraPriceEnd2);
		special.setEndTime(tmp);		
		
		dateTimeStampMap.put(tmp, special);
	}*/

	public CalculateParkKo() {
	}

	public int calculateRoundUpParkHour(Timestamp startTime, Timestamp endTime) {
		double totalTime = endTime.getTime() -startTime.getTime();
		//sec
		totalTime = Math.ceil(totalTime/1000);
		//min
		totalTime = Math.ceil(totalTime/60);
		//hour
		totalTime = Math.ceil(totalTime/60);
		
		return (int) totalTime;
	}

	
}
