package business;
import java.sql.Timestamp;
import java.util.HashMap;

import bean.TimeSpecial;

public class CalculateParkKo {
	public static HashMap<Timestamp,TimeSpecial> dateTimeStampMap = new HashMap<Timestamp,TimeSpecial>();
	
	static{
		String timeExtraPriceStart1 = "25/12/2014 03:00 AM";
		String timeExtraPriceEnd1 = "25/12/2014 06:00 AM";
		
		String timeExtraPriceStart2 = "26/12/2014 03:00 AM";
		String timeExtraPriceEnd2 = "26/12/2014 06:00 AM";
		
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
	}

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

	public int calculateSpecialHour(Timestamp startTime, Timestamp endTime) {
		int totalTime = 0;
		for(Timestamp time : dateTimeStampMap.keySet()){
			TimeSpecial special = dateTimeStampMap.get(time);
			if(startTime.before(special.getStartTime())&&endTime.after(special.getEndTime())){
				totalTime = totalTime + 3;
			}
		}
		
		return totalTime;
	}
	
}
