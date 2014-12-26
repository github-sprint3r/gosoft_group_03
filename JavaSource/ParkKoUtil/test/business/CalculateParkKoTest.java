package business;

import java.sql.Timestamp;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculateParkKoTest {
	CalculateParkKo calculate = new CalculateParkKo();

	@Test
	public void testCalculateParkHours_Bangkok() {
		String timeBangkokStart = "24/12/2014 01:50 PM";
		String timeBangkokEnd = "26/12/2014 04:02 PM";
		
		Timestamp startTime = DateTimeHelper.getTimestamp(timeBangkokStart);
		Timestamp endTime = DateTimeHelper.getTimestamp(timeBangkokEnd);
		
		int expectedHour = 51;
		int actualHour = calculate.calculateRoundUpParkHour(startTime, endTime);
		assertEquals(expectedHour, actualHour);
	}

}
